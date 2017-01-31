package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput
 *
 */
public class GetPortStatisticsOutputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput> {

    private java.lang.Long _receiveDrops;
    private java.lang.Long _totalReceived;
    private java.lang.Long _totalTransmitted;
    private java.lang.Long _transmitDrops;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>> augmentation = Collections.emptyMap();

    public GetPortStatisticsOutputBuilder() {
    }
    public GetPortStatisticsOutputBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpPortStatistics arg) {
        this._totalTransmitted = arg.getTotalTransmitted();
        this._totalReceived = arg.getTotalReceived();
        this._receiveDrops = arg.getReceiveDrops();
        this._transmitDrops = arg.getTransmitDrops();
    }

    public GetPortStatisticsOutputBuilder(GetPortStatisticsOutput base) {
        this._receiveDrops = base.getReceiveDrops();
        this._totalReceived = base.getTotalReceived();
        this._totalTransmitted = base.getTotalTransmitted();
        this._transmitDrops = base.getTransmitDrops();
        if (base instanceof GetPortStatisticsOutputImpl) {
            GetPortStatisticsOutputImpl impl = (GetPortStatisticsOutputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpPortStatistics</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpPortStatistics) {
            this._totalTransmitted = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpPortStatistics)arg).getTotalTransmitted();
            this._totalReceived = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpPortStatistics)arg).getTotalReceived();
            this._receiveDrops = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpPortStatistics)arg).getReceiveDrops();
            this._transmitDrops = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpPortStatistics)arg).getTransmitDrops();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpPortStatistics] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.Long getReceiveDrops() {
        return _receiveDrops;
    }
    
    public java.lang.Long getTotalReceived() {
        return _totalReceived;
    }
    
    public java.lang.Long getTotalTransmitted() {
        return _totalTransmitted;
    }
    
    public java.lang.Long getTransmitDrops() {
        return _transmitDrops;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkReceiveDropsRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public GetPortStatisticsOutputBuilder setReceiveDrops(final java.lang.Long value) {
    if (value != null) {
        checkReceiveDropsRange(value);
    }
        this._receiveDrops = value;
        return this;
    }
    
     
     private static void checkTotalReceivedRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public GetPortStatisticsOutputBuilder setTotalReceived(final java.lang.Long value) {
    if (value != null) {
        checkTotalReceivedRange(value);
    }
        this._totalReceived = value;
        return this;
    }
    
     
     private static void checkTotalTransmittedRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public GetPortStatisticsOutputBuilder setTotalTransmitted(final java.lang.Long value) {
    if (value != null) {
        checkTotalTransmittedRange(value);
    }
        this._totalTransmitted = value;
        return this;
    }
    
     
     private static void checkTransmitDropsRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public GetPortStatisticsOutputBuilder setTransmitDrops(final java.lang.Long value) {
    if (value != null) {
        checkTransmitDropsRange(value);
    }
        this._transmitDrops = value;
        return this;
    }
    
    public GetPortStatisticsOutputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public GetPortStatisticsOutputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public GetPortStatisticsOutput build() {
        return new GetPortStatisticsOutputImpl(this);
    }

    private static final class GetPortStatisticsOutputImpl implements GetPortStatisticsOutput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput.class;
        }

        private final java.lang.Long _receiveDrops;
        private final java.lang.Long _totalReceived;
        private final java.lang.Long _totalTransmitted;
        private final java.lang.Long _transmitDrops;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>> augmentation = Collections.emptyMap();

        private GetPortStatisticsOutputImpl(GetPortStatisticsOutputBuilder base) {
            this._receiveDrops = base.getReceiveDrops();
            this._totalReceived = base.getTotalReceived();
            this._totalTransmitted = base.getTotalTransmitted();
            this._transmitDrops = base.getTransmitDrops();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Long getReceiveDrops() {
            return _receiveDrops;
        }
        
        @Override
        public java.lang.Long getTotalReceived() {
            return _totalReceived;
        }
        
        @Override
        public java.lang.Long getTotalTransmitted() {
            return _totalTransmitted;
        }
        
        @Override
        public java.lang.Long getTransmitDrops() {
            return _transmitDrops;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_receiveDrops);
            result = prime * result + Objects.hashCode(_totalReceived);
            result = prime * result + Objects.hashCode(_totalTransmitted);
            result = prime * result + Objects.hashCode(_transmitDrops);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput)obj;
            if (!Objects.equals(_receiveDrops, other.getReceiveDrops())) {
                return false;
            }
            if (!Objects.equals(_totalReceived, other.getTotalReceived())) {
                return false;
            }
            if (!Objects.equals(_totalTransmitted, other.getTotalTransmitted())) {
                return false;
            }
            if (!Objects.equals(_transmitDrops, other.getTransmitDrops())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                GetPortStatisticsOutputImpl otherImpl = (GetPortStatisticsOutputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("GetPortStatisticsOutput [");
            boolean first = true;
        
            if (_receiveDrops != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_receiveDrops=");
                builder.append(_receiveDrops);
             }
            if (_totalReceived != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_totalReceived=");
                builder.append(_totalReceived);
             }
            if (_totalTransmitted != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_totalTransmitted=");
                builder.append(_totalTransmitted);
             }
            if (_transmitDrops != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_transmitDrops=");
                builder.append(_transmitDrops);
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
