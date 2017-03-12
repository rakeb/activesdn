package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import java.util.Objects;
import java.util.List;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput
 *
 */
public class IpMutateEngineInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput> {

    private java.lang.Integer _flowPriority;
    private java.lang.Integer _hardTimeout;
    private java.lang.Integer _idleTimeout;
    private Ipv4Prefix _newDstIpAddress;
    private Ipv4Prefix _newSrcIpAddress;
    private Ipv4Prefix _oldDstIpAddress;
    private Ipv4Prefix _oldSrcIpAddress;
    private List<NodeId> _pathNodes;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>> augmentation = Collections.emptyMap();

    public IpMutateEngineInputBuilder() {
    }

    public IpMutateEngineInputBuilder(IpMutateEngineInput base) {
        this._flowPriority = base.getFlowPriority();
        this._hardTimeout = base.getHardTimeout();
        this._idleTimeout = base.getIdleTimeout();
        this._newDstIpAddress = base.getNewDstIpAddress();
        this._newSrcIpAddress = base.getNewSrcIpAddress();
        this._oldDstIpAddress = base.getOldDstIpAddress();
        this._oldSrcIpAddress = base.getOldSrcIpAddress();
        this._pathNodes = base.getPathNodes();
        if (base instanceof IpMutateEngineInputImpl) {
            IpMutateEngineInputImpl impl = (IpMutateEngineInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
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
    
    public Ipv4Prefix getNewDstIpAddress() {
        return _newDstIpAddress;
    }
    
    public Ipv4Prefix getNewSrcIpAddress() {
        return _newSrcIpAddress;
    }
    
    public Ipv4Prefix getOldDstIpAddress() {
        return _oldDstIpAddress;
    }
    
    public Ipv4Prefix getOldSrcIpAddress() {
        return _oldSrcIpAddress;
    }
    
    public List<NodeId> getPathNodes() {
        return _pathNodes;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public IpMutateEngineInputBuilder setFlowPriority(final java.lang.Integer value) {
        this._flowPriority = value;
        return this;
    }
    
     
    public IpMutateEngineInputBuilder setHardTimeout(final java.lang.Integer value) {
        this._hardTimeout = value;
        return this;
    }
    
     
    public IpMutateEngineInputBuilder setIdleTimeout(final java.lang.Integer value) {
        this._idleTimeout = value;
        return this;
    }
    
     
    public IpMutateEngineInputBuilder setNewDstIpAddress(final Ipv4Prefix value) {
        this._newDstIpAddress = value;
        return this;
    }
    
     
    public IpMutateEngineInputBuilder setNewSrcIpAddress(final Ipv4Prefix value) {
        this._newSrcIpAddress = value;
        return this;
    }
    
     
    public IpMutateEngineInputBuilder setOldDstIpAddress(final Ipv4Prefix value) {
        this._oldDstIpAddress = value;
        return this;
    }
    
     
    public IpMutateEngineInputBuilder setOldSrcIpAddress(final Ipv4Prefix value) {
        this._oldSrcIpAddress = value;
        return this;
    }
    
     
    public IpMutateEngineInputBuilder setPathNodes(final List<NodeId> value) {
        this._pathNodes = value;
        return this;
    }
    
    public IpMutateEngineInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public IpMutateEngineInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public IpMutateEngineInput build() {
        return new IpMutateEngineInputImpl(this);
    }

    private static final class IpMutateEngineInputImpl implements IpMutateEngineInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput.class;
        }

        private final java.lang.Integer _flowPriority;
        private final java.lang.Integer _hardTimeout;
        private final java.lang.Integer _idleTimeout;
        private final Ipv4Prefix _newDstIpAddress;
        private final Ipv4Prefix _newSrcIpAddress;
        private final Ipv4Prefix _oldDstIpAddress;
        private final Ipv4Prefix _oldSrcIpAddress;
        private final List<NodeId> _pathNodes;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>> augmentation = Collections.emptyMap();

        private IpMutateEngineInputImpl(IpMutateEngineInputBuilder base) {
            this._flowPriority = base.getFlowPriority();
            this._hardTimeout = base.getHardTimeout();
            this._idleTimeout = base.getIdleTimeout();
            this._newDstIpAddress = base.getNewDstIpAddress();
            this._newSrcIpAddress = base.getNewSrcIpAddress();
            this._oldDstIpAddress = base.getOldDstIpAddress();
            this._oldSrcIpAddress = base.getOldSrcIpAddress();
            this._pathNodes = base.getPathNodes();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
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
        public Ipv4Prefix getNewDstIpAddress() {
            return _newDstIpAddress;
        }
        
        @Override
        public Ipv4Prefix getNewSrcIpAddress() {
            return _newSrcIpAddress;
        }
        
        @Override
        public Ipv4Prefix getOldDstIpAddress() {
            return _oldDstIpAddress;
        }
        
        @Override
        public Ipv4Prefix getOldSrcIpAddress() {
            return _oldSrcIpAddress;
        }
        
        @Override
        public List<NodeId> getPathNodes() {
            return _pathNodes;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_flowPriority);
            result = prime * result + Objects.hashCode(_hardTimeout);
            result = prime * result + Objects.hashCode(_idleTimeout);
            result = prime * result + Objects.hashCode(_newDstIpAddress);
            result = prime * result + Objects.hashCode(_newSrcIpAddress);
            result = prime * result + Objects.hashCode(_oldDstIpAddress);
            result = prime * result + Objects.hashCode(_oldSrcIpAddress);
            result = prime * result + Objects.hashCode(_pathNodes);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput)obj;
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
            if (!Objects.equals(_oldDstIpAddress, other.getOldDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_oldSrcIpAddress, other.getOldSrcIpAddress())) {
                return false;
            }
            if (!Objects.equals(_pathNodes, other.getPathNodes())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                IpMutateEngineInputImpl otherImpl = (IpMutateEngineInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("IpMutateEngineInput [");
            boolean first = true;
        
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
            if (_oldDstIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_oldDstIpAddress=");
                builder.append(_oldDstIpAddress);
             }
            if (_oldSrcIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_oldSrcIpAddress=");
                builder.append(_oldSrcIpAddress);
             }
            if (_pathNodes != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_pathNodes=");
                builder.append(_pathNodes);
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
