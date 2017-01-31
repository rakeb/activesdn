package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.ipv4.ttl._case.SetIpv4Ttl;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.FlowActions;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * This sets the TTL value of the packet.
 *
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * case set-ipv4-ttl-case {
 *     container set-ipv4-ttl {
 *         leaf ttl-value {
 *             type uint8;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/flow-actions/flow-actions/set-ipv4-ttl-case</i>
 *
 */
public interface SetIpv4TtlCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetIpv4TtlCase>,
    FlowActions
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "set-ipv4-ttl-case").intern();

    SetIpv4Ttl getSetIpv4Ttl();

}

