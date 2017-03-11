#!/bin/bash
xterm -fg yellow -bg black -fa 'Monospace' -fs 12 -geometry 50x10+500+300 -e "echo 'H6 Pinging H10'; 
ping -c70 10.0.0.10;
sudo python generate_udp_traffic.py 10.0.0.6 10.0.0.10 200 22223;
exit"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
