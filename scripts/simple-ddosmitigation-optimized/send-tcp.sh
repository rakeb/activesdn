#!/bin/bash
xterm -fg red -bg black -fa 'Monospace' -fs 12 -geometry 60x30+600+10 -e "echo '$1 pinging $2'; 
ping -c3 $2;
sudo python generate_elephant_traffic.py $1 $2 1000 22222;
exit"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
#read -p 'press any key to start sending elephant flows';
#sudo python generate_elephant_traffic.py 10.0.0.4 10.0.0.10 100 22222;
#read -p 'press any key to exit';

