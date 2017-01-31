#!/bin/bash
echo "Running Active SDN Controller"

cd distribution/opendaylight-karaf/target/assembly/

if timeout 1 bash -c " > /dev/tcp/localhost/5005"; then 
	echo "Another Instance of Controller Running"
	exit 1
fi
./bin/karaf
