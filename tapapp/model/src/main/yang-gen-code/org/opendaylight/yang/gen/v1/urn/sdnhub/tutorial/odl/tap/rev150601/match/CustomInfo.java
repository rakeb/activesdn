package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container custom-info {
 *     leaf dl-type {
 *         type dl-type;
 *     }
 *     leaf nw-proto {
 *         type nw-proto;
 *     }
 *     leaf tp-dst {
 *         type tp-dst;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/match/custom-info</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfoBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfoBuilder
 *
 */
public interface CustomInfo
    extends
    ChildOf<Match>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "custom-info").intern();

    /**
     * Ethernet type
     *
     */
    java.lang.Integer getDlType();
    
    /**
     * Network protocol
     *
     */
    java.lang.Short getNwProto();
    
    /**
     * tcp destination port
     *
     */
    java.lang.Integer getTpDst();

}

