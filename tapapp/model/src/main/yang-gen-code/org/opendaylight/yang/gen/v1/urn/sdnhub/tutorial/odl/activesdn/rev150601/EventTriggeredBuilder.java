package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.PacketType;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered.TriggeredEventType;
import java.util.Collections;
import java.util.Arrays;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered
 *
 */
public class EventTriggeredBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered> {

    private java.lang.String _eventId;
    private java.lang.Integer _inPortNumber;
    private PacketType _packetType;
    private byte[] _payload;
    private java.lang.String _stringPayload;
    private java.lang.Integer _switchId;
    private TriggeredEventType _triggeredEventType;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>> augmentation = Collections.emptyMap();

    public EventTriggeredBuilder() {
    }

    public EventTriggeredBuilder(EventTriggered base) {
        this._eventId = base.getEventId();
        this._inPortNumber = base.getInPortNumber();
        this._packetType = base.getPacketType();
        this._payload = base.getPayload();
        this._stringPayload = base.getStringPayload();
        this._switchId = base.getSwitchId();
        this._triggeredEventType = base.getTriggeredEventType();
        if (base instanceof EventTriggeredImpl) {
            EventTriggeredImpl impl = (EventTriggeredImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getEventId() {
        return _eventId;
    }
    
    public java.lang.Integer getInPortNumber() {
        return _inPortNumber;
    }
    
    public PacketType getPacketType() {
        return _packetType;
    }
    
    public byte[] getPayload() {
        return _payload == null ? null : _payload.clone();
    }
    
    public java.lang.String getStringPayload() {
        return _stringPayload;
    }
    
    public java.lang.Integer getSwitchId() {
        return _switchId;
    }
    
    public TriggeredEventType getTriggeredEventType() {
        return _triggeredEventType;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public EventTriggeredBuilder setEventId(final java.lang.String value) {
        this._eventId = value;
        return this;
    }
    
     
    public EventTriggeredBuilder setInPortNumber(final java.lang.Integer value) {
        this._inPortNumber = value;
        return this;
    }
    
     
    public EventTriggeredBuilder setPacketType(final PacketType value) {
        this._packetType = value;
        return this;
    }
    
     
    public EventTriggeredBuilder setPayload(final byte[] value) {
        this._payload = value;
        return this;
    }
    
     
    public EventTriggeredBuilder setStringPayload(final java.lang.String value) {
        this._stringPayload = value;
        return this;
    }
    
     
    public EventTriggeredBuilder setSwitchId(final java.lang.Integer value) {
        this._switchId = value;
        return this;
    }
    
     
    public EventTriggeredBuilder setTriggeredEventType(final TriggeredEventType value) {
        this._triggeredEventType = value;
        return this;
    }
    
    public EventTriggeredBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public EventTriggeredBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public EventTriggered build() {
        return new EventTriggeredImpl(this);
    }

    private static final class EventTriggeredImpl implements EventTriggered {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered.class;
        }

        private final java.lang.String _eventId;
        private final java.lang.Integer _inPortNumber;
        private final PacketType _packetType;
        private final byte[] _payload;
        private final java.lang.String _stringPayload;
        private final java.lang.Integer _switchId;
        private final TriggeredEventType _triggeredEventType;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>> augmentation = Collections.emptyMap();

        private EventTriggeredImpl(EventTriggeredBuilder base) {
            this._eventId = base.getEventId();
            this._inPortNumber = base.getInPortNumber();
            this._packetType = base.getPacketType();
            this._payload = base.getPayload();
            this._stringPayload = base.getStringPayload();
            this._switchId = base.getSwitchId();
            this._triggeredEventType = base.getTriggeredEventType();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getEventId() {
            return _eventId;
        }
        
        @Override
        public java.lang.Integer getInPortNumber() {
            return _inPortNumber;
        }
        
        @Override
        public PacketType getPacketType() {
            return _packetType;
        }
        
        @Override
        public byte[] getPayload() {
            return _payload == null ? null : _payload.clone();
        }
        
        @Override
        public java.lang.String getStringPayload() {
            return _stringPayload;
        }
        
        @Override
        public java.lang.Integer getSwitchId() {
            return _switchId;
        }
        
        @Override
        public TriggeredEventType getTriggeredEventType() {
            return _triggeredEventType;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_eventId);
            result = prime * result + Objects.hashCode(_inPortNumber);
            result = prime * result + Objects.hashCode(_packetType);
            result = prime * result + Arrays.hashCode(_payload);
            result = prime * result + Objects.hashCode(_stringPayload);
            result = prime * result + Objects.hashCode(_switchId);
            result = prime * result + Objects.hashCode(_triggeredEventType);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered)obj;
            if (!Objects.equals(_eventId, other.getEventId())) {
                return false;
            }
            if (!Objects.equals(_inPortNumber, other.getInPortNumber())) {
                return false;
            }
            if (!Objects.equals(_packetType, other.getPacketType())) {
                return false;
            }
            if (!Arrays.equals(_payload, other.getPayload())) {
                return false;
            }
            if (!Objects.equals(_stringPayload, other.getStringPayload())) {
                return false;
            }
            if (!Objects.equals(_switchId, other.getSwitchId())) {
                return false;
            }
            if (!Objects.equals(_triggeredEventType, other.getTriggeredEventType())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                EventTriggeredImpl otherImpl = (EventTriggeredImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("EventTriggered [");
            boolean first = true;
        
            if (_eventId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_eventId=");
                builder.append(_eventId);
             }
            if (_inPortNumber != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_inPortNumber=");
                builder.append(_inPortNumber);
             }
            if (_packetType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_packetType=");
                builder.append(_packetType);
             }
            if (_payload != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_payload=");
                builder.append(Arrays.toString(_payload));
             }
            if (_stringPayload != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_stringPayload=");
                builder.append(_stringPayload);
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
            if (_triggeredEventType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_triggeredEventType=");
                builder.append(_triggeredEventType);
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
