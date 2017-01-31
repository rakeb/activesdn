#!/bin/bash

cd /home/ubuntu/Downloads/SDNHub_Opendaylight_Tutorial/distribution/opendaylight-karaf/target/assembly/etc/opendaylight/karaf
echo "Setting Configuration in 52-loopremover.xml"
while [ ! -f 52-loopremover.xml ]; do
	echo "There is no such file in the folder"
	sleep 1
done
#if [ ! -f 522-loopremover.xml ]; then
#	echo "File is not present"
#fi

echo "54-arphandler.xml ------------ file is there in the folder"

