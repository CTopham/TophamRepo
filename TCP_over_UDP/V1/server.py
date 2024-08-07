import socket
import utils
from utils import States

UDP_IP = "127.0.0.1"
UDP_PORT = 5005
# initial state of the server
server_state = States.CLOSED
last_received_seq_num = 0

sock = socket.socket(socket.AF_INET,    # Internet
                     socket.SOCK_DGRAM) # UDP

sock.bind((UDP_IP, UDP_PORT)) # wait for connection

def update_server_state(new_state):
  global server_state
  if utils.DEBUG:
    print(server_state, '->', new_state)
  server_state = new_state

def recv_msg():
  data, addr = sock.recvfrom(1024)
  header = utils.bits_to_header(data)
  body = utils.get_body_from_data(data)
  return (header, body, addr)

while True:
  if server_state == States.CLOSED:
    update_server_state(States.LISTEN)
  elif server_state == States.LISTEN:
    header, body, addr = recv_msg()
    last_received_seq_num = header.seq_num
    if header.syn == 1:
      seq_number = utils.rand_int()
      syn_ack_msg = utils.Header(seq_number, ack_num = last_received_seq_num + 1, syn = 1, ack = 1, fin = 0)
      seq_number += 1
      sock.sendto(syn_ack_msg.bits(), addr)
      update_server_state(States.SYN_RECEIVED)
  elif server_state == States.SYN_RECEIVED:
    header, body, addr = recv_msg()
    last_received_seq_num = header.seq_num
    if header.ack == 1:
      update_server_state(States.ESTABLISHED)
    pass
  elif server_state == States.SYN_SENT:
    pass
  elif server_state == States.ESTABLISHED:
    header, body, addr = recv_msg()
    last_received_seq_num = header.seq_num
    if header.fin == 1:
      fin_ack_msg = utils.Header(seq_number, last_received_seq_num + 1, syn = 0, ack = 1, fin = 0)
      seq_number += 1
      sock.sendto(fin_ack_msg.bits(), addr)
      update_server_state(States.CLOSE_WAIT)
    else:
      pass
  elif server_state == States.CLOSE_WAIT:
    fin_fin_msg = utils.Header(seq_number, last_received_seq_num + 1, syn = 0, ack = 1, fin = 1)
    seq_number += 1
    sock.sendto(fin_fin_msg.bits(), addr)
    update_server_state(States.LAST_ACK)
  elif server_state == States.LAST_ACK:
    header, body, addr = recv_msg()
    last_received_seq_num = header.seq_num
    if header.ack == 1:
      update_server_state(States.CLOSED)
  else:
    pass
