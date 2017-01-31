package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container tcp-packet-header {
 *     leaf source-port {
 *         type int16;
 *     }
 *     leaf dest-port {
 *         type int16;
 *     }
 *     leaf sequence-number {
 *         type int32;
 *     }
 *     leaf syn-flag {
 *         type boolean;
 *     }
 *     leaf rst-flag {
 *         type boolean;
 *     }
 *     leaf ack-flag {
 *         type boolean;
 *     }
 *     leaf fin-flag {
 *         type boolean;
 *     }
 *     uses tcp-packet-fields;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/tcp-packet-header</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeaderBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeaderBuilder
 *
 */
public interface TcpPacketHeader
    extends
    ChildOf<TapData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>,
    TcpPacketFields
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "tcp-packet-header").intern();


}

