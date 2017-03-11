#!/usr/bin/python
from scapy.all import *
import time as Time
from time import *

TIMEOUT = 1
conf.verb = 0
icmp = ICMP()
icmp.type = 8
icmp.code = 0
for i in range(0, 256):
    for j in range(0, 20):
        packet = IP(dst="10.0.0.10", ttl=20)/icmp
        t1=time()
        reply = sr1(packet, timeout=TIMEOUT)
        t2=time()
        if not (reply is None):
            t3 = (t2 - t1) * 1000
            print("%s %.5s ms" % (reply.summary(), str(t3)))
        else:
            print "Timeout waiting for %s" % packet[IP].dst
    Time.sleep(2)
