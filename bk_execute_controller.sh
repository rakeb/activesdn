#!/bin/bash
cd /home/ubuntu/Downloads/SDNHub_Opendaylight_Tutorial/distribution/opendaylight-karaf/target/assembly/etc/opendaylight/karaf

echo "Setting Configuration in 52-loopremover.xml" 
sed i.bak "s/<is-install-lldp-flow>true<\/is-install-lldp-flow>/<is-install-lldp-flow>false<\/is-install-lldp-flow>/g" 52-loopremover.xml

echo "Setting configuration in 54-arphandler.xml"
sed i.bak "s/<is-proactive-flood-mode>true<\/is-proactive-flood-mode>/<is-proactive-flood-mode>false<\/is-proactive-flood-mode>/g" 54-arphandler.xml

echo "Setting configuration in 58-l2switchmain.xml"
sed i.bak "s/<is-learning-only-mode>false<\/is-learning-only-mode>/<is-learning-only-mode>true<\/is-learning-only-mode>/g" 58-l2switchmain.xml
sed i.bak "s/<is-install-dropall-flow>true<\/is-install-dropall-flow>/<is-install-dropall-flow>false<\/is-install-dropall-flow>/g" 58-l2switchmain.xml

cd /home/ubuntu/Downloads/SDNHub_Opendaylight_Tutorial
 



