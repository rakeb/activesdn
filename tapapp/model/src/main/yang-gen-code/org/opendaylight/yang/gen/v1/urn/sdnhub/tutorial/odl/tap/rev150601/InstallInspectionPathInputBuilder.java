package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import java.util.Objects;
import java.util.List;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput
 *
 */
public class InstallInspectionPathInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput> {

    private Ipv4Prefix _dstIpAddress;
    private java.lang.Integer _flowPriority;
    private java.lang.Integer _hardTimeout;
    private java.lang.Integer _idleTimeout;
    private NodeConnectorId _inpsectionSwitchPort;
    private NodeId _inspectionSwitchId;
    private List<NodeId> _pathNodes;
    private Ipv4Prefix _srcIpAddress;
    private TrafficType _trafficMatch;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>> augmentation = Collections.emptyMap();

    public InstallInspectionPathInputBuilder() {
    }

    public InstallInspectionPathInputBuilder(InstallInspectionPathInput base) {
        this._dstIpAddress = base.getDstIpAddress();
        this._flowPriority = base.getFlowPriority();
        this._hardTimeout = base.getHardTimeout();
        this._idleTimeout = base.getIdleTimeout();
        this._inpsectionSwitchPort = base.getInpsectionSwitchPort();
        this._inspectionSwitchId = base.getInspectionSwitchId();
        this._pathNodes = base.getPathNodes();
        this._srcIpAddress = base.getSrcIpAddress();
        this._trafficMatch = base.getTrafficMatch();
        if (base instanceof InstallInspectionPathInputImpl) {
            InstallInspectionPathInputImpl impl = (InstallInspectionPathInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>) base;
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
    
    public NodeConnectorId getInpsectionSwitchPort() {
        return _inpsectionSwitchPort;
    }
    
    public NodeId getInspectionSwitchId() {
        return _inspectionSwitchId;
    }
    
    public List<NodeId> getPathNodes() {
        return _pathNodes;
    }
    
    public Ipv4Prefix getSrcIpAddress() {
        return _srcIpAddress;
    }
    
    public TrafficType getTrafficMatch() {
        return _trafficMatch;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public InstallInspectionPathInputBuilder setDstIpAddress(final Ipv4Prefix value) {
        this._dstIpAddress = value;
        return this;
    }
    
     
    public InstallInspectionPathInputBuilder setFlowPriority(final java.lang.Integer value) {
        this._flowPriority = value;
        return this;
    }
    
     
    public InstallInspectionPathInputBuilder setHardTimeout(final java.lang.Integer value) {
        this._hardTimeout = value;
        return this;
    }
    
     
    public InstallInspectionPathInputBuilder setIdleTimeout(final java.lang.Integer value) {
        this._idleTimeout = value;
        return this;
    }
    
     
    public InstallInspectionPathInputBuilder setInpsectionSwitchPort(final NodeConnectorId value) {
        this._inpsectionSwitchPort = value;
        return this;
    }
    
     
    public InstallInspectionPathInputBuilder setInspectionSwitchId(final NodeId value) {
        this._inspectionSwitchId = value;
        return this;
    }
    
     
    public InstallInspectionPathInputBuilder setPathNodes(final List<NodeId> value) {
        this._pathNodes = value;
        return this;
    }
    
     
    public InstallInspectionPathInputBuilder setSrcIpAddress(final Ipv4Prefix value) {
        this._srcIpAddress = value;
        return this;
    }
    
     
    public InstallInspectionPathInputBuilder setTrafficMatch(final TrafficType value) {
        this._trafficMatch = value;
        return this;
    }
    
    public InstallInspectionPathInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public InstallInspectionPathInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public InstallInspectionPathInput build() {
        return new InstallInspectionPathInputImpl(this);
    }

    private static final class InstallInspectionPathInputImpl implements InstallInspectionPathInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput.class;
        }

        private final Ipv4Prefix _dstIpAddress;
        private final java.lang.Integer _flowPriority;
        private final java.lang.Integer _hardTimeout;
        private final java.lang.Integer _idleTimeout;
        private final NodeConnectorId _inpsectionSwitchPort;
        private final NodeId _inspectionSwitchId;
        private final List<NodeId> _pathNodes;
        private final Ipv4Prefix _srcIpAddress;
        private final TrafficType _trafficMatch;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>> augmentation = Collections.emptyMap();

        private InstallInspectionPathInputImpl(InstallInspectionPathInputBuilder base) {
            this._dstIpAddress = base.getDstIpAddress();
            this._flowPriority = base.getFlowPriority();
            this._hardTimeout = base.getHardTimeout();
            this._idleTimeout = base.getIdleTimeout();
            this._inpsectionSwitchPort = base.getInpsectionSwitchPort();
            this._inspectionSwitchId = base.getInspectionSwitchId();
            this._pathNodes = base.getPathNodes();
            this._srcIpAddress = base.getSrcIpAddress();
            this._trafficMatch = base.getTrafficMatch();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>>singletonMap(e.getKey(), e.getValue());
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
        public NodeConnectorId getInpsectionSwitchPort() {
            return _inpsectionSwitchPort;
        }
        
        @Override
        public NodeId getInspectionSwitchId() {
            return _inspectionSwitchId;
        }
        
        @Override
        public List<NodeId> getPathNodes() {
            return _pathNodes;
        }
        
        @Override
        public Ipv4Prefix getSrcIpAddress() {
            return _srcIpAddress;
        }
        
        @Override
        public TrafficType getTrafficMatch() {
            return _trafficMatch;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_inpsectionSwitchPort);
            result = prime * result + Objects.hashCode(_inspectionSwitchId);
            result = prime * result + Objects.hashCode(_pathNodes);
            result = prime * result + Objects.hashCode(_srcIpAddress);
            result = prime * result + Objects.hashCode(_trafficMatch);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput)obj;
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
            if (!Objects.equals(_inpsectionSwitchPort, other.getInpsectionSwitchPort())) {
                return false;
            }
            if (!Objects.equals(_inspectionSwitchId, other.getInspectionSwitchId())) {
                return false;
            }
            if (!Objects.equals(_pathNodes, other.getPathNodes())) {
                return false;
            }
            if (!Objects.equals(_srcIpAddress, other.getSrcIpAddress())) {
                return false;
            }
            if (!Objects.equals(_trafficMatch, other.getTrafficMatch())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                InstallInspectionPathInputImpl otherImpl = (InstallInspectionPathInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("InstallInspectionPathInput [");
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
            if (_inpsectionSwitchPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_inpsectionSwitchPort=");
                builder.append(_inpsectionSwitchPort);
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
            if (_trafficMatch != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_trafficMatch=");
                builder.append(_trafficMatch);
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
