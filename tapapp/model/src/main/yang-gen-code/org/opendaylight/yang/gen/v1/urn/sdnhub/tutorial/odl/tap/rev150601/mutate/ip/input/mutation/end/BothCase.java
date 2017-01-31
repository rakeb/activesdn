package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.both._case.Both;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.MutationEnd;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * case both-case {
 *     container both {
 *         leaf new-src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf new-dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/mutate-ip/input/mutation-end/both-case</i>
 *
 */
public interface BothCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.BothCase>,
    MutationEnd
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "both-case").intern();

    Both getBoth();

}

