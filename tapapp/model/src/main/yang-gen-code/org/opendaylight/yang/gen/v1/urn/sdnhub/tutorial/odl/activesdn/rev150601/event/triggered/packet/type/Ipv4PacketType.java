package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.PacketType;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * case ipv4-packet-type {
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
 * <i>activesdn/event-triggered/packet-type/ipv4-packet-type</i>
 *
 */
public interface Ipv4PacketType
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>,
    Ipv4PacketHeaderFields,
    PacketType
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "ipv4-packet-type").intern();


}

