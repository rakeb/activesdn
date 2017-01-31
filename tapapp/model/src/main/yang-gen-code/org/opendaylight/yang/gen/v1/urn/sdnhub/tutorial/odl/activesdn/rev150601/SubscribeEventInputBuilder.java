package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs.EventAction;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput
 *
 */
public class SubscribeEventInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput> {

    private java.lang.Long _count;
    private java.lang.String _dstIpAddress;
    private java.lang.String _dstMacAddress;
    private java.lang.Long _duration;
    private EventAction _eventAction;
    private java.lang.Integer _holdNotification;
    private java.lang.Long _inPortId;
    private java.lang.String _srcIpAddress;
    private java.lang.String _srcMacAddress;
    private java.lang.Integer _switchId;
    private TrafficType _trafficProtocol;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>> augmentation = Collections.emptyMap();

    public SubscribeEventInputBuilder() {
    }
    public SubscribeEventInputBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs arg) {
        this._switchId = arg.getSwitchId();
        this._inPortId = arg.getInPortId();
        this._srcMacAddress = arg.getSrcMacAddress();
        this._dstMacAddress = arg.getDstMacAddress();
        this._srcIpAddress = arg.getSrcIpAddress();
        this._dstIpAddress = arg.getDstIpAddress();
        this._trafficProtocol = arg.getTrafficProtocol();
        this._count = arg.getCount();
        this._duration = arg.getDuration();
        this._holdNotification = arg.getHoldNotification();
        this._eventAction = arg.getEventAction();
    }

    public SubscribeEventInputBuilder(SubscribeEventInput base) {
        this._count = base.getCount();
        this._dstIpAddress = base.getDstIpAddress();
        this._dstMacAddress = base.getDstMacAddress();
        this._duration = base.getDuration();
        this._eventAction = base.getEventAction();
        this._holdNotification = base.getHoldNotification();
        this._inPortId = base.getInPortId();
        this._srcIpAddress = base.getSrcIpAddress();
        this._srcMacAddress = base.getSrcMacAddress();
        this._switchId = base.getSwitchId();
        this._trafficProtocol = base.getTrafficProtocol();
        if (base instanceof SubscribeEventInputImpl) {
            SubscribeEventInputImpl impl = (SubscribeEventInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs) {
            this._switchId = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getSwitchId();
            this._inPortId = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getInPortId();
            this._srcMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getSrcMacAddress();
            this._dstMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getDstMacAddress();
            this._srcIpAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getSrcIpAddress();
            this._dstIpAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getDstIpAddress();
            this._trafficProtocol = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getTrafficProtocol();
            this._count = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getCount();
            this._duration = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getDuration();
            this._holdNotification = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getHoldNotification();
            this._eventAction = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs)arg).getEventAction();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.Long getCount() {
        return _count;
    }
    
    public java.lang.String getDstIpAddress() {
        return _dstIpAddress;
    }
    
    public java.lang.String getDstMacAddress() {
        return _dstMacAddress;
    }
    
    public java.lang.Long getDuration() {
        return _duration;
    }
    
    public EventAction getEventAction() {
        return _eventAction;
    }
    
    public java.lang.Integer getHoldNotification() {
        return _holdNotification;
    }
    
    public java.lang.Long getInPortId() {
        return _inPortId;
    }
    
    public java.lang.String getSrcIpAddress() {
        return _srcIpAddress;
    }
    
    public java.lang.String getSrcMacAddress() {
        return _srcMacAddress;
    }
    
    public java.lang.Integer getSwitchId() {
        return _switchId;
    }
    
    public TrafficType getTrafficProtocol() {
        return _trafficProtocol;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkCountRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public SubscribeEventInputBuilder setCount(final java.lang.Long value) {
    if (value != null) {
        checkCountRange(value);
    }
        this._count = value;
        return this;
    }
    
     
    public SubscribeEventInputBuilder setDstIpAddress(final java.lang.String value) {
        this._dstIpAddress = value;
        return this;
    }
    
     
    public SubscribeEventInputBuilder setDstMacAddress(final java.lang.String value) {
        this._dstMacAddress = value;
        return this;
    }
    
     
     private static void checkDurationRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public SubscribeEventInputBuilder setDuration(final java.lang.Long value) {
    if (value != null) {
        checkDurationRange(value);
    }
        this._duration = value;
        return this;
    }
    
     
    public SubscribeEventInputBuilder setEventAction(final EventAction value) {
        this._eventAction = value;
        return this;
    }
    
     
    public SubscribeEventInputBuilder setHoldNotification(final java.lang.Integer value) {
        this._holdNotification = value;
        return this;
    }
    
     
     private static void checkInPortIdRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public SubscribeEventInputBuilder setInPortId(final java.lang.Long value) {
    if (value != null) {
        checkInPortIdRange(value);
    }
        this._inPortId = value;
        return this;
    }
    
     
    public SubscribeEventInputBuilder setSrcIpAddress(final java.lang.String value) {
        this._srcIpAddress = value;
        return this;
    }
    
     
    public SubscribeEventInputBuilder setSrcMacAddress(final java.lang.String value) {
        this._srcMacAddress = value;
        return this;
    }
    
     
    public SubscribeEventInputBuilder setSwitchId(final java.lang.Integer value) {
        this._switchId = value;
        return this;
    }
    
     
    public SubscribeEventInputBuilder setTrafficProtocol(final TrafficType value) {
        this._trafficProtocol = value;
        return this;
    }
    
    public SubscribeEventInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public SubscribeEventInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public SubscribeEventInput build() {
        return new SubscribeEventInputImpl(this);
    }

    private static final class SubscribeEventInputImpl implements SubscribeEventInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput.class;
        }

        private final java.lang.Long _count;
        private final java.lang.String _dstIpAddress;
        private final java.lang.String _dstMacAddress;
        private final java.lang.Long _duration;
        private final EventAction _eventAction;
        private final java.lang.Integer _holdNotification;
        private final java.lang.Long _inPortId;
        private final java.lang.String _srcIpAddress;
        private final java.lang.String _srcMacAddress;
        private final java.lang.Integer _switchId;
        private final TrafficType _trafficProtocol;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>> augmentation = Collections.emptyMap();

        private SubscribeEventInputImpl(SubscribeEventInputBuilder base) {
            this._count = base.getCount();
            this._dstIpAddress = base.getDstIpAddress();
            this._dstMacAddress = base.getDstMacAddress();
            this._duration = base.getDuration();
            this._eventAction = base.getEventAction();
            this._holdNotification = base.getHoldNotification();
            this._inPortId = base.getInPortId();
            this._srcIpAddress = base.getSrcIpAddress();
            this._srcMacAddress = base.getSrcMacAddress();
            this._switchId = base.getSwitchId();
            this._trafficProtocol = base.getTrafficProtocol();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Long getCount() {
            return _count;
        }
        
        @Override
        public java.lang.String getDstIpAddress() {
            return _dstIpAddress;
        }
        
        @Override
        public java.lang.String getDstMacAddress() {
            return _dstMacAddress;
        }
        
        @Override
        public java.lang.Long getDuration() {
            return _duration;
        }
        
        @Override
        public EventAction getEventAction() {
            return _eventAction;
        }
        
        @Override
        public java.lang.Integer getHoldNotification() {
            return _holdNotification;
        }
        
        @Override
        public java.lang.Long getInPortId() {
            return _inPortId;
        }
        
        @Override
        public java.lang.String getSrcIpAddress() {
            return _srcIpAddress;
        }
        
        @Override
        public java.lang.String getSrcMacAddress() {
            return _srcMacAddress;
        }
        
        @Override
        public java.lang.Integer getSwitchId() {
            return _switchId;
        }
        
        @Override
        public TrafficType getTrafficProtocol() {
            return _trafficProtocol;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        private int hash = 0;
        private volatile boolean hashValid = false;
        
        @Override
        public int hashCode() {
            if (hashValid) {
                return hash;
            }
        
            final int prime = 31;
            int result = 1;
            result = prime * result + Objects.hashCode(_count);
            result = prime * result + Objects.hashCode(_dstIpAddress);
            result = prime * result + Objects.hashCode(_dstMacAddress);
            result = prime * result + Objects.hashCode(_duration);
            result = prime * result + Objects.hashCode(_eventAction);
            result = prime * result + Objects.hashCode(_holdNotification);
            result = prime * result + Objects.hashCode(_inPortId);
            result = prime * result + Objects.hashCode(_srcIpAddress);
            result = prime * result + Objects.hashCode(_srcMacAddress);
            result = prime * result + Objects.hashCode(_switchId);
            result = prime * result + Objects.hashCode(_trafficProtocol);
            result = prime * result + Objects.hashCode(augmentation);
        
            hash = result;
            hashValid = true;
            return result;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataObject)) {
                return false;
            }
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput)obj;
            if (!Objects.equals(_count, other.getCount())) {
                return false;
            }
            if (!Objects.equals(_dstIpAddress, other.getDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_dstMacAddress, other.getDstMacAddress())) {
                return false;
            }
            if (!Objects.equals(_duration, other.getDuration())) {
                return false;
            }
            if (!Objects.equals(_eventAction, other.getEventAction())) {
                return false;
            }
            if (!Objects.equals(_holdNotification, other.getHoldNotification())) {
                return false;
            }
            if (!Objects.equals(_inPortId, other.getInPortId())) {
                return false;
            }
            if (!Objects.equals(_srcIpAddress, other.getSrcIpAddress())) {
                return false;
            }
            if (!Objects.equals(_srcMacAddress, other.getSrcMacAddress())) {
                return false;
            }
            if (!Objects.equals(_switchId, other.getSwitchId())) {
                return false;
            }
            if (!Objects.equals(_trafficProtocol, other.getTrafficProtocol())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                SubscribeEventInputImpl otherImpl = (SubscribeEventInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>> e : augmentation.entrySet()) {
                    if (!e.getValue().equals(other.getAugmentation(e.getKey()))) {
                        return false;
                    }
                }
                // .. and give the other one the chance to do the same
                if (!obj.equals(this)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("SubscribeEventInput [");
            boolean first = true;
        
            if (_count != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_count=");
                builder.append(_count);
             }
            if (_dstIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstIpAddress=");
                builder.append(_dstIpAddress);
             }
            if (_dstMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstMacAddress=");
                builder.append(_dstMacAddress);
             }
            if (_duration != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_duration=");
                builder.append(_duration);
             }
            if (_eventAction != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_eventAction=");
                builder.append(_eventAction);
             }
            if (_holdNotification != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_holdNotification=");
                builder.append(_holdNotification);
             }
            if (_inPortId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_inPortId=");
                builder.append(_inPortId);
             }
            if (_srcIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_srcIpAddress=");
                builder.append(_srcIpAddress);
             }
            if (_srcMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_srcMacAddress=");
                builder.append(_srcMacAddress);
             }
            if (_switchId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_switchId=");
                builder.append(_switchId);
             }
            if (_trafficProtocol != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_trafficProtocol=");
                builder.append(_trafficProtocol);
             }
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("augmentation=");
            builder.append(augmentation.values());
            return builder.append(']').toString();
        }
    }

}
