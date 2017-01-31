package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MeterFlags;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit
 *
 */
public class SetRateLimitBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit> {

    private java.lang.Long _bandBurstSize;
    private java.lang.Long _bandRate;
    private java.lang.Long _dropBurstSize;
    private java.lang.Long _dropRate;
    private NodeConnectorId _egressPort;
    private MeterFlags _meterType;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>> augmentation = Collections.emptyMap();

    public SetRateLimitBuilder() {
    }

    public SetRateLimitBuilder(SetRateLimit base) {
        this._bandBurstSize = base.getBandBurstSize();
        this._bandRate = base.getBandRate();
        this._dropBurstSize = base.getDropBurstSize();
        this._dropRate = base.getDropRate();
        this._egressPort = base.getEgressPort();
        this._meterType = base.getMeterType();
        if (base instanceof SetRateLimitImpl) {
            SetRateLimitImpl impl = (SetRateLimitImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.Long getBandBurstSize() {
        return _bandBurstSize;
    }
    
    public java.lang.Long getBandRate() {
        return _bandRate;
    }
    
    public java.lang.Long getDropBurstSize() {
        return _dropBurstSize;
    }
    
    public java.lang.Long getDropRate() {
        return _dropRate;
    }
    
    public NodeConnectorId getEgressPort() {
        return _egressPort;
    }
    
    public MeterFlags getMeterType() {
        return _meterType;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkBandBurstSizeRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public SetRateLimitBuilder setBandBurstSize(final java.lang.Long value) {
    if (value != null) {
        checkBandBurstSizeRange(value);
    }
        this._bandBurstSize = value;
        return this;
    }
    
     
     private static void checkBandRateRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public SetRateLimitBuilder setBandRate(final java.lang.Long value) {
    if (value != null) {
        checkBandRateRange(value);
    }
        this._bandRate = value;
        return this;
    }
    
     
     private static void checkDropBurstSizeRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public SetRateLimitBuilder setDropBurstSize(final java.lang.Long value) {
    if (value != null) {
        checkDropBurstSizeRange(value);
    }
        this._dropBurstSize = value;
        return this;
    }
    
     
     private static void checkDropRateRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public SetRateLimitBuilder setDropRate(final java.lang.Long value) {
    if (value != null) {
        checkDropRateRange(value);
    }
        this._dropRate = value;
        return this;
    }
    
     
    public SetRateLimitBuilder setEgressPort(final NodeConnectorId value) {
        this._egressPort = value;
        return this;
    }
    
     
    public SetRateLimitBuilder setMeterType(final MeterFlags value) {
        this._meterType = value;
        return this;
    }
    
    public SetRateLimitBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public SetRateLimitBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public SetRateLimit build() {
        return new SetRateLimitImpl(this);
    }

    private static final class SetRateLimitImpl implements SetRateLimit {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit.class;
        }

        private final java.lang.Long _bandBurstSize;
        private final java.lang.Long _bandRate;
        private final java.lang.Long _dropBurstSize;
        private final java.lang.Long _dropRate;
        private final NodeConnectorId _egressPort;
        private final MeterFlags _meterType;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>> augmentation = Collections.emptyMap();

        private SetRateLimitImpl(SetRateLimitBuilder base) {
            this._bandBurstSize = base.getBandBurstSize();
            this._bandRate = base.getBandRate();
            this._dropBurstSize = base.getDropBurstSize();
            this._dropRate = base.getDropRate();
            this._egressPort = base.getEgressPort();
            this._meterType = base.getMeterType();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Long getBandBurstSize() {
            return _bandBurstSize;
        }
        
        @Override
        public java.lang.Long getBandRate() {
            return _bandRate;
        }
        
        @Override
        public java.lang.Long getDropBurstSize() {
            return _dropBurstSize;
        }
        
        @Override
        public java.lang.Long getDropRate() {
            return _dropRate;
        }
        
        @Override
        public NodeConnectorId getEgressPort() {
            return _egressPort;
        }
        
        @Override
        public MeterFlags getMeterType() {
            return _meterType;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_bandBurstSize);
            result = prime * result + Objects.hashCode(_bandRate);
            result = prime * result + Objects.hashCode(_dropBurstSize);
            result = prime * result + Objects.hashCode(_dropRate);
            result = prime * result + Objects.hashCode(_egressPort);
            result = prime * result + Objects.hashCode(_meterType);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit)obj;
            if (!Objects.equals(_bandBurstSize, other.getBandBurstSize())) {
                return false;
            }
            if (!Objects.equals(_bandRate, other.getBandRate())) {
                return false;
            }
            if (!Objects.equals(_dropBurstSize, other.getDropBurstSize())) {
                return false;
            }
            if (!Objects.equals(_dropRate, other.getDropRate())) {
                return false;
            }
            if (!Objects.equals(_egressPort, other.getEgressPort())) {
                return false;
            }
            if (!Objects.equals(_meterType, other.getMeterType())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                SetRateLimitImpl otherImpl = (SetRateLimitImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("SetRateLimit [");
            boolean first = true;
        
            if (_bandBurstSize != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bandBurstSize=");
                builder.append(_bandBurstSize);
             }
            if (_bandRate != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bandRate=");
                builder.append(_bandRate);
             }
            if (_dropBurstSize != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dropBurstSize=");
                builder.append(_dropBurstSize);
             }
            if (_dropRate != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dropRate=");
                builder.append(_dropRate);
             }
            if (_egressPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_egressPort=");
                builder.append(_egressPort);
             }
            if (_meterType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_meterType=");
                builder.append(_meterType);
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
