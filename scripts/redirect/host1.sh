#!/bin/bash
xterm -fg green -bg black -fa 'Monospace' -fs 12 -geometry 60x30+10+10 -e "echo 'H1 Pinging H12 to trigger Redirect'; 
ping 10.0.0.12;
sleep 1000;"
#hello

