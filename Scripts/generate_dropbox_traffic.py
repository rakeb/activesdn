#! /usr/bin/env python

import sys
import time
from scapy.all import *
#print("length %s " % (len(sys.argv)))
if (len(sys.argv) != 4):
   print("Program expects 4 input, (1) SourceIP, (2) DestinationIP, (3) Packets To be sent")
   print("Example: sudo python generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100")
   sys.exit(1)
srcIP = sys.argv[1]
dstIP = sys.argv[2]
pktCount = int(sys.argv[3])
dport=100
#print(srcIP, dstIP)
#print("Now sending packet")

#ethPkt = Ether(src="00:00:00:00:00:01",dst="00:00:00:00:00:02")
ipPkt = IP(src=srcIP, dst=dstIP)
tcpPkt = TCP(dport=dport)
#pkt = Ether()/ipPkt/tcpPkt
pkt = ipPkt/tcpPkt/"this is hello world"
#pkt_list.append(pkt)
print("----Sending TCP SYN packet from dropbox (Destination Port 100)")
#sendp(pkt_list,iface="s6-eth3")
#sendp(pkt)
sr(pkt)
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
