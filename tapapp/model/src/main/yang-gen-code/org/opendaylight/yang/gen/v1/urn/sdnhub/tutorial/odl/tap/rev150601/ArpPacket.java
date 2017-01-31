package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container arp-packet {
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
 *     uses arp-packet-fields;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/arp-packet</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketBuilder
 *
 */
public interface ArpPacket
    extends
    ChildOf<TapData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>,
    ArpPacketFields
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "arp-packet").intern();


}

