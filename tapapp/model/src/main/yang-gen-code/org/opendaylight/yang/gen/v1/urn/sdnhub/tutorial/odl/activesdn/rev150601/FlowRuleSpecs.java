package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * grouping flow-rule-specs {
 *     leaf switch-id {
 *         type int32;
 *     }
 *     leaf in-port-id {
 *         type uint32;
 *     }
 *     leaf src-mac-address {
 *         type string;
 *     }
 *     leaf dst-mac-address {
 *         type string;
 *     }
 *     leaf src-ip-address {
 *         type string;
 *     }
 *     leaf dst-ip-address {
 *         type string;
 *     }
 *     leaf type-of-traffic {
 *         type traffic-type;
 *     }
 *     leaf src-port {
 *         type int32;
 *     }
 *     leaf dst-port {
 *         type int32;
 *     }
 *     leaf flow-priority {
 *         type flow-priority;
 *     }
 *     leaf idle-timeout {
 *         type idle-timeout;
 *     }
 *     leaf hard-timeout {
 *         type hard-timeout;
 *     }
 *     leaf action-output-port {
 *         type string;
 *     }
 *     leaf action-set-source-ipv4-address {
 *         type string;
 *     }
 *     leaf action-set-dst-ipv4-address {
 *         type string;
 *     }
 *     leaf action-set-ipv4-tos {
 *         type int32;
 *     }
 *     leaf action-set-tcp-src-port {
 *         type int32;
 *     }
 *     leaf action-set-tcp-dst-port {
 *         type int32;
 *     }
 *     leaf action-set-ipv4-ttl {
 *         type uint8;
 *     }
 *     leaf action-set-port-queue {
 *         type int32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/flow-rule-specs</i>
 *
 */
public interface FlowRuleSpecs
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "flow-rule-specs").intern();

    /**
     * ID of the switch generated Packet_IN
     *
     */
    java.lang.Integer getSwitchId();
    
    /**
     * Input port of the switch that received data packet.
     *
     */
    java.lang.Long getInPortId();
    
    /**
     * MAC address of the Host generated packet, e.g., 00:00:00:00:00:01
     *
     */
    java.lang.String getSrcMacAddress();
    
    /**
     * MAC address of the destination Host, e.g., 00:00:00:00:00:02
     *
     */
    java.lang.String getDstMacAddress();
    
    /**
     * IP address of the Host generated data packet, e.g., 10.0.0.1/32
     *
     */
    java.lang.String getSrcIpAddress();
    
    /**
     * IP address of the destination Host, e.g., 10.0.0.2/32
     *
     */
    java.lang.String getDstIpAddress();
    
    TrafficType getTypeOfTraffic();
    
    java.lang.Integer getSrcPort();
    
    java.lang.Integer getDstPort();
    
    java.lang.Integer getFlowPriority();
    
    java.lang.Integer getIdleTimeout();
    
    java.lang.Integer getHardTimeout();
    
    /**
     * Specify the ID of the output port to forward the received data packet.
     *
     */
    java.lang.String getActionOutputPort();
    
    /**
     * This sets the IP Source value of the packet to new address, e.g., 10.0.0.1/32 
     * -&amp;gt; 10.0.0.2/32.
     *
     */
    java.lang.String getActionSetSourceIpv4Address();
    
    /**
     * This sets the Destination Source value of the packet to new address, e.g., 
     * 10.0.0.1/32 -&amp;gt; 10.0.0.2/32.
     *
     */
    java.lang.String getActionSetDstIpv4Address();
    
    /**
     * This sets the IP TOS value of the packet to change its precedence.
     *
     */
    java.lang.Integer getActionSetIpv4Tos();
    
    /**
     * This sets the TCP Source Port number of the packet.
     *
     */
    java.lang.Integer getActionSetTcpSrcPort();
    
    /**
     * This sets the TCP Destination Port number of the packet.
     *
     */
    java.lang.Integer getActionSetTcpDstPort();
    
    /**
     * This sets the TTL value of the packet.
     *
     */
    java.lang.Short getActionSetIpv4Ttl();
    
    /**
     * Set the queue on the output port
     *
     */
    java.lang.Integer getActionSetPortQueue();

}

