#! /usr/bin/env python

import sys
import time
from scapy.all import *
#print("length %s " % (len(sys.argv)))
if (len(sys.argv) != 5):
   print("Program expects 4 input, (1) SourceIP, (2) DestinationIP, (3) Packets To be sent, (4) Destination Port")
   print("Example: sudo python generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222")
   sys.exit(1)
srcIP = sys.argv[1]
dstIP = sys.argv[2]

print "source IP: " +srcIP +" dstination IP: "+dstIP

pktCount = int(sys.argv[3])
dport=int(sys.argv[4])
#print(srcIP, dstIP)
#print("Now sending packet")

#ethPkt = Ether(src="00:00:00:00:00:01")
ipPkt = IP(src=srcIP, dst=dstIP)
udpPkt = UDP(dport=dport)
while(True):
   pkt_list = []
   for i in range(0,pktCount):
      pkt = Ether()/ipPkt/udpPkt
      pkt_list.append(pkt)
   print("----Sending %s UDP packets----" % (pktCount))
   #sendp(pkt_list,iface="s6-eth3")
   sendp(pkt_list)
   time.sleep(0.2)

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
