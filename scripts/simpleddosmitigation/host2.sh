#!/bin/bash
xterm -fg green -bg black -fa 'Monospace' -fs 12 -geometry 60x30+10+650 -e "echo 'H2 Pinging H10';
ping 10.0.0.10;
exit"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
#sudo python host2_sending_ping.py;
