from multiprocessing import Value
from threading import Timer
import threading
from utils import States
import multiprocessing
import random
import socket
import time
import utils

UDP_IP = "127.0.0.1"
UDP_PORT_CHANNEL = 5007
UDP_PORT_SERVER = 5008

# bidirectional channel sitting between client and server
# client talks to channel, then channel to server
# server talks to channel, then channel to client
# channel binds to UDP_PORT_CHANNEL to listen to client
# server binds to UDP_PORT_SERVER to listen to channel
# responses go back to auto-generated ports at client and channel

sock_client = socket.socket(socket.AF_INET,    # Internet
					 socket.SOCK_DGRAM) # UDP

sock_client.bind((UDP_IP, UDP_PORT_CHANNEL)) # wait for connection

sock_server = socket.socket(socket.AF_INET,    # Internet
					 socket.SOCK_DGRAM) # UDP

sleep_v = 0.25

round = 0
wait_send = 0
addr_client = []

# client listener/sender, forwards client messages to server
def chan_client():
	global sock_client, sock_server, wait_send, addr_client
	while True:
		print('waiting on client')
		data_client, addr_client = sock_client.recvfrom(1024)
		
		header = utils.bits_to_header(data_client)
		
		print(addr_client)
		print(addr_client[0]) # ip
		print(addr_client[1]) # port
		time.sleep(sleep_v)

		# drop messages randomly, after connection established
		#if round >= 2 and random.randint(1,10) <= 3:
		if round >= 2 and (header.ack == 0 and header.syn == 0 and header.fin == 0) and random.randint(1,10) <= 3:
			print("DROPPING MESSAGE FROM CLIENT")
			continue

		print('forwarding to server')
		sock_server.sendto(data_client, (UDP_IP, UDP_PORT_SERVER))
		time.sleep(sleep_v)
		wait_send = 1

# server listener/sender, forwards server messages to client
def chan_server():
	global sock_client, sock_server, wait_send, addr_client, round
	while True:
		# need to wait until initial client message sent
		# to server, otherwise socket from server 
		# is not valid (so sock_server.recvfrom will error)
		while wait_send == 0:
			pass
		print('waiting on server response')
		data_server, addr_server = sock_server.recvfrom(1024)
		
		header = utils.bits_to_header(data_server)
		
		if round >= 2 and (header.ack == 1 and header.syn == 0 and header.fin == 0) and random.randint(1,10) <= 3:
			print("DROPPING ACK FROM SERVER")
			continue
		
		print(addr_server)
		print('forwarding to client')
		time.sleep(sleep_v)
		sock_client.sendto(data_server, (UDP_IP, addr_client[1]))
		time.sleep(sleep_v)
		round = round + 1

t_client = threading.Thread(target=chan_client)
t_server = threading.Thread(target=chan_server)

t_client.start()
time.sleep(2)
t_server.start()

print("ran")

while True:
	time.sleep(0.5)
	print("ongoing")