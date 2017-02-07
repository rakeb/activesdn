from mininet.topo import Topo
class Perf(Topo):
  def __init__(self):
    super(Perf, self).__init__()
    net = self
    h1 = net.addHost('h1', mac='00:00:00:00:00:01', ip='10.0.0.1')
    h2 = net.addHost('h2', mac='00:00:00:00:00:02', ip='10.0.0.2')
    s1 = net.addSwitch('s1')
    s2 = net.addSwitch('s2')
    linkopts = dict(bw=20, use_htb=True)
    net.addLink(h1, s1, 1, 1, **linkopts)
    net.addLink(h2, s2, 1, 1, **linkopts)
    linkopts = dict(bw=0.5, use_htb=True)
    net.addLink(s1, s2, 2, 2, **linkopts)

topos = { 'perf': ( lambda: Perf() ) }
