#!/bin/bash
echo "Compipling Active SDN "
#cd tapapp/implementation
#mvn clean install -DskipTests=true -DskipIT -T 1C -offline --quiet &&
#mvn clean install -pl distribution -am -DskipTests=true -DskipIT -nsu -T 1C &&
#cd /home/ubuntu/Downloads/SDNHub_Opendaylight_Tutorial/distribution
mvn clean install -DskipTests -DskipIT -nsu -T 1C -offline &&
cd /home/ubuntu/Downloads/SDNHub_Opendaylight_Tutorial
echo " Starting controller configuration after compilation"

cd distribution/opendaylight-karaf/target/assembly/
echo "running controller"
./bin/start

COUNTER=0
while ! timeout 1 bash -c "echo > /dev/tcp/localhost/5005" && [ $COUNTER -lt 5 ]; do
	echo Attempt Number $COUNTER
	let COUNTER=COUNTER+1 
	sleep 2
done
if [ $COUNTER == 5 ]; then
	echo "Build Failed exiting ...."
	exit 1
fi

echo " ------------------------------- "
echo "controller is loaded"

if [ $1 == '' ]; then
	sleep 10
else
	sleep $1
fi

echo " now installing jgrapht-core feature"
./bin/client -u karaf -h localhost feature:install jgrapht-core &
wait
echo " "
echo " Stopping controller "
./bin/stop &
wait
echo "Controller is stopped"

cd /home/ubuntu/Downloads/SDNHub_Opendaylight_Tutorial/distribution/opendaylight-karaf/target/assembly/etc/opendaylight/karaf
#cd /etc/opendaylight/karaf
echo "Setting Configuration in 52-loopremover.xml"
while [ ! -f 52-loopremover.xml ]; do
	sleep 1
done
sudo sed -i.bak "s/<is-install-lldp-flow>true<\/is-install-lldp-flow>/<is-install-lldp-flow>false<\/is-install-lldp-flow>/g" 52-loopremover.xml &&

echo "Setting configuration in 54-arphandler.xml" &&
while [ ! -f 54-arphandler.xml ]; do
	sleep 1
done
sudo sed -i.bak "s/<is-proactive-flood-mode>true<\/is-proactive-flood-mode>/<is-proactive-flood-mode>false<\/is-proactive-flood-mode>/g" 54-arphandler.xml &&

echo "Setting configuration in 58-l2switchmain.xml" &&
while [ ! -f 58-l2switchmain.xml ]; do
	sleep 1
done
sudo sed -i.bak "s/<is-learning-only-mode>false<\/is-learning-only-mode>/<is-learning-only-mode>true<\/is-learning-only-mode>/g" 58-l2switchmain.xml &&
sudo sed -i.bak "s/<is-install-dropall-flow>true<\/is-install-dropall-flow>/<is-install-dropall-flow>false<\/is-install-dropall-flow>/g" 58-l2switchmain.xml &&
#cd /home/ubuntu/Downloads/SDNHub_Opendaylight_Tutorial/distribution/opendaylight-karaf/target/assembly/etc/opendaylight/karaf
cd /home/ubuntu/Downloads/SDNHub_Opendaylight_Tutorial &&
#cd ../../../../../../../ &&
echo "running controller" 
while timeout 1 bash -c " > /dev/tcp/localhost/5005"; do sleep 2; done
distribution/opendaylight-karaf/target/assembly/./bin/karaf
