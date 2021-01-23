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

class MyTopo( Topo ):
    "Simple topology example."
    def __init__( self ):
	"Create custom topo."
	print "Starting my topology..."

        # Initialize topology
	Topo.__init__( self )

        # Add hosts and switches
	attacker_a1		= self.addHost( 'a1' )
	attacker_a2		= self.addHost( 'a2' )
	decoy_server_ds1	= self.addHost( 'ds1' )
        user_u1 		= self.addHost( 'u1' )
	web_server_ws1		= self.addHost( 'ws1' )
	web_server_ws2		= self.addHost( 'ws2' )
	#ixia_license_server	= self.addHost( 'ils' )

        switch_w1 = self.addSwitch('s1')
        switch_w2 = self.addSwitch('s2')
	switch_w3 = self.addSwitch('s3')
        switch_w4 = self.addSwitch('s4')
	switch_w5 = self.addSwitch('s5')
        switch_w6 = self.addSwitch('s6')
        switch_c1 = self.addSwitch('s7')
        switch_c2 = self.addSwitch('s8')
	switch_c3 = self.addSwitch('s9')
        switch_c4 = self.addSwitch('s10')
        switch_d1 = self.addSwitch('s11')

        # Add links
        self.addLink( user_u1, switch_w1)
	self.addLink( attacker_a1, switch_w2)
	self.addLink( attacker_a2, switch_w3)
	self.addLink( decoy_server_ds1, switch_d1)
	#twinking for generating attack 
	self.addLink( web_server_ws1, switch_c2)
	#self.addLink( web_server_ws1, switch_c3)
	#self.addLink( web_server_ws1, switch_c4)
	self.addLink( web_server_ws2, switch_w4)
        #self.addLink( web_server_ws2, switch_c3)
	#self.addLink( web_server_ws2, switch_c4)
                
	#self.addLink( ixia_license_server, switch_w2)


        self.addLink( switch_w1, switch_w2, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True use_hfsc = False, use_tbf =False)
	self.addLink( switch_w1, switch_w3, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
		
	self.addLink( switch_w2, switch_w4, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
		
	self.addLink( switch_w3, switch_w4, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch_w3, switch_w5, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
		
	self.addLink( switch_w4, switch_w6, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
		
	self.addLink( switch_w5, switch_w6, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
		
	self.addLink( switch_w6, switch_c1, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch_w6, switch_c2, bw=1, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
		
	self.addLink( switch_c1, switch_c3, use_htb=True)#bw=10, delay='5ms',  loss=1, max_queue_size=10, use_htb=True)
	self.addLink( switch_c1, switch_c4, use_htb=True)#bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)
		
	self.addLink( switch_c2, switch_c3, use_htb=True)#bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch_c2, switch_c4, use_htb=True)#bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)
        self.addLink( switch_c2, switch_d1, use_htb=True)#bw=10, delay='5ms', loss=1, max_queue_size=10, use_htb=True)

def hostInfo(net):
    #print "Host", net.hosts[0], "has IP address", net.hosts[0].IP(), "and MAC address", net.hosts[0].MAC()
    for h in net.hosts:
	try:
		print "Host", h, "has IP address", h.IP(), "and MAC address", h.MAC()
	except AttributeError:
		print "not found..."

def ddosAttack( net ):
    "Starting ddos attack "
    
    '''
	Host a1 has IP address 10.0.0.1 and MAC address f2:4c:f2:45:86:de
	Host a2 has IP address 10.0.0.2 and MAC address 0a:31:c1:bd:b4:69
	Host ds1 has IP address 10.0.0.3 and MAC address 42:24:1a:45:04:1b
	Host u1 has IP address 10.0.0.4 and MAC address 9e:98:20:3e:54:b7
	Host ws1 has IP address 10.0.0.5 and MAC address 46:37:fd:45:c8:65
	Host ws2 has IP address 10.0.0.6 and MAC address 36:34:0e:e3:ed:7f
    
    '''

    attacker_a1		= net.hosts[0]
    attacker_a2		= net.hosts[1]
    decoy_server_ds1	= net.hosts[2]
    user_u1 		= net.hosts[3]
    web_server_ws1	= net.hosts[4]
    web_server_ws2	= net.hosts[5]
    #ixia_license_server	= net.hosts[6]

    time.sleep(10)
    command = 'bash ping.sh ' + web_server_ws2.IP() + ' ' +web_server_ws1.IP() +' &'
    print command
    web_server_ws2.cmd(command)

    time.sleep(10)
    command = 'bash ping.sh ' + user_u1.IP() + ' ' +web_server_ws1.IP() +' &'
    print command
    user_u1.cmd(command)
    
    time.sleep(10)
    #attacker_a1 is sendng tcp elephant flows to decoy_server_ds1
    command = 'bash send-tcp.sh ' + attacker_a1.IP() + ' ' +decoy_server_ds1.IP() +' &'
    print command
    attacker_a1.cmd(command)

    time.sleep(3)
    decoy_server_ds1.cmd('bash tcp-receiver.sh &')

    time.sleep(6)
    #attacker_a2 is sendng tcp elephant flows to decoy_server_ds1
    command = 'bash send-udp.sh ' + attacker_a2.IP() + ' ' +decoy_server_ds1.IP() +' &'
    print command
    attacker_a2.cmd(command)

    time.sleep(3)
    decoy_server_ds1.cmd('bash udp-receiver.sh &')
    #cmd = "read -p 'press any key to start sending elephant flows'"
    #os.popen(cmd)
    '''
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
	    #print "switch: " +sw
    
    prts = []
    for line in configuration:
        if "Port" in line:
            if "eth" in line:
                #print(line)
                start = line.find('"', 0)
                prt = line[start + 1:len(line) - 1]
                prts.append(prt)
                #print "prot: " +prt
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
                #print switches[i]
                #print prts[n]
                port_name = prts[n]
                if (port_name in restricted_ports):
                    restricted_tempStr = restricted_tempStr + " -- set port %s qos=@newqos" % port_name
                else:
                    tempStr = tempStr + " -- set port %s qos=@newqos" % port_name
	#print(tempStr)
        config_strings[switches[i]].append(tempStr)
        restricted_config_strings[switches[i]].append(restricted_tempStr)
        #print("\n")
        #print(config_strings[switches[i]][0])
    for port in restricted_ports:
        cmd = ("sudo ip link set dev %s txqueuelen %s" % (port, "40"))
        os.system(cmd)

    for sw in switches:
        if restricted_config_strings[sw][0] != "":
            queuecmd = "sudo ovs-vsctl %s -- --id=@newqos create qos type=linux-htb other-config:max-rate=3000000000 queues=0=@q0,1=@q1 -- --id=@q0 create queue other-config:max-rate=10 -- --id=@q1 create queue other-config:max-rate=2" % restricted_config_strings[sw][0]
            #print("Restricted Port %s " % (restricted_config_strings[sw][0]))
            q_res = os.popen(queuecmd).read()
            #print q_res

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
    hostInfo(net)
    time.sleep(40)
    createQueues()
    ddosAttack(net)
    
    CLI(net)
    net.stop()
    p = os.popen("sudo mn -c").read()
    print(p)

if __name__ == '__main__':
    # Tell mininet to print useful information
    print "Starting main..."
    setLogLevel('info')
    simpleTest()
