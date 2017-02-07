#! /usr/bin/env python

import sys
import time
from scapy.all import *
import time

#print("length %s " % (len(sys.argv)))
if (len(sys.argv) != 4):
   print("Program expects 4 input, (1) SourceIP, (2) DestinationIP, (3) Packets To be sent")
   print("Example: sudo python generate_dropBox_Login_Test_traffic.py 10.0.0.1 10.0.0.10 1")
   print("Exiting...")
   time.sleep(15)
   sys.exit(1)
srcIP = sys.argv[1]
dstIP = sys.argv[2]
pktCount = int(sys.argv[3])
dport=100

numPacket = 1
#print(srcIP, dstIP)
#print("Now sending packet")

#ethPkt = Ether(src="00:00:00:00:00:01",dst="00:00:00:00:00:02")
ipPkt = IP(src=srcIP, dst=dstIP)
tcpPkt = TCP(dport=dport)
data = "This is simple world payload message"
pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
#pkt = ipPkt/tcpPkt/Raw(load=data)
#pkt_list.append(pkt)
print("Sending SYN TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
numPacket +=1
#sendp(pkt_list,iface="s6-eth3")
#sendp(pkt)
sendp(pkt)
time.sleep(3)

data = "This is complex world payload message"
pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
print("Sending TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
numPacket +=1
sendp(pkt)
time.sleep(3)
data = "This is Rakeb world payload message"
pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
print("Sending TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
numPacket +=1
sendp(pkt)
time.sleep(3)
data = "This is Fida world payload message"
pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
print("Sending TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
numPacket +=1
sendp(pkt)
time.sleep(3)
data = "This is malicious payload message"
pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
print("Sending TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
numPacket +=1
sendp(pkt)
time.sleep(3)
data = "This is random world 1 payload message"
pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
print("Sending TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
numPacket +=1
sendp(pkt)
time.sleep(3)
data = "This is random world 2 payload message"
pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
print("Sending TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
numPacket +=1
sendp(pkt)
time.sleep(3)
data = "This is random world 3 payload message"
pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
print("Sending TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
numPacket +=1
sendp(pkt)
time.sleep(3)
data = "This is random world 4 payload message"
pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
print("Sending TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
numPacket +=1
sendp(pkt)

for i in range(0,10):
    time.sleep(3)
    data = "This is random world " + str(numPacket) + " payload message"
    pkt = Ether()/ipPkt/tcpPkt/Raw(load=data)
    print("Sending TCP Packet: %d packet for dropbox (Destination Port 100) with payload: %s " % (numPacket, data))
    numPacket +=1
    sendp(pkt)
#time.sleep(1)

'''
from scapy.all import sr1,IP,ICMP

pingr = IP(dst=sys.argv[1])/ICMP()
successful = 0
unsuccessful = 0
for i in range(1,1000):
   p = sr1(pingr)
   if p:
      successful = successful + 1
   else:
      unsuccessful = unsuccessful + 1
      #p.show()
print("Successful Packets %s , Unsuccessful Packets %s " % (successful, unsuccessful))
''' 
