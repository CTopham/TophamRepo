from multiprocessing import Value
from threading import Timer
from utils import States
import multiprocessing
import random
import socket
import time
import utils

#Craig Topham PA3 Computer Networking

#UDP_IP = "54.221.233.70"
UDP_IP = "127.0.0.1"
UDP_PORT = 5005
MSS = 14 # maximum segment size

sock = socket.socket(socket.AF_INET,    # Internet
                     socket.SOCK_DGRAM) # UDP

def recv_msg():
  data, addr = sock.recvfrom(1024)
  header = utils.bits_to_header(data)
  body = utils.get_body_from_data(data)
  return (header, body, addr)

#
def send_udp(message):
  sock.sendto(message, (UDP_IP, UDP_PORT))

class Client:
  def __init__(self):
    self.client_state = States.CLOSED
    self.last_received_ack = 0
    self.last_received_seq_num = 0
    self.handshake()

  def handshake(self):
    while self.client_state != States.ESTABLISHED:
        if self.client_state == States.CLOSED:
            seq_num = utils.rand_int()
            self.next_seq_num = seq_num + 1
            syn_header = utils.Header(seq_num, 0, syn = 1, ack = 0, fin = 0)
      # for this case we send only header;
      # if you need to send data you will need to append it
            send_udp(syn_header.bits())
            self.update_state(States.SYN_SENT)
        elif self.client_state == States.SYN_SENT:
            recv_data, addr = sock.recvfrom(1024)
            syn_ack_header = utils.bits_to_header(recv_data)
            self.last_received_seq_num = syn_ack_header.seq_num
            if syn_ack_header.syn == 1 and syn_ack_header.ack == 1:
                ack_header = utils.Header(self.next_seq_num, self.last_received_seq_num + 1, syn = 0, ack = 1, fin = 0)
                self.next_seq_num += 1
                send_udp(ack_header.bits())
                self.update_state(States.ESTABLISHED)
    else:
      pass

  def terminate(self):
      while self.client_state != States.CLOSED:
          if self.client_state == States.ESTABLISHED:
              terminate_header = utils.Header(self.next_seq_num, self.last_received_seq_num + 1, syn = 0, ack = 1, fin = 1)
              self.next_seq_num += 1
              send_udp(terminate_header.bits())
              self.update_state(States.FIN_WAIT_1)
          elif self.client_state == States.FIN_WAIT_1:
              recv_data, addr = sock.recvfrom(1024)
              fin_ack_header = utils.bits_to_header(recv_data)
              self.last_received_seq_num = fin_ack_header.seq_num
              if fin_ack_header.ack == 1:
                  self.update_state(States.FIN_WAIT_2)
          elif self.client_state == States.FIN_WAIT_2:
              recv_data, addr = sock.recvfrom(1024)
              fin_fin_header = utils.bits_to_header(recv_data)
              self.last_received_seq_num = fin_fin_header.seq_num
              if fin_fin_header.fin == 1:
                  terminate_ack_header = utils.Header(self.next_seq_num, self.last_received_seq_num + 1, syn = 0, ack = 1, fin = 0)
                  self.next_seq_num += 1
                  send_udp(terminate_ack_header.bits())
                  self.update_state(States.CLOSED)
          else:
              pass

  def update_state(self, new_state):
    if utils.DEBUG:
      print(self.client_state, '->', new_state)
    self.client_state = new_state

  def send_reliable_message(self, message):
    count= 0
    MSS = 2

    # split the message into chunks
    msg = message.split()

    #seq number
    seq_num = utils.rand_int()

    # Create the header we attach to our message
    msg_header = utils.Header(seq_num, 0, syn = 0, ack = 1, fin = 0)

    # Send initial chunk
    chunk = msg[count:count + 3]
    chunk = ','.join(chunk[0:2])
    send_udp(msg_header.bits() + chunk.replace(",", " ").encode())
    count += 2
  
    while count <= 7:
      #handle seq / ack 
      recv_data, addr = sock.recvfrom(1024) #receive the data sent from the server
      msg_header = utils.bits_to_header(recv_data) #convert received data to header format
      firstseq = msg_header.seq_num  # first msg seq number
      if msg_header.seq_num == firstseq or msg_header.seq_num == subseq:  #check current seq numb from previous, make sure increments by 1
        chunk = msg[MSS:MSS + 3] # 
        chunk = ','.join(chunk[0:2])
        send_udp(msg_header.bits() + chunk.replace(",", " ").encode())
        count += 2
        MSS += 2
        subseq = msg_header.seq_num + 1
      else: #if seq are not incrementing correctly then send previous chunk again
        print(msg_header.seq_num) #just printing out the seq number
        MSS -= 2
        chunk = msg[MSS:MSS - 3] # 
        chunk = ','.join(chunk[0:2])
        send_udp(msg_header.bits() + chunk.replace(",", " ").encode())


    #handle stop and wait
    pass

  # these two methods/function can be used receive messages from
  # server. the reason we need such mechanism is `recv` blocking
  # and we may never recieve a package from a server for multiple
  # reasons.
  # 1. our message is not delivered so server cannot send an ack.
  # 2. server responded with ack but it's not delivered due to
  # a network failure.
  # these functions provide a mechanism to receive messages for
  # 1 second, then the client can decide what to do, like retransmit
  # if not all packets are acked.
  # you are free to implement any mechanism you feel comfortable
  # especially, if you have a better idea ;)
  def receive_acks_sub_process(self, lst_rec_ack_shared):
    while True:
      recv_data, addr = sock.recvfrom(1024)
      header = utils.bits_to_header(recv_data)
      if header.ack_num > lst_rec_ack_shared.value:
        lst_rec_ack_shared.value = header.ack_num

  def receive_acks(self):
    # Start receive_acks_sub_process as a process
    lst_rec_ack_shared = Value('i', self.last_received_ack)
    p = multiprocessing.Process(target=self.receive_acks_sub_process, args=(lst_rec_ack_shared,))
    p.start()
    # Wait for 1 seconds or until process finishes
    p.join(1)
    # If process is still active, we kill it
    if p.is_alive():
      p.terminate()
      p.join()
    # here you can update your client's instance variables.
    self.last_received_ack = lst_rec_ack_shared.value

# we create a client, which establishes a connection
client = Client()
# we send a message
client.send_reliable_message("This message is to be received in pieces")
# we terminate the connection
client.terminate()