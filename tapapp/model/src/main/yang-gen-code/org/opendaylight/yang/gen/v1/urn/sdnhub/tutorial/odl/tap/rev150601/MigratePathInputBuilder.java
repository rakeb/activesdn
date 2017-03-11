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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput
 *
 */
public class MigratePathInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput> {

    private java.lang.Integer _flowPriority;
    private java.lang.Integer _hardTimeout;
    private java.lang.Integer _idleTimeout;
    private Ipv4Prefix _newDstIpAddress;
    private List<NodeId> _newPathNodes;
    private Ipv4Prefix _newSrcIpAddress;
    private Ipv4Prefix _oldDstIpAddress;
    private List<NodeId> _oldPathNodes;
    private Ipv4Prefix _oldSrcIpAddress;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>> augmentation = Collections.emptyMap();

    public MigratePathInputBuilder() {
    }

    public MigratePathInputBuilder(MigratePathInput base) {
        this._flowPriority = base.getFlowPriority();
        this._hardTimeout = base.getHardTimeout();
        this._idleTimeout = base.getIdleTimeout();
        this._newDstIpAddress = base.getNewDstIpAddress();
        this._newPathNodes = base.getNewPathNodes();
        this._newSrcIpAddress = base.getNewSrcIpAddress();
        this._oldDstIpAddress = base.getOldDstIpAddress();
        this._oldPathNodes = base.getOldPathNodes();
        this._oldSrcIpAddress = base.getOldSrcIpAddress();
        if (base instanceof MigratePathInputImpl) {
            MigratePathInputImpl impl = (MigratePathInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>) base;
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
    
    public List<NodeId> getNewPathNodes() {
        return _newPathNodes;
    }
    
    public Ipv4Prefix getNewSrcIpAddress() {
        return _newSrcIpAddress;
    }
    
    public Ipv4Prefix getOldDstIpAddress() {
        return _oldDstIpAddress;
    }
    
    public List<NodeId> getOldPathNodes() {
        return _oldPathNodes;
    }
    
    public Ipv4Prefix getOldSrcIpAddress() {
        return _oldSrcIpAddress;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public MigratePathInputBuilder setFlowPriority(final java.lang.Integer value) {
        this._flowPriority = value;
        return this;
    }
    
     
    public MigratePathInputBuilder setHardTimeout(final java.lang.Integer value) {
        this._hardTimeout = value;
        return this;
    }
    
     
    public MigratePathInputBuilder setIdleTimeout(final java.lang.Integer value) {
        this._idleTimeout = value;
        return this;
    }
    
     
    public MigratePathInputBuilder setNewDstIpAddress(final Ipv4Prefix value) {
        this._newDstIpAddress = value;
        return this;
    }
    
     
    public MigratePathInputBuilder setNewPathNodes(final List<NodeId> value) {
        this._newPathNodes = value;
        return this;
    }
    
     
    public MigratePathInputBuilder setNewSrcIpAddress(final Ipv4Prefix value) {
        this._newSrcIpAddress = value;
        return this;
    }
    
     
    public MigratePathInputBuilder setOldDstIpAddress(final Ipv4Prefix value) {
        this._oldDstIpAddress = value;
        return this;
    }
    
     
    public MigratePathInputBuilder setOldPathNodes(final List<NodeId> value) {
        this._oldPathNodes = value;
        return this;
    }
    
     
    public MigratePathInputBuilder setOldSrcIpAddress(final Ipv4Prefix value) {
        this._oldSrcIpAddress = value;
        return this;
    }
    
    public MigratePathInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public MigratePathInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public MigratePathInput build() {
        return new MigratePathInputImpl(this);
    }

    private static final class MigratePathInputImpl implements MigratePathInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput.class;
        }

        private final java.lang.Integer _flowPriority;
        private final java.lang.Integer _hardTimeout;
        private final java.lang.Integer _idleTimeout;
        private final Ipv4Prefix _newDstIpAddress;
        private final List<NodeId> _newPathNodes;
        private final Ipv4Prefix _newSrcIpAddress;
        private final Ipv4Prefix _oldDstIpAddress;
        private final List<NodeId> _oldPathNodes;
        private final Ipv4Prefix _oldSrcIpAddress;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>> augmentation = Collections.emptyMap();

        private MigratePathInputImpl(MigratePathInputBuilder base) {
            this._flowPriority = base.getFlowPriority();
            this._hardTimeout = base.getHardTimeout();
            this._idleTimeout = base.getIdleTimeout();
            this._newDstIpAddress = base.getNewDstIpAddress();
            this._newPathNodes = base.getNewPathNodes();
            this._newSrcIpAddress = base.getNewSrcIpAddress();
            this._oldDstIpAddress = base.getOldDstIpAddress();
            this._oldPathNodes = base.getOldPathNodes();
            this._oldSrcIpAddress = base.getOldSrcIpAddress();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>>singletonMap(e.getKey(), e.getValue());
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
        public List<NodeId> getNewPathNodes() {
            return _newPathNodes;
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
        public List<NodeId> getOldPathNodes() {
            return _oldPathNodes;
        }
        
        @Override
        public Ipv4Prefix getOldSrcIpAddress() {
            return _oldSrcIpAddress;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_newPathNodes);
            result = prime * result + Objects.hashCode(_newSrcIpAddress);
            result = prime * result + Objects.hashCode(_oldDstIpAddress);
            result = prime * result + Objects.hashCode(_oldPathNodes);
            result = prime * result + Objects.hashCode(_oldSrcIpAddress);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput)obj;
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
            if (!Objects.equals(_newPathNodes, other.getNewPathNodes())) {
                return false;
            }
            if (!Objects.equals(_newSrcIpAddress, other.getNewSrcIpAddress())) {
                return false;
            }
            if (!Objects.equals(_oldDstIpAddress, other.getOldDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_oldPathNodes, other.getOldPathNodes())) {
                return false;
            }
            if (!Objects.equals(_oldSrcIpAddress, other.getOldSrcIpAddress())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                MigratePathInputImpl otherImpl = (MigratePathInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("MigratePathInput [");
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
            if (_newPathNodes != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_newPathNodes=");
                builder.append(_newPathNodes);
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
            if (_oldPathNodes != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_oldPathNodes=");
                builder.append(_oldPathNodes);
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
