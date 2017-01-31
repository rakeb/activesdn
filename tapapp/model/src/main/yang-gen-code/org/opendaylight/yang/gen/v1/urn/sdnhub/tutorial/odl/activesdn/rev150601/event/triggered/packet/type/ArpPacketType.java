package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.PacketType;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * case arp-packet-type {
 *     leaf ethernet-src-mac-address {
 *         type string;
 *     }
 *     leaf ethernet-type {
 *         type string;
 *     }
 *     leaf hardware-type {
 *         type string;
 *     }
 *     leaf protocol-type {
 *         type string;
 *     }
 *     leaf hardware-address-length {
 *         type int32;
 *     }
 *     leaf protocol-address-length {
 *         type int32;
 *     }
 *     leaf opcode {
 *         type string;
 *     }
 *     leaf sender-hardware-address {
 *         type string;
 *     }
 *     leaf sender-protocol-address {
 *         type string;
 *     }
 *     leaf target-hardware-address {
 *         type string;
 *     }
 *     leaf target-protocol-address {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/event-triggered/packet-type/arp-packet-type</i>
 *
 */
public interface ArpPacketType
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>,
    ArpPacketHeaderFields,
    PacketType
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "arp-packet-type").intern();


}

