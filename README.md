ActiveSDN
========
CyberDNA Research Team
University of North Carolina at Charlotte
February 7, 2017.

# Install scapy.

* You need to install scapy to run the DDoS Mitigation and Dropbox authentication programs. You can use the following instructions to download and install scapy on your virtual machine:
  * Use the following URL to download the scapy zip file http://scapy.net/
  * Copy the Zip file in Downloads folder and use the following command to unzip the scapy zip file
    ``` unzip scapy-2.3.1.zip (If you download any other version then replace the version here in the command) ```
  * This will create a folder of the named zip file. Then simply use this command to goto the unzipped folder
    ``` cd scapy-[version-number] ```
  * Run the following command to install the scapy
    ``` sudo python setup.py install ```
* Once installation is complete please check if the scapy is installed by using the command 
  ``` sudo scapy ``` 
  
It should run the scapy environment. You can use ```exit()``` command to exit scapy.

# Clone and Pull ActiveSDN Repository:
* For first time Clone
  * Go to the directory <Downloads> by the command:
    ``` cd /home/ubuntu/Downloads/ ```
  * Open a terminal in the <Downloads> directory and write the command:
    ```git clone https://github.com/rakeb/activesdn.git ```
  * You need to provide your GitHub credentials at this point:
```  
    Username for 'https://github.com': <your GitHub username>
    Password for 'https://rakeb@github.com': <your GitHub password>
```

Now you get your local copy of the current remote repository <activesdn>.

* To pull the current code
  * Go to the directory <activesdn> by the command: 
  ```cd /home/ubuntu/Downloads/activesdn ```
  * Open a terminal in the <activesdn> directory and write the command:
    ```git pull origin master```
  * You may or may not need to provide your GitHub credentials at this point:
```
    Username for 'https://github.com': <your GitHub username>
    Password for 'https://rakeb@github.com': <your GitHub password>
```
Now you updated your local copy with the current remote repository <activesdn>. 

# Import Project into IDE (Eclipse).
The VM we provide includes a Eclipse and IntelliJ Idea IDE. We are using Eclipse. To import the cloned ActiveSDN projectc:

 * Open a Terminal and goto home directory
 ```` cd ````
 * Remove the existing Eclipse workspace
 ```` sudo rm -rf eclipse-workspace/````
 * Run Eclipse writing the following command in the same terminal
 ```` eclipse````
 * Now, in Eclipse extract (Click on the small + sign) maven from file->import
 * Select 'existing maven project' and press 'next'
 * Select 'Browse...' and find activesdn root directory that we just cloned (in our case /home/ubuntu/Downloads/activesdn) then press 'ok'
 * Now press 'Finish'
 * At this point a popup may show that "Import Maven Projects", press 'cancel'.
 * Our project is successfully imported to Eclipse, at the left sidebar there is a (double box) icon states 'Restore', click on that to extract package hierarchy. 

# Compile and Execute Controller.

* Goto ActiveSDN directory using command
 ```` cd ~/Downloads/ActiveSDN````
* Run the following script 
 ```` ./compile_and_execute_controller.sh 10````
* This script will automatically compile the controller and after compilation, it will run the controller

Remember: after compilation you only need to run ```./execute_controller.sh``` script file to run the controller

#Run DDoS Mitigation Example
* To run the DDoS Mitigation example, goto the following folder 
 ``` cd ~/mininet/custom```
* Run the script using following command 
 ``` sudo ./exeperiment_topology.py ```

#Run Dropbox Application
* Copy all the scripts from ```activesdn/scripts``` to ```~/mininet/custom``` 
* go to directory <DropBoxLogin> by the command 
  ``` cd ~/mininet/custom/dropboxlogin``` 
* Run the script using following command 
  ``` sudo python dropBox_login_test.py ```

#General Instructions related to ActiveSDN controller

* The controller may take few seconds to initialize and learn the topology of the network.  So, before initiating any data transfer, please wait few seconds to let the controller finish the learning process.

* You can immediately test the functionality of the controller using a test topology provided with the controller.  Simply run the ```create_topology.sh``` from the /home/ubuntu folder to generate this custom topology using command ```./create_topology.sh```

* The topology diagram is also available in the shared folder. This topology is created in mininet using Open vSwitches.

* In a case where the controller is running in one VM, and Open vSwitches or Mininet is running in other VM or VMs then you have to set the manager of the VMs hosting mininet or Open vSwitches. 

* By default, ActiveSDN controller runs on port 6633. To set the manager, please use the following command in VMs hosting mininet or Open vSwitches.
 ``` sudo ovs-vsctl set-manager tcp:<IP address of the ActiveSDN VM>:6633```

>>You can always check the logs of the ActiveSDN VM using the following command from within ActiveSDN Controller Karaf environment.
```
log:tail
```

You can also check the topology using GUI interface from the browser. Type in this URL http://localhost:8181/index.html#/topology

Both username and password are admin/admin
Try with 'A' caps if it gives an error.

To shutdown the controller, use the following command.
```
shutdown -f
```

You can use the following commands in the mininet environment to test the functionality
```
mininet> h1 ping h12       // To send the ping messages from h1 to h12

//To test using simple HTTP server functionality 

mininet> h12 python -m SimpleHTTPServer 80 &   // This will create a webserver on host h12
mininet> h2 wget -O - h12                 //This will send an HTTP GET request to host h12 running web server

mininet> h12 kill %python           // This command will terminate the HTTP server running on h12
```

Other useful commands can be found on the following link
http://mininet.org/walkthrough/#part-4-python-api-examples
------------------------------------------------------------


SDNHub Opendaylight Tutorial
============================
This is the OpenDaylight project source code used by the [our tutorial](http://sdnhub.org/tutorials/opendaylight/).

# Directory Organization
* pom.xml: The POM in the main directory specifies all the sub-POMs to build
* commons/parent: contains the parent pom.xml with all properties defined for the subprojects.
* commons/utils: contains custom utilities built for OpenFlow programming 
* learning-switch: contains the tutorial L2 hub / switch
* tapapp: contains the traffic monitoring tap application
* features: defines the two features "sdnhub-tutorial-learning-switch", * "sdnhub-tutorial-tapapp" that can be loaded in Karaf
* distribution/karaf-branding: contains karaf branner for SDN Hub
* distribution/opendaylight-karaf: contains packaging relevant pom to * generate a running directory 

# HOW TO BUILD
In order to build it's required to have JDK 1.8+ and Maven 3.2+. 
The following commands are used to build and run.
```
$ mvn clean install
$ cd distribution/opendaylight-karaf/target/assembly
$ ./bin/karaf
karaf>feature:install sdnhub-XYZ
```
