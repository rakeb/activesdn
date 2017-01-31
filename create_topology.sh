#!/bin/bash
echo "Creating custom topology "
cd /home/ubuntu/mininet/custom/
sudo mn --custom custom_tree_topology.py --topo mytopo --mac --switch ovsk,protocols=OpenFlow13 --controller remote
#--post ~/Downloads/my_cli_script

