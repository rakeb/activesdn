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
from mininet.link import TCIntf
from mininet.util import custom
import time
import os
import sys
from collections import defaultdict
'''
h1------|		|--------h3
	s1------s2------s3--------------------s4---------(h5,h13)
h2------|		|--------h4

'''
class MyTopo( Topo ):
    "Simple topology example."
    def __init__( self ):
        "Create custom topo."
        print "Starting my topology..."

        # Initialize topology
        Topo.__init__( self )

        # Add hosts and switches
        host1 = self.addHost( 'h1' )
        host2 = self.addHost( 'h2' )
	host3 = self.addHost( 'h3' )
	host4 = self.addHost( 'h4' )
        host = [("h%s" % (i+5)) for i in range(9)]
        print 'prining hosts...'
	print host
        for i in range(9):
            self.addHost(host[i])

        switch1 = self.addSwitch( 's1' )
        switch2 = self.addSwitch( 's2' )
	switch3 = self.addSwitch( 's3' )
        switch4 = self.addSwitch( 's4' )
	
        # Add links
        self.addLink( host1, switch1)
	self.addLink( host2, switch1)
	self.addLink( host3, switch3)
        self.addLink( host4, switch3)
        for i in range(9):
            self.addLink( host[i], switch4 )

        self.addLink( switch1, switch2, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True use_hfsc = False, use_tbf = False)
	self.addLink( switch2, switch3, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch3, switch4, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
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

    time.sleep(10)
    host1.cmd('bash host1.sh &')
    time.sleep(10)
    host2.cmd('bash host2.sh &')
    time.sleep(10)
    host4.cmd('bash host4.sh &')
    #host10.cmd('bash host10_tcp_iperf.sh &')
    time.sleep(3)
    host10.cmd('bash host10_tcp.sh &')
    #host4.cmd('bash host4_iperf.sh &')
    time.sleep(6)
    host5.cmd('bash host5.sh &')
    time.sleep(3)
    host10.cmd('bash host10_udp.sh &')
    #cmd = "read -p 'press any key to start sending elephant flows'"
    #os.popen(cmd)
    
    time.sleep(40)
    host7.cmd('bash host7.sh')
    #new comers test start here
    host3.cmd('bash host3.sh &')
    time.sleep(2)
    host6.cmd('bash host6.sh &')
    time.sleep(2)
    host13.cmd('bash host13.sh &')
    time.sleep(2)
    host14.cmd('bash host14.sh &')
    for i in range(19):
        time.sleep(1.5)
        print(i)
        host = net.hosts[i+15]
        host.cmd('bash send_ping.sh &')
        
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
        

def set_q(iface, q):
    "Change queue size limit of interface"
    cmd = ("sudo /sbin/tc qdisc change dev %s parent 1:1 handle 10: netem limit %s" % (iface, q))
    os.system(cmd)

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
    #print "ovs-vsctl show: " + p
    configuration = []
    configuration = createLineArray(p)
    #print "configuration: "
    #print configuration
   
    switches = []
    for line in configuration:
        if "Bridge" in line:
            #print(line)
            start = line.find('"' , 0)
            #print(start)
            sw =  line[start + 1:len(line) - 1]
            switches.append(sw)
	    print "switch: " +sw
    
    prts = []
    for line in configuration:
        if "Port" in line:
            if "eth" in line:
                #print(line)
                start = line.find('"', 0)
                prt = line[start + 1:len(line) - 1]
                prts.append(prt)
                print "prot: " +prt
    restricted_ports = ["s1-eth3", "s1-eth4"]#, "s2-eth3", "s2-eth4", "s3-eth3", "s3-eth4"]    
    config_strings = defaultdict(list)
    restricted_config_strings = defaultdict(list)

    for i in range(len(switches)):
        tempStr = ""
        restricted_tempStr = ""
        sw = switches[i] + "-eth"
        for n in range(len(prts)):
            #verify correct order
            if sw in prts[n]:
                print switches[i]
                print prts[n]
                port_name = prts[n]
                if (port_name in restricted_ports):
                    restricted_tempStr = restricted_tempStr + " -- set port %s qos=@newqos" % port_name
                else:
                    tempStr = tempStr + " -- set port %s qos=@newqos" % port_name
	print(tempStr)
        config_strings[switches[i]].append(tempStr)
        restricted_config_strings[switches[i]].append(restricted_tempStr)
        print("\n")
        print(config_strings[switches[i]][0])
    for port in restricted_ports:
        cmd = ("sudo ip link set dev %s txqueuelen %s" % (port, "40"))
        os.system(cmd)

    for sw in switches:
        if restricted_config_strings[sw][0] != "":
            queuecmd = "sudo ovs-vsctl %s -- --id=@newqos create qos type=linux-htb other-config:max-rate=3000000000 queues=0=@q0,1=@q1 -- --id=@q0 create queue other-config:max-rate=10 -- --id=@q1 create queue other-config:max-rate=2" % restricted_config_strings[sw][0]
            #print("Restricted Port %s " % (restricted_config_strings[sw][0]))
            q_res = os.popen(queuecmd).read()
            print q_res

        queuecmd = "sudo ovs-vsctl %s -- --id=@newqos create qos type=linux-htb other-config:max-rate=1000000000 queues=0=@q0,1=@q1 -- --id=@q0 create queue other-config:min-rate=100000000 other-config:max-rate=1000000000 -- --id=@q1 create queue other-config:max-rate=2" % config_strings[sw][0]
        #print("Un-Restricted Port %s " % (config_strings[sw][0]))
        q_res = os.popen(queuecmd).read()
        print "\n\n\nqueue command: " + queuecmd
        #print q_res
	#print("\n")
	#print(queuecmd)
	#print("\n")
    #print(restricted_ports)
    #for port in restricted_ports:
    #    set_q(port, 1)
        #print("Port restricted % " % (port))
    #cmd2 = "ovs-vsctl list port"
    #p = os.popen(cmd2).read()
    #print p
    

'''
            queuecmd = "sudo ovs-vsctl %s -- --id=@newqos create qos type=linux-htb other-config:max-rate=1000000000 queues=0=@q0,1=@q1 -- --id=@q0 create queue other-config:min-rate=10 other-config:max-rate=10 other_config:dpdk-rxq-size=1 other_config:dpdk-txq-size=1 -- --id=@q1 create queue other-config:max-rate=2 other_config:dpdk-rxq-size=1 other_config:dpdk-txq-size=1" % restricted_config_strings[sw][0]
'''    
#////////////////////////////////////////////

def simpleTest():
    "Create and test a simple network"
    print "Starting simple test..."
    topo = MyTopo()
    net = Mininet(topo, link=TCLink, switch=OVSKernelSwitch, controller=RemoteController)
    net.start()
    print "Dumping host connections"
    dumpNodeConnections(net.hosts)
    print "Testing network connectivity"
    #time.sleep(40)
    #createQueues()
    #pingTest(net)
    
    CLI(net)
    net.stop()
    p = os.popen("sudo mn -c").read()
    print(p)

if __name__ == '__main__':
    # Tell mininet to print useful information
    print "Starting main..."
    setLogLevel('info')
    simpleTest()
