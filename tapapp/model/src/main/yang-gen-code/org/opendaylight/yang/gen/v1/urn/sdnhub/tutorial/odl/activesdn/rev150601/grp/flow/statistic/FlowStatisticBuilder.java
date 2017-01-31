package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic
 *
 */
public class FlowStatisticBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic> {

    private java.lang.Long _byteCount;
    private java.lang.String _dstIpAddress;
    private java.lang.Integer _dstPort;
    private java.lang.Long _duration;
    private java.lang.String _flowId;
    private FlowStatisticKey _key;
    private java.lang.Long _packetCount;
    private java.lang.String _srcIpAddress;
    private java.lang.Integer _srcPort;
    private TrafficType _typeOfTraffic;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>> augmentation = Collections.emptyMap();

    public FlowStatisticBuilder() {
    }

    public FlowStatisticBuilder(FlowStatistic base) {
        if (base.getKey() == null) {
            this._key = new FlowStatisticKey(
                base.getFlowId()
            );
            this._flowId = base.getFlowId();
        } else {
            this._key = base.getKey();
            this._flowId = _key.getFlowId();
        }
        this._byteCount = base.getByteCount();
        this._dstIpAddress = base.getDstIpAddress();
        this._dstPort = base.getDstPort();
        this._duration = base.getDuration();
        this._packetCount = base.getPacketCount();
        this._srcIpAddress = base.getSrcIpAddress();
        this._srcPort = base.getSrcPort();
        this._typeOfTraffic = base.getTypeOfTraffic();
        if (base instanceof FlowStatisticImpl) {
            FlowStatisticImpl impl = (FlowStatisticImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.Long getByteCount() {
        return _byteCount;
    }
    
    public java.lang.String getDstIpAddress() {
        return _dstIpAddress;
    }
    
    public java.lang.Integer getDstPort() {
        return _dstPort;
    }
    
    public java.lang.Long getDuration() {
        return _duration;
    }
    
    public java.lang.String getFlowId() {
        return _flowId;
    }
    
    public FlowStatisticKey getKey() {
        return _key;
    }
    
    public java.lang.Long getPacketCount() {
        return _packetCount;
    }
    
    public java.lang.String getSrcIpAddress() {
        return _srcIpAddress;
    }
    
    public java.lang.Integer getSrcPort() {
        return _srcPort;
    }
    
    public TrafficType getTypeOfTraffic() {
        return _typeOfTraffic;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkByteCountRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public FlowStatisticBuilder setByteCount(final java.lang.Long value) {
    if (value != null) {
        checkByteCountRange(value);
    }
        this._byteCount = value;
        return this;
    }
    
     
    public FlowStatisticBuilder setDstIpAddress(final java.lang.String value) {
        this._dstIpAddress = value;
        return this;
    }
    
     
    public FlowStatisticBuilder setDstPort(final java.lang.Integer value) {
        this._dstPort = value;
        return this;
    }
    
     
     private static void checkDurationRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public FlowStatisticBuilder setDuration(final java.lang.Long value) {
    if (value != null) {
        checkDurationRange(value);
    }
        this._duration = value;
        return this;
    }
    
     
    public FlowStatisticBuilder setFlowId(final java.lang.String value) {
        this._flowId = value;
        return this;
    }
    
     
    public FlowStatisticBuilder setKey(final FlowStatisticKey value) {
        this._key = value;
        return this;
    }
    
     
     private static void checkPacketCountRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public FlowStatisticBuilder setPacketCount(final java.lang.Long value) {
    if (value != null) {
        checkPacketCountRange(value);
    }
        this._packetCount = value;
        return this;
    }
    
     
    public FlowStatisticBuilder setSrcIpAddress(final java.lang.String value) {
        this._srcIpAddress = value;
        return this;
    }
    
     
    public FlowStatisticBuilder setSrcPort(final java.lang.Integer value) {
        this._srcPort = value;
        return this;
    }
    
     
    public FlowStatisticBuilder setTypeOfTraffic(final TrafficType value) {
        this._typeOfTraffic = value;
        return this;
    }
    
    public FlowStatisticBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public FlowStatisticBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public FlowStatistic build() {
        return new FlowStatisticImpl(this);
    }

    private static final class FlowStatisticImpl implements FlowStatistic {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic.class;
        }

        private final java.lang.Long _byteCount;
        private final java.lang.String _dstIpAddress;
        private final java.lang.Integer _dstPort;
        private final java.lang.Long _duration;
        private final java.lang.String _flowId;
        private final FlowStatisticKey _key;
        private final java.lang.Long _packetCount;
        private final java.lang.String _srcIpAddress;
        private final java.lang.Integer _srcPort;
        private final TrafficType _typeOfTraffic;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>> augmentation = Collections.emptyMap();

        private FlowStatisticImpl(FlowStatisticBuilder base) {
            if (base.getKey() == null) {
                this._key = new FlowStatisticKey(
                    base.getFlowId()
                );
                this._flowId = base.getFlowId();
            } else {
                this._key = base.getKey();
                this._flowId = _key.getFlowId();
            }
            this._byteCount = base.getByteCount();
            this._dstIpAddress = base.getDstIpAddress();
            this._dstPort = base.getDstPort();
            this._duration = base.getDuration();
            this._packetCount = base.getPacketCount();
            this._srcIpAddress = base.getSrcIpAddress();
            this._srcPort = base.getSrcPort();
            this._typeOfTraffic = base.getTypeOfTraffic();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Long getByteCount() {
            return _byteCount;
        }
        
        @Override
        public java.lang.String getDstIpAddress() {
            return _dstIpAddress;
        }
        
        @Override
        public java.lang.Integer getDstPort() {
            return _dstPort;
        }
        
        @Override
        public java.lang.Long getDuration() {
            return _duration;
        }
        
        @Override
        public java.lang.String getFlowId() {
            return _flowId;
        }
        
        @Override
        public FlowStatisticKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.Long getPacketCount() {
            return _packetCount;
        }
        
        @Override
        public java.lang.String getSrcIpAddress() {
            return _srcIpAddress;
        }
        
        @Override
        public java.lang.Integer getSrcPort() {
            return _srcPort;
        }
        
        @Override
        public TrafficType getTypeOfTraffic() {
            return _typeOfTraffic;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_byteCount);
            result = prime * result + Objects.hashCode(_dstIpAddress);
            result = prime * result + Objects.hashCode(_dstPort);
            result = prime * result + Objects.hashCode(_duration);
            result = prime * result + Objects.hashCode(_flowId);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_packetCount);
            result = prime * result + Objects.hashCode(_srcIpAddress);
            result = prime * result + Objects.hashCode(_srcPort);
            result = prime * result + Objects.hashCode(_typeOfTraffic);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic)obj;
            if (!Objects.equals(_byteCount, other.getByteCount())) {
                return false;
            }
            if (!Objects.equals(_dstIpAddress, other.getDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_dstPort, other.getDstPort())) {
                return false;
            }
            if (!Objects.equals(_duration, other.getDuration())) {
                return false;
            }
            if (!Objects.equals(_flowId, other.getFlowId())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_packetCount, other.getPacketCount())) {
                return false;
            }
            if (!Objects.equals(_srcIpAddress, other.getSrcIpAddress())) {
                return false;
            }
            if (!Objects.equals(_srcPort, other.getSrcPort())) {
                return false;
            }
            if (!Objects.equals(_typeOfTraffic, other.getTypeOfTraffic())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                FlowStatisticImpl otherImpl = (FlowStatisticImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("FlowStatistic [");
            boolean first = true;
        
            if (_byteCount != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_byteCount=");
                builder.append(_byteCount);
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
            if (_dstPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstPort=");
                builder.append(_dstPort);
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
            if (_flowId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_flowId=");
                builder.append(_flowId);
             }
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_packetCount != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_packetCount=");
                builder.append(_packetCount);
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
            if (_srcPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_srcPort=");
                builder.append(_srcPort);
             }
            if (_typeOfTraffic != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_typeOfTraffic=");
                builder.append(_typeOfTraffic);
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
