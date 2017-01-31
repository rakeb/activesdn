#!/bin/bash
echo "---------Topology of the network--------------"
echo " "
echo "       H1 ----S1-------S2------ H2            "
echo " "
echo " "

echo "------------Installing Flow rules into switch -----------------------"
S1="tcp:127.0.0.1:6634"
S2="tcp:127.0.0.1:6635"

echo "----Installing Flow enteries to handle ARP -----"
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0806,action=output:FLOOD
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0806,action=output:FLOOD

echo "----Installing Flow enteries to S2 to handle IP traffic -----"
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.1',action=output:1
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.2',action=output:2

echo "----Installing Flow enteries to S3 to handle IP traffic -----"
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.1',action=output:2
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.2',action=output:1
