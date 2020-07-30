import socket
import utils


UDP_IP = "127.0.0.1"
UDP_PORT = 5005

#Craig Topham
# initial server_state
server_state = utils.States.CLOSED
last_received_seq_num = 0 

sock = socket.socket(socket.AF_INET,    # Internet
                     socket.SOCK_DGRAM) # UDP

sock.bind((UDP_IP, UDP_PORT)) # wait for connection

# Some helper functions to keep the code clean and tidy
def update_server_state(new_state):
  global server_state
  if utils.DEBUG:
    print(server_state, '->', new_state)
  server_state = new_state

# Receive a message and return header, body and addr
# addr is used to reply to the client
# this call is blocking
def recv_msg():
  data, addr = sock.recvfrom(1024)
  header = utils.bits_to_header(data)
  body = utils.get_body_from_data(data)
  return (header, body, addr)

#TODO
# the server runs in an infinite loop and takes
# action based on current state and updates its state
# accordingly
# You will need to add more states, please update the possible
# states in utils.py file
while True:
  if server_state == utils.States.CLOSED:
    # we already started listening, just update the state
    update_server_state(utils.States.LISTEN)
  elif server_state == utils.States.LISTEN:
    # we are waiting for a message
    header, body, addr = recv_msg()
    last_received_seq_num = header.seq_num
    # if received message is a syn message, it's a connection
    # initiation
    if header.syn == 1:
      seq_number = utils.rand_int() # we randomly pick a sequence number
      syn_ack_msg = utils.Header(seq_number, ack_num =
      last_received_seq_num + 1, syn =1, ack = 1, fin = 0)
      seq_number += 1
      sock.sendto(syn_ack_msg.bits(), addr)
      update_server_state(utils.States.SYN_RECEIVED)
      ack_number = header.seq_num + 1
      chunk = utils

      # to be implemented
      
      ### sending message from the server:
      #   use the following method to send messages back to client
      #   addr is recieved when we receive a message from a client (see above)
      #   sock.sendto(your_header_object.bits(), addr)
      

  elif server_state == utils.States.SYN_RECEIVED:
      header, body, addr = recv_msg()
      last_received_seq_num = header.seq_num
      if header.ack == 1:
          update_server_state(utils.States.ESTABLISHED)
          pass
  elif server_state == utils.States.SYN_SENT:
      pass
  elif server_state == utils.States.ESTABLISHED:
      header, body, addr = recv_msg()
      last_received_seq_num = header.seq_num
      if header.fin == 1:
          fin_ack_msg = utils.Header(seq_number,
          last_received_seq_num + 1, syn = 0, ack = 1, fin = 0)
          seq_number += 1
          sock.sendto(fin_ack_msg.bits(), addr)
          update_server_state(utils.States.CLOSE_WAIT)
      else:
          chunk.receive_ack()
          bits_received = len(body)
          ack_msg = utils.Header(seq_number,
          last_received_seq_num + 1, syn = 0, ack = 1, fin = 0)
          seq_number += 1
          sock.sendto(ack_msg.bits(), addr)
          chunk.receives_ack()
          
  elif server_state == utils.States.CLOSE_WAIT:
      fin_fin_msg = utils.Header(seq_number,
      last_received_seq_num + 1, syn = 0, ack = 1, fin = 1)
      seq_number += 1
      sock.sendto(fin_fin_msg.bits(), addr)
      update_server_state(utils.States.LAST_ACK)
  elif server_state == utils.States.LAST_ACK:
      header, body, addr = recv_msg()
      last_received_seq_num = header.seq_num
      if header.ack == 1:
          update_server_state(utils.States.CLOSED)
  else:
      pass
