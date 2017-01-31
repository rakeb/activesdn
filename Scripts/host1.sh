#!/bin/bash
xterm -fg green -bg black -fa 'Monospace' -fs 12 -geometry 60x30+10+10 -e "echo 'H1 Pinging H10 to establish route'; 
ping 10.0.0.10;
exit"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
