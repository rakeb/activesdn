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


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput
 *
 */
public class CreateSrcDstTunnelInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput> {

    private java.lang.String _currentDstIpAddress;
    private java.lang.String _currentSrcIpAddress;
    private java.lang.Integer _flowPriority;
    private java.lang.Integer _hardTimeout;
    private java.lang.Integer _idleTimeout;
    private java.lang.String _newDstIpAddress;
    private java.lang.String _newSrcIpAddress;
    private List<java.lang.Integer> _switchesInPath;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>> augmentation = Collections.emptyMap();

    public CreateSrcDstTunnelInputBuilder() {
    }

    public CreateSrcDstTunnelInputBuilder(CreateSrcDstTunnelInput base) {
        this._currentDstIpAddress = base.getCurrentDstIpAddress();
        this._currentSrcIpAddress = base.getCurrentSrcIpAddress();
        this._flowPriority = base.getFlowPriority();
        this._hardTimeout = base.getHardTimeout();
        this._idleTimeout = base.getIdleTimeout();
        this._newDstIpAddress = base.getNewDstIpAddress();
        this._newSrcIpAddress = base.getNewSrcIpAddress();
        this._switchesInPath = base.getSwitchesInPath();
        if (base instanceof CreateSrcDstTunnelInputImpl) {
            CreateSrcDstTunnelInputImpl impl = (CreateSrcDstTunnelInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getCurrentDstIpAddress() {
        return _currentDstIpAddress;
    }
    
    public java.lang.String getCurrentSrcIpAddress() {
        return _currentSrcIpAddress;
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
    
    public java.lang.String getNewDstIpAddress() {
        return _newDstIpAddress;
    }
    
    public java.lang.String getNewSrcIpAddress() {
        return _newSrcIpAddress;
    }
    
    public List<java.lang.Integer> getSwitchesInPath() {
        return _switchesInPath;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public CreateSrcDstTunnelInputBuilder setCurrentDstIpAddress(final java.lang.String value) {
        this._currentDstIpAddress = value;
        return this;
    }
    
     
    public CreateSrcDstTunnelInputBuilder setCurrentSrcIpAddress(final java.lang.String value) {
        this._currentSrcIpAddress = value;
        return this;
    }
    
     
    public CreateSrcDstTunnelInputBuilder setFlowPriority(final java.lang.Integer value) {
        this._flowPriority = value;
        return this;
    }
    
     
    public CreateSrcDstTunnelInputBuilder setHardTimeout(final java.lang.Integer value) {
        this._hardTimeout = value;
        return this;
    }
    
     
    public CreateSrcDstTunnelInputBuilder setIdleTimeout(final java.lang.Integer value) {
        this._idleTimeout = value;
        return this;
    }
    
     
    public CreateSrcDstTunnelInputBuilder setNewDstIpAddress(final java.lang.String value) {
        this._newDstIpAddress = value;
        return this;
    }
    
     
    public CreateSrcDstTunnelInputBuilder setNewSrcIpAddress(final java.lang.String value) {
        this._newSrcIpAddress = value;
        return this;
    }
    
     
    public CreateSrcDstTunnelInputBuilder setSwitchesInPath(final List<java.lang.Integer> value) {
        this._switchesInPath = value;
        return this;
    }
    
    public CreateSrcDstTunnelInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public CreateSrcDstTunnelInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public CreateSrcDstTunnelInput build() {
        return new CreateSrcDstTunnelInputImpl(this);
    }

    private static final class CreateSrcDstTunnelInputImpl implements CreateSrcDstTunnelInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput.class;
        }

        private final java.lang.String _currentDstIpAddress;
        private final java.lang.String _currentSrcIpAddress;
        private final java.lang.Integer _flowPriority;
        private final java.lang.Integer _hardTimeout;
        private final java.lang.Integer _idleTimeout;
        private final java.lang.String _newDstIpAddress;
        private final java.lang.String _newSrcIpAddress;
        private final List<java.lang.Integer> _switchesInPath;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>> augmentation = Collections.emptyMap();

        private CreateSrcDstTunnelInputImpl(CreateSrcDstTunnelInputBuilder base) {
            this._currentDstIpAddress = base.getCurrentDstIpAddress();
            this._currentSrcIpAddress = base.getCurrentSrcIpAddress();
            this._flowPriority = base.getFlowPriority();
            this._hardTimeout = base.getHardTimeout();
            this._idleTimeout = base.getIdleTimeout();
            this._newDstIpAddress = base.getNewDstIpAddress();
            this._newSrcIpAddress = base.getNewSrcIpAddress();
            this._switchesInPath = base.getSwitchesInPath();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getCurrentDstIpAddress() {
            return _currentDstIpAddress;
        }
        
        @Override
        public java.lang.String getCurrentSrcIpAddress() {
            return _currentSrcIpAddress;
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
        public java.lang.String getNewDstIpAddress() {
            return _newDstIpAddress;
        }
        
        @Override
        public java.lang.String getNewSrcIpAddress() {
            return _newSrcIpAddress;
        }
        
        @Override
        public List<java.lang.Integer> getSwitchesInPath() {
            return _switchesInPath;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_currentDstIpAddress);
            result = prime * result + Objects.hashCode(_currentSrcIpAddress);
            result = prime * result + Objects.hashCode(_flowPriority);
            result = prime * result + Objects.hashCode(_hardTimeout);
            result = prime * result + Objects.hashCode(_idleTimeout);
            result = prime * result + Objects.hashCode(_newDstIpAddress);
            result = prime * result + Objects.hashCode(_newSrcIpAddress);
            result = prime * result + Objects.hashCode(_switchesInPath);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput)obj;
            if (!Objects.equals(_currentDstIpAddress, other.getCurrentDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_currentSrcIpAddress, other.getCurrentSrcIpAddress())) {
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
            if (!Objects.equals(_newDstIpAddress, other.getNewDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_newSrcIpAddress, other.getNewSrcIpAddress())) {
                return false;
            }
            if (!Objects.equals(_switchesInPath, other.getSwitchesInPath())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                CreateSrcDstTunnelInputImpl otherImpl = (CreateSrcDstTunnelInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.CreateSrcDstTunnelInput>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("CreateSrcDstTunnelInput [");
            boolean first = true;
        
            if (_currentDstIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_currentDstIpAddress=");
                builder.append(_currentDstIpAddress);
             }
            if (_currentSrcIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_currentSrcIpAddress=");
                builder.append(_currentSrcIpAddress);
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
            if (_newDstIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_newDstIpAddress=");
                builder.append(_newDstIpAddress);
             }
            if (_newSrcIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_newSrcIpAddress=");
                builder.append(_newSrcIpAddress);
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
