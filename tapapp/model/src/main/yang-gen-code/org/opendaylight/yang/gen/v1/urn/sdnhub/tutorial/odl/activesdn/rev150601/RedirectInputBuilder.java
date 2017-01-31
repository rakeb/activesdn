package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput
 *
 */
public class RedirectInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput> {

    private java.lang.String _dstIpAddress;
    private java.lang.Integer _flowPriority;
    private java.lang.Integer _hardTimeout;
    private java.lang.Integer _idleTimeout;
    private java.lang.Integer _inspectionSwitchId;
    private java.lang.String _inspectionSwitchPortId;
    private java.lang.String _srcIpAddress;
    private List<java.lang.Integer> _switchesInPath;
    private TrafficType _typeOfTraffic;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>> augmentation = Collections.emptyMap();

    public RedirectInputBuilder() {
    }

    public RedirectInputBuilder(RedirectInput base) {
        this._dstIpAddress = base.getDstIpAddress();
        this._flowPriority = base.getFlowPriority();
        this._hardTimeout = base.getHardTimeout();
        this._idleTimeout = base.getIdleTimeout();
        this._inspectionSwitchId = base.getInspectionSwitchId();
        this._inspectionSwitchPortId = base.getInspectionSwitchPortId();
        this._srcIpAddress = base.getSrcIpAddress();
        this._switchesInPath = base.getSwitchesInPath();
        this._typeOfTraffic = base.getTypeOfTraffic();
        if (base instanceof RedirectInputImpl) {
            RedirectInputImpl impl = (RedirectInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getDstIpAddress() {
        return _dstIpAddress;
    }
    
    public java.lang.Integer getFlowPriority() {
        return _flowPriority;
    }
    
    public java.lang.Integer getHardTimeout() {
        return _hardTimeout;
    }
    
    public java.lang.Integer getIdleTimeout() {
        return _idleTimeout;
    }
    
    public java.lang.Integer getInspectionSwitchId() {
        return _inspectionSwitchId;
    }
    
    public java.lang.String getInspectionSwitchPortId() {
        return _inspectionSwitchPortId;
    }
    
    public java.lang.String getSrcIpAddress() {
        return _srcIpAddress;
    }
    
    public List<java.lang.Integer> getSwitchesInPath() {
        return _switchesInPath;
    }
    
    public TrafficType getTypeOfTraffic() {
        return _typeOfTraffic;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public RedirectInputBuilder setDstIpAddress(final java.lang.String value) {
        this._dstIpAddress = value;
        return this;
    }
    
     
    public RedirectInputBuilder setFlowPriority(final java.lang.Integer value) {
        this._flowPriority = value;
        return this;
    }
    
     
    public RedirectInputBuilder setHardTimeout(final java.lang.Integer value) {
        this._hardTimeout = value;
        return this;
    }
    
     
    public RedirectInputBuilder setIdleTimeout(final java.lang.Integer value) {
        this._idleTimeout = value;
        return this;
    }
    
     
    public RedirectInputBuilder setInspectionSwitchId(final java.lang.Integer value) {
        this._inspectionSwitchId = value;
        return this;
    }
    
     
    public RedirectInputBuilder setInspectionSwitchPortId(final java.lang.String value) {
        this._inspectionSwitchPortId = value;
        return this;
    }
    
     
    public RedirectInputBuilder setSrcIpAddress(final java.lang.String value) {
        this._srcIpAddress = value;
        return this;
    }
    
     
    public RedirectInputBuilder setSwitchesInPath(final List<java.lang.Integer> value) {
        this._switchesInPath = value;
        return this;
    }
    
     
    public RedirectInputBuilder setTypeOfTraffic(final TrafficType value) {
        this._typeOfTraffic = value;
        return this;
    }
    
    public RedirectInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public RedirectInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public RedirectInput build() {
        return new RedirectInputImpl(this);
    }

    private static final class RedirectInputImpl implements RedirectInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput.class;
        }

        private final java.lang.String _dstIpAddress;
        private final java.lang.Integer _flowPriority;
        private final java.lang.Integer _hardTimeout;
        private final java.lang.Integer _idleTimeout;
        private final java.lang.Integer _inspectionSwitchId;
        private final java.lang.String _inspectionSwitchPortId;
        private final java.lang.String _srcIpAddress;
        private final List<java.lang.Integer> _switchesInPath;
        private final TrafficType _typeOfTraffic;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>> augmentation = Collections.emptyMap();

        private RedirectInputImpl(RedirectInputBuilder base) {
            this._dstIpAddress = base.getDstIpAddress();
            this._flowPriority = base.getFlowPriority();
            this._hardTimeout = base.getHardTimeout();
            this._idleTimeout = base.getIdleTimeout();
            this._inspectionSwitchId = base.getInspectionSwitchId();
            this._inspectionSwitchPortId = base.getInspectionSwitchPortId();
            this._srcIpAddress = base.getSrcIpAddress();
            this._switchesInPath = base.getSwitchesInPath();
            this._typeOfTraffic = base.getTypeOfTraffic();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getDstIpAddress() {
            return _dstIpAddress;
        }
        
        @Override
        public java.lang.Integer getFlowPriority() {
            return _flowPriority;
        }
        
        @Override
        public java.lang.Integer getHardTimeout() {
            return _hardTimeout;
        }
        
        @Override
        public java.lang.Integer getIdleTimeout() {
            return _idleTimeout;
        }
        
        @Override
        public java.lang.Integer getInspectionSwitchId() {
            return _inspectionSwitchId;
        }
        
        @Override
        public java.lang.String getInspectionSwitchPortId() {
            return _inspectionSwitchPortId;
        }
        
        @Override
        public java.lang.String getSrcIpAddress() {
            return _srcIpAddress;
        }
        
        @Override
        public List<java.lang.Integer> getSwitchesInPath() {
            return _switchesInPath;
        }
        
        @Override
        public TrafficType getTypeOfTraffic() {
            return _typeOfTraffic;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_dstIpAddress);
            result = prime * result + Objects.hashCode(_flowPriority);
            result = prime * result + Objects.hashCode(_hardTimeout);
            result = prime * result + Objects.hashCode(_idleTimeout);
            result = prime * result + Objects.hashCode(_inspectionSwitchId);
            result = prime * result + Objects.hashCode(_inspectionSwitchPortId);
            result = prime * result + Objects.hashCode(_srcIpAddress);
            result = prime * result + Objects.hashCode(_switchesInPath);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput)obj;
            if (!Objects.equals(_dstIpAddress, other.getDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_flowPriority, other.getFlowPriority())) {
                return false;
            }
            if (!Objects.equals(_hardTimeout, other.getHardTimeout())) {
                return false;
            }
            if (!Objects.equals(_idleTimeout, other.getIdleTimeout())) {
                return false;
            }
            if (!Objects.equals(_inspectionSwitchId, other.getInspectionSwitchId())) {
                return false;
            }
            if (!Objects.equals(_inspectionSwitchPortId, other.getInspectionSwitchPortId())) {
                return false;
            }
            if (!Objects.equals(_srcIpAddress, other.getSrcIpAddress())) {
                return false;
            }
            if (!Objects.equals(_switchesInPath, other.getSwitchesInPath())) {
                return false;
            }
            if (!Objects.equals(_typeOfTraffic, other.getTypeOfTraffic())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                RedirectInputImpl otherImpl = (RedirectInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RedirectInput>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("RedirectInput [");
            boolean first = true;
        
            if (_dstIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstIpAddress=");
                builder.append(_dstIpAddress);
             }
            if (_flowPriority != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_flowPriority=");
                builder.append(_flowPriority);
             }
            if (_hardTimeout != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hardTimeout=");
                builder.append(_hardTimeout);
             }
            if (_idleTimeout != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_idleTimeout=");
                builder.append(_idleTimeout);
             }
            if (_inspectionSwitchId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_inspectionSwitchId=");
                builder.append(_inspectionSwitchId);
             }
            if (_inspectionSwitchPortId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_inspectionSwitchPortId=");
                builder.append(_inspectionSwitchPortId);
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
            if (_switchesInPath != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_switchesInPath=");
                builder.append(_switchesInPath);
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
