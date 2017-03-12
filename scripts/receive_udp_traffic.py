#! /usr/bin/env python

from scapy.all import *
import sys

udp_pktCount = 0
#tcp_pktCount = 0

#dport1=int(sys.argv[1])
dport2=int(sys.argv[1])
def print_summary(pkt):
   global udp_pktCount
   #global tcp_pktCount
   
   if IP in pkt:
      ip_src = pkt[IP].src
      ip_dst = pkt[IP].dst
   if UDP in pkt:
      udp_dst_port = pkt[UDP].dport
      udp_pktCount = udp_pktCount + 1
      print ("Src IP %s ---- Dst IP %s ----- UDP Port %s" % (ip_src, ip_dst, udp_dst_port))
      print ("Received UDP Packet Count %s" % (udp_pktCount))
   #if TCP in pkt:
   #   tcp_dst_port = pkt[TCP].dport
   #   tcp_pktCount = tcp_pktCount + 1
   #   print ("Src IP %s ---- Dst IP %s ----- TCP Port %s" % (ip_src, ip_dst, tcp_dst_port))
   #   print ("TCP Packet Count %s" % (tcp_pktCount))

#filter_value = 'dst port ' + str(dport1) + ' or dst port ' + str(dport2)
filter_value = 'dst port ' + str(dport2)
sniff(filter = filter_value, prn=print_summary)
#sniff(filter = "dst port 22222 or dst port 22223", prn=print_summary)
