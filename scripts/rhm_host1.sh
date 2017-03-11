#!/bin/bash
xterm -fg red -bg black -fa 'Monospace' -fs 14 -geometry 100x40+100+10 -e "echo 'Random Host Mutation Demonstartion'; 
ping 10.0.0.12;
echo -e '\e[32m\e[40m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.6 \n -----------------------------------------\n';
ping 10.0.0.6;
echo -e '\e[33m\e[40m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.7 \n -----------------------------------------\n';
ping 10.0.0.7;
echo -e '\e[35m\e[40m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.8 \n -----------------------------------------\n';
ping 10.0.0.8;
echo -e '\e[36m\e[40m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.9 \n -----------------------------------------\n';
ping 10.0.0.9;
echo -e '\e[37m\e[40m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.10 \n -----------------------------------------\n';
ping 10.0.0.10;
echo -e '\e[31m\e[40m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.11 \n -----------------------------------------\n';
ping 10.0.0.11;
echo -e '\e[32m\e[40m' '\n -----------------------------------------\n Now pinging using Virtual IP 10.0.0.6 \n -----------------------------------------\n';
ping 10.0.0.6;
exit"
#sudo python ~/Downloads/traffic_generator/generate_elephant_traffic.py 10.0.0.1 10.0.0.10 100 22222;
#bash command if you want to stop xterm on a command line
#sudo python host1_sending_ping.py;

