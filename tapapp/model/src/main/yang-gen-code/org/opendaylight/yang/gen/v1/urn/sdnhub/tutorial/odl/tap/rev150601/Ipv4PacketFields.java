package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * grouping ipv4-packet-fields {
 *     leaf version {
 *         type uint8;
 *     }
 *     leaf ihl {
 *         type uint8;
 *     }
 *     leaf dscp {
 *         type uint8;
 *     }
 *     leaf ecn {
 *         type uint8;
 *     }
 *     leaf ipv4-length {
 *         type uint16;
 *     }
 *     leaf id {
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
 *         type known-ip-protocols;
 *     }
 *     leaf checksum {
 *         type uint16;
 *     }
 *     leaf source-ipv4 {
 *         type string;
 *     }
 *     leaf destination-ipv4 {
 *         type string;
 *     }
 *     leaf ipv4-options {
 *         type binary;
 *     }
 *     leaf payload-offset {
 *         type int32;
 *     }
 *     leaf payload-length {
 *         type int32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/ipv4-packet-fields</i>
 *
 */
public interface Ipv4PacketFields
    extends
    DataObject,
    PacketFields
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "ipv4-packet-fields").intern();

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
    java.lang.Short getDscp();
    
    /**
     * Explicit Congestion Notification
     *
     */
    java.lang.Short getEcn();
    
    /**
     * Packet size, including header and data, in bytes
     *
     */
    java.lang.Integer getIpv4Length();
    
    /**
     * Identification
     *
     */
    java.lang.Integer getId();
    
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
    KnownIpProtocols getProtocol();
    
    /**
     * Header Checksum
     *
     */
    java.lang.Integer getChecksum();
    
    java.lang.String getSourceIpv4();
    
    java.lang.String getDestinationIpv4();
    
    byte[] getIpv4Options();

}

