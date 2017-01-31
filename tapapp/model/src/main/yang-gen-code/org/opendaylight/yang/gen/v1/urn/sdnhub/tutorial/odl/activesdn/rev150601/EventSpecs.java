package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs.EventAction;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * grouping event-specs {
 *     leaf switch-id {
 *         type int32;
 *     }
 *     leaf in-port-id {
 *         type uint32;
 *     }
 *     leaf src-mac-address {
 *         type string;
 *     }
 *     leaf dst-mac-address {
 *         type string;
 *     }
 *     leaf src-ip-address {
 *         type string;
 *     }
 *     leaf dst-ip-address {
 *         type string;
 *     }
 *     leaf traffic-protocol {
 *         type traffic-type;
 *     }
 *     leaf count {
 *         type uint32;
 *     }
 *     leaf duration {
 *         type uint32;
 *     }
 *     leaf hold-notification {
 *         type int32;
 *     }
 *     leaf event-action {
 *         type enumeration;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/event-specs</i>
 *
 */
public interface EventSpecs
    extends
    DataObject
{


    public enum EventAction {
        DROP(0),
        
        NOTIFY(1),
        
        DROPANDNOTIFY(2)
        ;
    
    
        int value;
        private static final java.util.Map<java.lang.Integer, EventAction> VALUE_MAP;
    
        static {
            final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, EventAction> b = com.google.common.collect.ImmutableMap.builder();
            for (EventAction enumItem : EventAction.values())
            {
                b.put(enumItem.value, enumItem);
            }
    
            VALUE_MAP = b.build();
        }
    
        private EventAction(int value) {
            this.value = value;
        }
    
        /**
         * @return integer value
         */
        public int getIntValue() {
            return value;
        }
    
        /**
         * @param valueArg
         * @return corresponding EventAction item
         */
        public static EventAction forValue(int valueArg) {
            return VALUE_MAP.get(valueArg);
        }
    }

    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "event-specs").intern();

    /**
     * ID of the switch generated Packet_IN
     *
     */
    java.lang.Integer getSwitchId();
    
    /**
     * Input port of the switch that received data packet.
     *
     */
    java.lang.Long getInPortId();
    
    /**
     * MAC address of the Host generated packet, e.g., 00:00:00:00:00:01
     *
     */
    java.lang.String getSrcMacAddress();
    
    /**
     * MAC address of the destination Host, e.g., 00:00:00:00:00:02
     *
     */
    java.lang.String getDstMacAddress();
    
    /**
     * IP address of the Host generated data packet, e.g., 10.0.0.1/32
     *
     */
    java.lang.String getSrcIpAddress();
    
    /**
     * IP address of the destination Host, e.g., 10.0.0.2/32
     *
     */
    java.lang.String getDstIpAddress();
    
    TrafficType getTrafficProtocol();
    
    java.lang.Long getCount();
    
    java.lang.Long getDuration();
    
    /**
     * This value is used only for Drop &amp; Notify case where if you want to hold 
     * notification immediately after drop.
     *
     */
    java.lang.Integer getHoldNotification();
    
    EventAction getEventAction();

}

