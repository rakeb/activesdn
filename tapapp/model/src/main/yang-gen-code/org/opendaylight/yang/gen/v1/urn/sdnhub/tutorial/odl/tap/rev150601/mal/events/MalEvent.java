package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mal.events;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MalEvents;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container mal-event {
 *     leaf id {
 *         type string;
 *     }
 *     leaf count {
 *         type uint32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/mal-events/mal-event</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mal.events.MalEventBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mal.events.MalEventBuilder
 *
 */
public interface MalEvent
    extends
    ChildOf<MalEvents>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mal.events.MalEvent>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "mal-event").intern();

    java.lang.String getId();
    
    java.lang.Long getCount();

}

