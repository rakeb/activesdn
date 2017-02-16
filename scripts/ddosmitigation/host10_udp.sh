#!/bin/bash
xterm -fg orange -bg black -fa 'Monospace' -fs 12 -geometry 60x20+1010+550 -e "echo 'getting ready to receive traffic';
sudo python receive_udp_traffic.py 22223"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
