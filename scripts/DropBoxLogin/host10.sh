#!/bin/bash
xterm -fg orange -bg black -fa 'Monospace' -fs 12 -geometry 60x30+1400+10 -e "echo 'getting ready to receive traffic in port 100 as a DropBox Host'; 
sudo python receive_tcp_traffic.py 100;"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
#read -p 'press any key to start sending elephant flows';
#sudo python generate_elephant_traffic.py 10.0.0.4 10.0.0.10 100 22222;
#read -p 'press any key to exit';

