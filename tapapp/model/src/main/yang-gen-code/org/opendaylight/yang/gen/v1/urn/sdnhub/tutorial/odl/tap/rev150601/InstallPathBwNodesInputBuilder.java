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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput
 *
 */
public class InstallPathBwNodesInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput> {

    private Ipv4Prefix _dstIpAddress;
    private java.lang.Integer _flowPriority;
    private java.lang.Integer _hardTimeout;
    private java.lang.Integer _idleTimeout;
    private List<NodeId> _pathNodes;
    private Ipv4Prefix _srcIpAddress;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>> augmentation = Collections.emptyMap();

    public InstallPathBwNodesInputBuilder() {
    }

    public InstallPathBwNodesInputBuilder(InstallPathBwNodesInput base) {
        this._dstIpAddress = base.getDstIpAddress();
        this._flowPriority = base.getFlowPriority();
        this._hardTimeout = base.getHardTimeout();
        this._idleTimeout = base.getIdleTimeout();
        this._pathNodes = base.getPathNodes();
        this._srcIpAddress = base.getSrcIpAddress();
        if (base instanceof InstallPathBwNodesInputImpl) {
            InstallPathBwNodesInputImpl impl = (InstallPathBwNodesInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public Ipv4Prefix getDstIpAddress() {
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
    
    public List<NodeId> getPathNodes() {
        return _pathNodes;
    }
    
    public Ipv4Prefix getSrcIpAddress() {
        return _srcIpAddress;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public InstallPathBwNodesInputBuilder setDstIpAddress(final Ipv4Prefix value) {
        this._dstIpAddress = value;
        return this;
    }
    
     
    public InstallPathBwNodesInputBuilder setFlowPriority(final java.lang.Integer value) {
        this._flowPriority = value;
        return this;
    }
    
     
    public InstallPathBwNodesInputBuilder setHardTimeout(final java.lang.Integer value) {
        this._hardTimeout = value;
        return this;
    }
    
     
    public InstallPathBwNodesInputBuilder setIdleTimeout(final java.lang.Integer value) {
        this._idleTimeout = value;
        return this;
    }
    
     
    public InstallPathBwNodesInputBuilder setPathNodes(final List<NodeId> value) {
        this._pathNodes = value;
        return this;
    }
    
     
    public InstallPathBwNodesInputBuilder setSrcIpAddress(final Ipv4Prefix value) {
        this._srcIpAddress = value;
        return this;
    }
    
    public InstallPathBwNodesInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public InstallPathBwNodesInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public InstallPathBwNodesInput build() {
        return new InstallPathBwNodesInputImpl(this);
    }

    private static final class InstallPathBwNodesInputImpl implements InstallPathBwNodesInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput.class;
        }

        private final Ipv4Prefix _dstIpAddress;
        private final java.lang.Integer _flowPriority;
        private final java.lang.Integer _hardTimeout;
        private final java.lang.Integer _idleTimeout;
        private final List<NodeId> _pathNodes;
        private final Ipv4Prefix _srcIpAddress;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>> augmentation = Collections.emptyMap();

        private InstallPathBwNodesInputImpl(InstallPathBwNodesInputBuilder base) {
            this._dstIpAddress = base.getDstIpAddress();
            this._flowPriority = base.getFlowPriority();
            this._hardTimeout = base.getHardTimeout();
            this._idleTimeout = base.getIdleTimeout();
            this._pathNodes = base.getPathNodes();
            this._srcIpAddress = base.getSrcIpAddress();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public Ipv4Prefix getDstIpAddress() {
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
        public List<NodeId> getPathNodes() {
            return _pathNodes;
        }
        
        @Override
        public Ipv4Prefix getSrcIpAddress() {
            return _srcIpAddress;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_pathNodes);
            result = prime * result + Objects.hashCode(_srcIpAddress);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput)obj;
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
            if (!Objects.equals(_pathNodes, other.getPathNodes())) {
                return false;
            }
            if (!Objects.equals(_srcIpAddress, other.getSrcIpAddress())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                InstallPathBwNodesInputImpl otherImpl = (InstallPathBwNodesInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("InstallPathBwNodesInput [");
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
            if (_pathNodes != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_pathNodes=");
                builder.append(_pathNodes);
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
