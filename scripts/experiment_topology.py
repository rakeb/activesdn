#!/usr/bin/python
#  coding: utf-8

from mininet.topo import Topo
from mininet.cli import CLI
from mininet.log import lg, info, setLogLevel
from mininet.util import irange,dumpNodeConnections
from mininet.net import Mininet
from mininet.node import OVSKernelSwitch
from mininet.node import CPULimitedHost
from mininet.link import TCLink
#from mininet.topolib import TreeTopo
from mininet.node import Controller, RemoteController
from mininet.link import TCLink
import time
import os
import sys
from collections import defaultdict

class MyTopo( Topo ):
    "Simple topology example."

    def __init__( self ):
        "Create custom topo."

        # Initialize topology
        Topo.__init__( self )

        # Add hosts and switches
        host1 = self.addHost( 'h1' )
        host2 = self.addHost( 'h2' )
	host3 = self.addHost( 'h3' )
	host4 = self.addHost( 'h4' )
        host5 = self.addHost( 'h5' )
        host6 = self.addHost( 'h6' )
	host7 = self.addHost( 'h7' )
	host8 = self.addHost( 'h8' )
	host9 = self.addHost( 'h9' )
        host10 = self.addHost( 'h10' )
	host11 = self.addHost( 'h11' )
	host12 = self.addHost( 'h12' )
        host13 = self.addHost( 'h13' )
	host14 = self.addHost( 'h14' )

        switch1 = self.addSwitch( 's1' )
        switch2 = self.addSwitch( 's2' )
	switch3 = self.addSwitch( 's3' )
        switch4 = self.addSwitch( 's4' )
	switch5 = self.addSwitch( 's5' )
        switch6 = self.addSwitch( 's6' )
        switch7 = self.addSwitch( 's7' )
        switch8 = self.addSwitch( 's8' )
	switch9 = self.addSwitch( 's9' )
        switch10 = self.addSwitch( 's10' )
        switch11 = self.addSwitch( 's11' )                                  
        '''
        # 10 Mbps, 5ms delay, 1% loss,7 1000 packet queue
           self.addLink( host, switch, bw=10, delay='5ms', loss=1, max_queue_size=1000, use_htb=True)
           if lastSwitch:
               self.addLink(switch, lastSwitch, bw=10, delay='5ms', loss=1, max_queue_size=1000, use_htb=True)
           lastSwitch = switch
        '''
        # Add links
        self.addLink( host1, switch6)
	self.addLink( host2, switch6)
	self.addLink( host3, switch6)
        self.addLink( host13, switch6)

	self.addLink( host4, switch7)
	self.addLink( host5, switch7)
	self.addLink( host6, switch7)
        self.addLink( host14, switch7)

	self.addLink( host7, switch10)
	self.addLink( host8, switch10)
	self.addLink( host9, switch10)

	self.addLink( host10, switch11)
	self.addLink( host11, switch11)
	self.addLink( host12, switch11)


        self.addLink( switch6, switch4, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch6, switch5, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch7, switch4, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch7, switch5, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)

        self.addLink( switch4, switch1, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch4, switch2, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch4, switch3, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)

        self.addLink( switch5, switch1, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch5, switch2, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch5, switch3, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)

        self.addLink( switch10, switch8, use_htb=True)#bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch10, switch9, use_htb=True)#bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch11, switch8, use_htb=True)#bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch11, switch9, use_htb=True)#bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)

        self.addLink( switch8, switch1, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch8, switch2, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch8, switch3, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)

        self.addLink( switch9, switch1, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch9, switch2, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch9, switch3, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
'''
def ifconfigTest( net ):
    "Run ifconfig on all hosts in net."
    hosts = net.hosts
    for host in hosts:
        info( host.cmd( 'ifconfig' ) )
'''

def pingTest( net ):
    "Testing ping functionality"
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

    time.sleep(15)
    host1.cmd('bash host1.sh &')
    time.sleep(15)
    host2.cmd('bash host2.sh &')
    time.sleep(15)
    host4.cmd('bash host4.sh &')
    time.sleep(3)
    host10.cmd('bash host10_tcp.sh &')
    time.sleep(10)
    host5.cmd('bash host5.sh &')
    time.sleep(3)
    host10.cmd('bash host10_udp.sh &')
    #cmd = "read -p 'press any key to start sending elephant flows'"
    #os.popen(cmd)
    time.sleep(40)
    host7.cmd('bash host7.sh')
    #new comers test start here
    host3.cmd('bash host3.sh &')
    time.sleep(3)
    host6.cmd('bash host6.sh &')
    time.sleep(3)
    host13.cmd('bash host13.sh &')
    time.sleep(3)
    host14.cmd('bash host14.sh &')

def find_all(a_str, sub_str):
    start = 0
    b_starts = []
    while True:
        start = a_str.find(sub_str, start)
        if start == -1: return b_starts
        #print start
        b_starts.append(start)
        start += 1

#///////////////////////////////////////
def createLineArray(subStr):
    start = 0
    lineArray = []
    while True:
        lineEnd = subStr.find("\n", start)
        if lineEnd == -1: return lineArray
        line = subStr[start:lineEnd]
        lineArray.append(line)
        start = lineEnd + 1
        #if "Bridge" in line:
        #    print(line)
        #if "Port" in line:
        #    print(line)
        
'''
Add queues to Mininet using ovs-vsctl and ovs-ofctl
Thanks to code from @Author Ryan Wallner, it really helped
'''
def createQueues():
    if os.getuid() != 0:
        print "Root permissions required"
        exit()

    cmd = "ovs-vsctl show"
    p = os.popen(cmd).read()
    configuration = []
    configuration = createLineArray(p)
   
    switches = []
    for line in configuration:
        if "Bridge" in line:
            #print(line)
            start = line.find('"' , 0)
            #print(start)
            sw =  line[start + 1:len(line) - 1]
            switches.append(sw)
	    print (sw)
    
    prts = []
    for line in configuration:
        if "Port" in line:
            if "eth" in line:
                #print(line)
                start = line.find('"', 0)
                prt = line[start + 1:len(line) - 1]
                prts.append(prt)
                #print(prt)
    
    config_strings = defaultdict(list)
    for i in range(len(switches)):
        tempStr = ""
        sw = switches[i] + "-eth"
        for n in range(len(prts)):
            #verify correct order
            if sw in prts[n]:
                #print switches[i]
                #print prts[n]
                port_name = prts[n]
                tempStr = tempStr + " -- set port %s qos=@defaultqos" % port_name
	#print(tempStr)
        config_strings[switches[i]].append(tempStr)
        #print("\n")
        #print(config_strings[switches[i]][0])

    for sw in switches:
        queuecmd = "sudo ovs-vsctl %s -- --id=@defaultqos create qos type=linux-htb other-config:max-rate=1000000000 queues=0=@q0,1=@q1 -- --id=@q0 create queue other-config:min-rate=100000000 other-config:max-rate=1000000000 -- --id=@q1 create queue other-config:max-rate=2" % config_strings[sw][0]
        q_res = os.popen(queuecmd).read()
        print q_res
	#print("\n")
	#print(queuecmd)
	#print("\n")

    #cmd2 = "ovs-vsctl list port"
    #p = os.popen(cmd2).read()
    #print p
    

    '''

           for sw in switches:
        queuecmd = "sudo ovs-vsctl %s -- --id=@defaultqos create qos type=linux-htb other-config:max-rate=1000000000 queues=0=@q0,1=@q1,2=@q2 -- --id=@q0 create queue other-config:min-rate=1000000000 other-config:max-rate=1000000000 -- --id=@q1 create queue other-config:max-rate=20000000 -- --id=@q2 create queue other-config:max-rate=2000000 other-config:min-rate=2000000" % config_strings[sw]

       Set the qos column of the Port record for eth0 to point to  a  new  QoS
       record, which in turn points with its queue 0 to a new Queue record:

              ovs-vsctl  --  set  port eth0 qos=@newqos -- --id=@newqos create
              qos         type=linux-htb         other-config:max-rate=1000000
              queues:0=@newqueue  --  --id=@newqueue  create  queue other-con‐
              fig:min-rate=1000000 other-config:max-rate=1000000


        ovs-vsctl set port s1-eth2 qos=@newqos -- --id=@newqos create qos type=linux-htb other-config:max-rate=5000000000 queues=0=@q0,1=@q1 -- --id=@q0 create queue other-config:max-rate=5000000000 -- --id=@q1 create queue other-config:max-rate=20000000
      '''
#////////////////////////////////////////////

def simpleTest():
    "Create and test a simple network"
    topo = MyTopo()
    net = Mininet(topo, link=TCLink, switch=OVSKernelSwitch, controller=RemoteController)
    #net = Mininet(topo=topo, link=TCLink)
    net.start()
    print "Dumping host connections"
    dumpNodeConnections(net.hosts)
    print "Testing network connectivity"
    #ifconfigTest(net)
    createQueues()
    #pingTest(net)
    #net.pingAll()
    
    CLI(net)
    net.stop()
    p = os.popen("sudo mn -c").read()
    print(p)

if __name__ == '__main__':
    # Tell mininet to print useful information
    setLogLevel('info')
    simpleTest()
