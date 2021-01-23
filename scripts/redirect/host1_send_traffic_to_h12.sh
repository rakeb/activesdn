#!/bin/bash
xterm -fg red -bg black -fa 'Monospace' -fs 12 -geometry 70x30+600+10 -e "echo 'H1 sending TCP traffic to Server H12 in port 100'; 
sudo python generate_dropbox_traffic.py 10.0.0.1 10.0.0.12 1;
sleep 1000;"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
#read -p 'press any key to start sending elephant flows';
#sudo python generate_elephant_traffic.py 10.0.0.4 10.0.0.10 100 22222;
#read -p 'press any key to exit';

