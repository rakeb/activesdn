#!/usr/bin/python
#  coding: utf-8

from mininet.topo import Topo
from mininet.cli import CLI
from mininet.log import lg, info, setLogLevel
from mininet.util import irange, dumpNodeConnections
from mininet.net import Mininet
from mininet.node import OVSKernelSwitch
from mininet.node import CPULimitedHost
from mininet.link import TCLink
# from mininet.topolib import TreeTopo
from mininet.node import Controller, RemoteController
from mininet.link import TCLink
import time
import os
import sys
from collections import defaultdict


class MyTopo(Topo):
    def __init__(self):
        # "Create custom topo."

        # Initialize topology
        Topo.__init__(self)

        # Add hosts and switches
        host1 = self.addHost('h1')
        host2 = self.addHost('h2')
        host3 = self.addHost('h3')
        host4 = self.addHost('h4')
        host5 = self.addHost('h5')
        host6 = self.addHost('h6')
        host7 = self.addHost('h7')
        host8 = self.addHost('h8')
        host9 = self.addHost('h9')
        host10 = self.addHost('h10')
        host11 = self.addHost('h11')
        host12 = self.addHost('h12')
        host13 = self.addHost('h13')
        host14 = self.addHost('h14')

        switch1 = self.addSwitch('s1')
        switch2 = self.addSwitch('s2')
        switch3 = self.addSwitch('s3')
        switch4 = self.addSwitch('s4')
        switch5 = self.addSwitch('s5')
        switch6 = self.addSwitch('s6')
        switch7 = self.addSwitch('s7')
        switch8 = self.addSwitch('s8')
        switch9 = self.addSwitch('s9')
        switch10 = self.addSwitch('s10')
        switch11 = self.addSwitch('s11')
        '''
        # 10 Mbps, 5ms delay, 1% loss,7 1000 packet queue
           self.addLink( host, switch, bw=10, delay='5ms', loss=1, max_queue_size=1000, use_htb=True)
           if lastSwitch:
               self.addLink(switch, lastSwitch, bw=10, delay='5ms', loss=1, max_queue_size=1000, use_htb=True)
           lastSwitch = switch
        '''
        # Add links
        self.addLink(host1, switch6)
        self.addLink(host2, switch6)
        self.addLink(host3, switch6)
        self.addLink(host13, switch6)

        self.addLink(host4, switch7)
        self.addLink(host5, switch7)
        self.addLink(host6, switch7)
        self.addLink(host14, switch7)

        self.addLink(host7, switch10)
        self.addLink(host8, switch10)
        self.addLink(host9, switch10)

        self.addLink(host10, switch11)
        self.addLink(host11, switch11)
        self.addLink(host12, switch11)

        self.addLink(switch6, switch4, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch6, switch5, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch7, switch4, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch7, switch5, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)

        self.addLink(switch4, switch1, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch4, switch2, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch4, switch3, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)

        self.addLink(switch5, switch1, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch5, switch2, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch5, switch3, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)

        self.addLink(switch10, switch8, use_htb=True)  # bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch10, switch9, use_htb=True)  # bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch11, switch8, use_htb=True)  # bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch11, switch9, use_htb=True)  # bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)

        self.addLink(switch8, switch1, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch8, switch2, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch8, switch3, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)

        self.addLink(switch9, switch1, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch9, switch2, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink(switch9, switch3, use_htb=True)  # bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)


'''
def ifconfigTest( net ):
    "Run ifconfig on all hosts in net."
    hosts = net.hosts
    for host in hosts:
        info( host.cmd( 'ifconfig' ) )
'''


def dropBoxLoginTest(net):
    "For DropBox Login test: Testing ping functionality"
    host1 = net.hosts[0]
    host2 = net.hosts[1]
    host3 = net.hosts[2]
    host4 = net.hosts[3]
    host5 = net.hosts[4]
    host6 = net.hosts[5]
    host7 = net.hosts[6]
    host10 = net.hosts[9]
    host12 = net.hosts[11]
    host13 = net.hosts[12]
    host14 = net.hosts[13]

    # time.sleep(15)
    host7.cmd('bash host7.sh')
    # host1.cmd('bash host1.sh &')
    # time.sleep(15)
    host1.cmd('bash host1.sh &')
    host12.cmd('bash host12.sh &')
    time.sleep(10)
    host1.cmd('bash host1_send_traffic_to_dropBox.sh &')


def simpleTest():
    topo = MyTopo()
    net = Mininet(topo, link=TCLink, switch=OVSKernelSwitch, controller=RemoteController)
    net.start()
    dumpNodeConnections(net.hosts)
    dropBoxLoginTest(net)

    CLI(net)
    net.stop()
    p = os.popen("sudo mn -c").read()
    print(p)


if __name__ == '__main__':
    setLogLevel('info')
    simpleTest()

