#!/bin/bash
echo " "
echo " "
echo "---------Topology of the network--------------"
echo "                    S1                        "
echo "                 /      \                     "
echo "                /        \                    "
echo "               S2        S5                   "
echo "              /  \      /  \                  "
echo "             /    \    /    \                 "
echo "            S3    S4  S6    S7                "
echo "            |     |   |     |                 "
echo "           H1     H3  H5    H7                "
echo "           H2     H4  H6    H8                "
echo " "
echo " "

echo "------------Installing Flow rules into switch -----------------------"
S1="tcp:127.0.0.1:6634"
S2="tcp:127.0.0.1:6635"
S3="tcp:127.0.0.1:6636"
S4="tcp:127.0.0.1:6637"
S5="tcp:127.0.0.1:6638"
S6="tcp:127.0.0.1:6639"
S7="tcp:127.0.0.1:6640"

echo " "

echo "----Installing Flow enteries to handle ARP -----"
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0806,action=output:FLOOD
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0806,action=output:FLOOD
sudo ovs-ofctl add-flow $S3 -OOpenFlow13 priority=10,dl_type=0x0806,action=output:FLOOD
sudo ovs-ofctl add-flow $S4 -OOpenFlow13 priority=10,dl_type=0x0806,action=output:FLOOD
sudo ovs-ofctl add-flow $S5 -OOpenFlow13 priority=10,dl_type=0x0806,action=output:FLOOD
sudo ovs-ofctl add-flow $S6 -OOpenFlow13 priority=10,dl_type=0x0806,action=output:FLOOD
sudo ovs-ofctl add-flow $S7 -OOpenFlow13 priority=10,dl_type=0x0806,action=output:FLOOD

echo " "

echo "----Installing Flow enteries to S3 to handle IP traffic -----"
sudo ovs-ofctl add-flow $S3 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.1',action=output:1
sudo ovs-ofctl add-flow $S3 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.2',action=output:2
sudo ovs-ofctl add-flow $S3 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.3',action=output:3
sudo ovs-ofctl add-flow $S3 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.4',action=output:3
sudo ovs-ofctl add-flow $S3 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.5',action=output:3
sudo ovs-ofctl add-flow $S3 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.6',action=output:3
sudo ovs-ofctl add-flow $S3 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.7',action=output:3
sudo ovs-ofctl add-flow $S3 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.8',action=output:3

echo " "

echo "----Installing Flow enteries to S4 to handle IP traffic -----"
sudo ovs-ofctl add-flow $S4 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.3',action=output:1
sudo ovs-ofctl add-flow $S4 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.4',action=output:2
sudo ovs-ofctl add-flow $S4 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.1',action=output:3
sudo ovs-ofctl add-flow $S4 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.2',action=output:3
sudo ovs-ofctl add-flow $S4 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.5',action=output:3
sudo ovs-ofctl add-flow $S4 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.6',action=output:3
sudo ovs-ofctl add-flow $S4 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.7',action=output:3
sudo ovs-ofctl add-flow $S4 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.8',action=output:3

echo " "

echo "----Installing Flow enteries to S6 to handle IP traffic -----"
sudo ovs-ofctl add-flow $S6 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.5',action=output:1
sudo ovs-ofctl add-flow $S6 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.6',action=output:2
sudo ovs-ofctl add-flow $S6 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.1',action=output:3
sudo ovs-ofctl add-flow $S6 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.2',action=output:3
sudo ovs-ofctl add-flow $S6 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.3',action=output:3
sudo ovs-ofctl add-flow $S6 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.4',action=output:3
sudo ovs-ofctl add-flow $S6 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.7',action=output:3
sudo ovs-ofctl add-flow $S6 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.8',action=output:3

echo " "

echo "----Installing Flow enteries to S7 to handle IP traffic -----"
sudo ovs-ofctl add-flow $S7 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.7',action=output:1
sudo ovs-ofctl add-flow $S7 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.8',action=output:2
sudo ovs-ofctl add-flow $S7 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.1',action=output:3
sudo ovs-ofctl add-flow $S7 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.2',action=output:3
sudo ovs-ofctl add-flow $S7 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.3',action=output:3
sudo ovs-ofctl add-flow $S7 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.4',action=output:3
sudo ovs-ofctl add-flow $S7 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.5',action=output:3
sudo ovs-ofctl add-flow $S7 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.6',action=output:3

echo " "

echo "----Installing Flow enteries to S1 to handle IP traffic -----"
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.1',action=output:1
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.2',action=output:1
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.3',action=output:1
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.4',action=output:1
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.5',action=output:2
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.6',action=output:2
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.7',action=output:2
sudo ovs-ofctl add-flow $S1 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.8',action=output:2

echo " "

echo "----Installing Flow enteries to S2 to handle IP traffic -----"
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.1',action=output:1
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.2',action=output:1
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.3',action=output:2
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.4',action=output:2
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.5',action=output:3
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.6',action=output:3
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.7',action=output:3
sudo ovs-ofctl add-flow $S2 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.8',action=output:3

echo " "

echo "----Installing Flow enteries to S5 to handle IP traffic -----"
sudo ovs-ofctl add-flow $S5 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.1',action=output:3
sudo ovs-ofctl add-flow $S5 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.2',action=output:3
sudo ovs-ofctl add-flow $S5 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.3',action=output:3
sudo ovs-ofctl add-flow $S5 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.4',action=output:3
sudo ovs-ofctl add-flow $S5 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.5',action=output:1
sudo ovs-ofctl add-flow $S5 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.6',action=output:1
sudo ovs-ofctl add-flow $S5 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.7',action=output:2
sudo ovs-ofctl add-flow $S5 -OOpenFlow13 priority=10,dl_type=0x0800,nw_dst='10.0.0.8',action=output:2
