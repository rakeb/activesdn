package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ConnectedHosts;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * list connected-host {
 *     key "host-ip-address"
 *     leaf host-mac-address {
 *         type mac-address;
 *     }
 *     leaf host-ip-address {
 *         type local-ipv4-prefix;
 *     }
 *     leaf host-last-seen {
 *         type string;
 *     }
 *     leaf host-first-seen {
 *         type string;
 *     }
 *     leaf node-connected-to {
 *         type leafref;
 *     }
 *     leaf node-connector-connected-to {
 *         type leafref;
 *     }
 *     uses host-info;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/connected-hosts/connected-host</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHostBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHostBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHostKey
 *
 */
public interface ConnectedHost
    extends
    ChildOf<ConnectedHosts>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>,
    HostInfo,
    Identifiable<ConnectedHostKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "connected-host").intern();

    /**
     * Returns Primary Key of Yang List Type
     *
     */
    ConnectedHostKey getKey();

}

