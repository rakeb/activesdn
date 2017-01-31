package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * grouping arp-packet-fields {
 *     leaf hardware-type {
 *         type known-hardware-type;
 *     }
 *     leaf protocol-type {
 *         type known-ether-type;
 *     }
 *     leaf hardware-length {
 *         type uint8;
 *     }
 *     leaf protocol-length {
 *         type uint8;
 *     }
 *     leaf operation {
 *         type known-operation;
 *     }
 *     leaf source-hardware-address {
 *         type string;
 *     }
 *     leaf source-protocol-address {
 *         type string;
 *     }
 *     leaf destination-hardware-address {
 *         type string;
 *     }
 *     leaf destination-protocol-address {
 *         type string;
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
 * <i>tap/arp-packet-fields</i>
 *
 */
public interface ArpPacketFields
    extends
    DataObject,
    PacketFields
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "arp-packet-fields").intern();

    /**
     * Network protocol type
     *
     */
    KnownHardwareType getHardwareType();
    
    /**
     * Higher layer protocol for which the ARP request is intended. This corresponds to
     * EtherType.
     *
     */
    KnownEtherType getProtocolType();
    
    /**
     * Length (in octets) of a hardware address. Ethernet address size is 6.
     *
     */
    java.lang.Short getHardwareLength();
    
    /**
     * Length (in octets) of addresses used in the higher layer protocol. IPv4 address 
     * size is 4.
     *
     */
    java.lang.Short getProtocolLength();
    
    /**
     * Specifies the operation that the sender is performing: 1 for request, 2 for 
     * reply.
     *
     */
    KnownOperation getOperation();
    
    /**
     * Media address of the sender.
     *
     */
    java.lang.String getSourceHardwareAddress();
    
    /**
     * Internet address of the sender.
     *
     */
    java.lang.String getSourceProtocolAddress();
    
    /**
     * Media address of the destination/target.
     *
     */
    java.lang.String getDestinationHardwareAddress();
    
    /**
     * Internet address of the destination/target.
     *
     */
    java.lang.String getDestinationProtocolAddress();

}

