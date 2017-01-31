package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.criteria;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MatchCriteria;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.FieldType;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container ip-address {
 *     leaf type {
 *         type field-type;
 *     }
 *     leaf value {
 *         type ipv4-prefix;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/match-criteria/ip-address</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.criteria.IpAddressBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.criteria.IpAddressBuilder
 *
 */
public interface IpAddress
    extends
    ChildOf<MatchCriteria>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.criteria.IpAddress>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "ip-address").intern();

    FieldType getType();
    
    Ipv4Prefix getValue();

}

