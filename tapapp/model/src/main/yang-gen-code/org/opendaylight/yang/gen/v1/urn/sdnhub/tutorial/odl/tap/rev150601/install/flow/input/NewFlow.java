package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowInput;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container new-flow {
 *     leaf in-port {
 *         type leafref;
 *     }
 *     leaf src-mac-address {
 *         type mac-address;
 *     }
 *     leaf dst-mac-address {
 *         type mac-address;
 *     }
 *     leaf src-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf dst-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf traffic-match {
 *         type traffic-type;
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
 *     container custom-info {
 *         leaf dl-type {
 *             type dl-type;
 *         }
 *         leaf nw-proto {
 *             type nw-proto;
 *         }
 *         leaf tp-dst {
 *             type tp-dst;
 *         }
 *     }
 *     uses match;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/install-flow/input/new-flow</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlowBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlowBuilder
 *
 */
public interface NewFlow
    extends
    ChildOf<InstallFlowInput>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>,
    Match
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "new-flow").intern();


}

