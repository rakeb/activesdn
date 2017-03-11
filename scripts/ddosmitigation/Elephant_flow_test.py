#!/usr/bin/python
#  coding: utf-8

from experiment_topology import net
#import experiment_topology

#net = experiment_topology.net

host1 = net.hosts[0]
host2 = net.hosts[1]
host3 = net.hosts[2]
host4 = net.hosts[3]
host5 = net.hosts[4]
host6 = net.hosts[5]
host7 = net.hosts[6]
host10 = net.hosts[9]
host13 = net.hosts[12]
host14 = net.hosts[13]

time.sleep(3)
host10.cmd('bash host10_tcp.sh &')

time.sleep(3)
host10.cmd('bash host10_udp.sh &')

time.sleep(15)
host4.cmd('bash host4.sh &')

time.sleep(10)
host5.cmd('bash host5.sh &')
