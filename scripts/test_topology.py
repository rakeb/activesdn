#!/usr/bin/python

"""
This example shows how to create a network and run multiple tests.
For a more complicated test example, see udpbwtest.py.
"""

from mininet.cli import CLI
from mininet.topo import Topo
from mininet.log import lg, info, setLogLevel
from mininet.util import irange,dumpNodeConnections
from mininet.net import Mininet
from mininet.node import OVSKernelSwitch
from mininet.node import CPULimitedHost
from mininet.link import TCLink
#from mininet.topolib import TreeTopo
from mininet.node import Controller, RemoteController

class CustomTopology(Topo):
    "My custome experiment topology"

    def __init__(self, **opts):
        '''Constructor that cretes topology'''
        

def ifconfigTest( net ):
    "Run ifconfig on all hosts in net."
    hosts = net.hosts
    for host in hosts:
        info( host.cmd( 'ifconfig' ) )

if __name__ == '__main__':
    lg.setLogLevel( 'info' )
    info( "*** Initializing Mininet and kernel modules\n" )
    OVSKernelSwitch.setup()
    info( "*** Creating network\n" )
    network = Mininet( TreeTopo( depth=2, fanout=2 ), switch=OVSKernelSwitch, controller=RemoteController )
    info( "*** Starting network\n" )
    network.start()
    info( "*** Running ping test\n" )
    network.pingAll()
    info( "*** Running ifconfig test\n" )
    ifconfigTest( network )
    info( "*** Starting CLI (type 'exit' to exit)\n" )
    CLI( network )
    info( "*** Stopping network\n" )
    network.stop()
