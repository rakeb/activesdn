package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * grouping ipv4-packet-header-fields {
 *     leaf version {
 *         type uint8;
 *     }
 *     leaf ihl {
 *         type uint8;
 *     }
 *     leaf dscp-value {
 *         type uint8;
 *     }
 *     leaf ecn {
 *         type uint8;
 *     }
 *     leaf total-length {
 *         type uint16;
 *     }
 *     leaf identification {
 *         type uint16;
 *     }
 *     leaf reserved-flag {
 *         type boolean;
 *     }
 *     leaf df-flag {
 *         type boolean;
 *     }
 *     leaf mf-flag {
 *         type boolean;
 *     }
 *     leaf fragment-offset {
 *         type uint16;
 *     }
 *     leaf ttl {
 *         type uint8;
 *     }
 *     leaf protocol {
 *         type uint8;
 *     }
 *     leaf header-checksum {
 *         type uint16;
 *     }
 *     leaf source-address {
 *         type string;
 *     }
 *     leaf destination-address {
 *         type string;
 *     }
 *     leaf ipv4-options {
 *         type binary;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/ipv4-packet-header-fields</i>
 *
 */
public interface Ipv4PacketHeaderFields
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "ipv4-packet-header-fields").intern();

    java.lang.Short getVersion();
    
    /**
     * Internal Header Length
     *
     */
    java.lang.Short getIhl();
    
    /**
     * Differentiated Code Services Point
     *
     */
    java.lang.Short getDscpValue();
    
    /**
     * Explicit Congestion Notification
     *
     */
    java.lang.Short getEcn();
    
    /**
     * Packet size, including header and data, in bytes
     *
     */
    java.lang.Integer getTotalLength();
    
    /**
     * Identification
     *
     */
    java.lang.Integer getIdentification();
    
    /**
     * First bit in the flags, must be 0
     *
     */
    java.lang.Boolean isReservedFlag();
    
    /**
     * Second bit in the flags, Don't Fragment Flag
     *
     */
    java.lang.Boolean isDfFlag();
    
    /**
     * Third bit in the flags, More Fragments Flag
     *
     */
    java.lang.Boolean isMfFlag();
    
    /**
     * Specifies the offset of a particular fragment relative to the beginning of the 
     * original unfragmented IP datagram
     *
     */
    java.lang.Integer getFragmentOffset();
    
    /**
     * Time to live
     *
     */
    java.lang.Short getTtl();
    
    /**
     * Protocol for the data
     *
     */
    java.lang.Short getProtocol();
    
    /**
     * Header Checksum
     *
     */
    java.lang.Integer getHeaderChecksum();
    
    java.lang.String getSourceAddress();
    
    java.lang.String getDestinationAddress();
    
    byte[] getIpv4Options();

}

