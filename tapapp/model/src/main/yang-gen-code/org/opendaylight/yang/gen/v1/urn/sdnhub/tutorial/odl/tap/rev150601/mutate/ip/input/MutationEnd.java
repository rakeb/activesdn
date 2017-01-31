package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input;
import org.opendaylight.yangtools.yang.binding.DataContainer;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * choice mutation-end {
 *     case both-case {
 *         container both {
 *             leaf new-src-ip-address {
 *                 type ipv4-prefix;
 *             }
 *             leaf new-dst-ip-address {
 *                 type ipv4-prefix;
 *             }
 *         }
 *     }
 *     case dst-only-case {
 *         container dst-only {
 *             leaf new-dst-ip-address {
 *                 type ipv4-prefix;
 *             }
 *         }
 *     }
 *     case source-only-case {
 *         container source-only {
 *             leaf new-src-ip-address {
 *                 type ipv4-prefix;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/mutate-ip/input/mutation-end</i>
 *
 */
public interface MutationEnd
    extends
    DataContainer
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "mutation-end").intern();


}

