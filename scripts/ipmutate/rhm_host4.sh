#!/bin/bash
xterm -fg red -bg black -fa 'Monospace' -fs 14 -geometry 100x40+100+10 -e "echo 'Host 4 pinging H10'; 
ping 10.0.0.10;
exit"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
#sudo python host1_sending_ping.py;

