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
import time
import subprocess

class MyTopo( Topo ):
    "Simple topology example."

    def __init__( self ):
        "Create custom topo."

        # Initialize topology
        Topo.__init__( self )

        # Add hosts and switches
        self.host1 = self.addHost( 'h1' )
        self.host2 = self.addHost( 'h2' )
	self.host3 = self.addHost( 'h3' )
	
        self.switch1 = self.addSwitch( 's1' )
        self.switch2 = self.addSwitch( 's2' )
	self.switch3 = self.addSwitch( 's3' )
        
        # Add links
        self.addLink( self.host1, self.switch1)
	self.addLink( self.host2, self.switch2)
	self.addLink( self.host3, self.switch3)

        self.addLink( self.switch1, self.switch2)
	self.addLink( self.switch2, self.switch3)

'''
def ifconfigTest( net ):
    "Run ifconfig on all hosts in net."
    hosts = net.hosts
    for host in hosts:
        info( host.cmd( 'ifconfig' ) )
'''

def find_all(a_str, sub_str):
    start = 0
    b_starts = []
    while True:
        start = a_str.find(sub_str, start)
        if start == -1: return b_starts
        #print start
        b_starts.append(start)
        start += 1

def pingTest( net ):
    "Testing ping functionality"
    host1 = net.hosts[0]
    host2 = net.hosts[2]
    #ab = host1.cmd('ping -c5 10.0.0.3')
    host1.cmd('bash test.sh &')
    host2.cmd('bash test2.sh &')
    #print(ab)

#///////////////////////////////////////
def createQueues():
    if os.getuid() != 0:
        print "Root permissions required"
        exit()

    cmd = "ovs-vsctl show"
    p = os.popen(cmd).read()
    #print p

    brdgs = find_all(p, "Bridge")
    print brdgs

    switches = []
    for bn in brdgs:
        sw =  p[(bn+8):(bn+10)]
        switches.append(sw)
	print (sw)

    ports = find_all(p,"Port")
    print ports

    prts = []
    for prt in ports:
        prt = p[(prt+6):(prt+13)]
        if '"' not in prt:
            print prt
            prts.append(prt)

    config_strings = {}
    for i in range(len(switches)):
        str = ""
        sw = switches[i]
        for n in range(len(prts)):
            #verify correct order
            if switches[i] in prts[n]:
                #print switches[i]
                #print prts[n]
                port_name = prts[n]
                str = str+" -- set port %s qos=@defaultqos" % port_name
	        print(str)
        config_strings[sw] = str

    #build queues per sw
    #print config_strings

    for sw in switches:
        queuecmd = "sudo ovs-vsctl %s -- --id=@defaultqos create qos type=linux-htb other-config:max-rate=1000000000 queues=0=@q0,1=@q1,2=@q2 -- --id=@q0 create queue other-config:min-rate=1000000000 other-config:max-rate=1000000000 -- --id=@q1 create queue other-config:max-rate=20000000 -- --id=@q2 create queue other-config:max-rate=2000000 other-config:min-rate=2000000" % config_strings[sw]
        q_res = os.popen(queuecmd).read()
        print q_res
	print("\n")
	print(queuecmd)
	print("\n")

    #cmd2 = "ovs-vsctl list port"
    #p = os.popen(cmd2).read()
    #print p

    '''
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
    net = Mininet(topo, switch=OVSKernelSwitch, controller=RemoteController)
    net.start()
    print "Dumping host connections"
    dumpNodeConnections(net.hosts)
    print "Testing network connectivity"
    #ifconfigTest(net)
    time.sleep(10)
    #pingTest(net)
    #net.pingAll()
    createQueues()
    CLI(net)
    net.stop()

if __name__ == '__main__':
    # Tell mininet to print useful information
    setLogLevel('info')
    simpleTest()
