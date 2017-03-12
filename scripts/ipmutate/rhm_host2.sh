#!/bin/bash
xterm -fg red -bg black -fa 'Monospace' -fs 14 -geometry 70x35+800+400 -e "echo 'H2 (Scanner) Randomly sends probe packets'; 
ping -c1 10.0.0.8;
echo -e '\e[96m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.5 \n -----------------------------------------\n';
ping -w 20 10.0.0.5;
echo -e '\e[31m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.11 \n -----------------------------------------\n';
ping -w 20 10.0.0.11;
echo -e '\e[37m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.6 \n -----------------------------------------\n';
ping -w 20 10.0.0.6;
echo -e '\e[35m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.12 \n -----------------------------------------\n';
ping -w 20 10.0.0.12;
echo -e '\e[92m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.4 \n -----------------------------------------\n';
ping -w 20 10.0.0.4;
echo -e '\e[37m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.10 \n -----------------------------------------\n';
ping -w 20 10.0.0.10;
echo -e '\e[36m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.4 \n -----------------------------------------\n';
ping -w 20 10.0.0.4;
echo -e '\e[95m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.6 \n -----------------------------------------\n';
ping -w 20 10.0.0.6;
echo -e '\e[94m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.11 \n -----------------------------------------\n';
ping -w 20 10.0.0.11;
echo -e '\e[93m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.5 \n -----------------------------------------\n';
ping -w 20 10.0.0.5;
echo -e '\e[97m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.10 \n -----------------------------------------\n';
ping -w 20 10.0.0.10;
echo -e '\e[96m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.6 \n -----------------------------------------\n';
ping -w 20 10.0.0.6;
exit"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
#sudo python host1_sending_ping.py;

