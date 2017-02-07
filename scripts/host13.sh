#!/bin/bash
xterm -fg yellow -bg black -fa 'Monospace' -fs 12 -geometry 60x10+600+500 -e "echo 'H13 Pinging H10'; 
ping 10.0.0.10;
exit"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
