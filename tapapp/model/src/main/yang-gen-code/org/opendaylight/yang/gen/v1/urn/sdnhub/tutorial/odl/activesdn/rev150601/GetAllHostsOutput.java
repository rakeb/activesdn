package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.hosts.output.HostsInfo;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * container output {
 *     list hosts-info {
 *         key "id"
 *         leaf id {
 *             type uint32;
 *         }
 *         leaf host-mac-address {
 *             type mac-address;
 *         }
 *         leaf host-ip-address {
 *             type local-ipv4-prefix;
 *         }
 *         leaf host-last-seen {
 *             type string;
 *         }
 *         leaf host-first-seen {
 *             type string;
 *         }
 *         leaf node-connected-to {
 *             type leafref;
 *         }
 *         leaf node-connector-connected-to {
 *             type leafref;
 *         }
 *         uses host-info;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/get-all-hosts/output</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetAllHostsOutputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetAllHostsOutputBuilder
 *
 */
public interface GetAllHostsOutput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetAllHostsOutput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "output").intern();

    List<HostsInfo> getHostsInfo();

}

