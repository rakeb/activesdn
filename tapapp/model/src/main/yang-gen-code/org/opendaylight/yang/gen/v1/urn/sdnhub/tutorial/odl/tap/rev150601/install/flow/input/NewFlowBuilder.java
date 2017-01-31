package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev100924.MacAddress;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.Objects;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow
 *
 */
public class NewFlowBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow> {

    private CustomInfo _customInfo;
    private Ipv4Prefix _dstIpAddress;
    private MacAddress _dstMacAddress;
    private java.lang.Integer _flowPriority;
    private java.lang.Integer _hardTimeout;
    private java.lang.Integer _idleTimeout;
    private NodeConnectorId _inPort;
    private Ipv4Prefix _srcIpAddress;
    private MacAddress _srcMacAddress;
    private TrafficType _trafficMatch;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>> augmentation = Collections.emptyMap();

    public NewFlowBuilder() {
    }
    public NewFlowBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match arg) {
        this._inPort = arg.getInPort();
        this._srcMacAddress = arg.getSrcMacAddress();
        this._dstMacAddress = arg.getDstMacAddress();
        this._srcIpAddress = arg.getSrcIpAddress();
        this._dstIpAddress = arg.getDstIpAddress();
        this._trafficMatch = arg.getTrafficMatch();
        this._flowPriority = arg.getFlowPriority();
        this._idleTimeout = arg.getIdleTimeout();
        this._hardTimeout = arg.getHardTimeout();
        this._customInfo = arg.getCustomInfo();
    }

    public NewFlowBuilder(NewFlow base) {
        this._customInfo = base.getCustomInfo();
        this._dstIpAddress = base.getDstIpAddress();
        this._dstMacAddress = base.getDstMacAddress();
        this._flowPriority = base.getFlowPriority();
        this._hardTimeout = base.getHardTimeout();
        this._idleTimeout = base.getIdleTimeout();
        this._inPort = base.getInPort();
        this._srcIpAddress = base.getSrcIpAddress();
        this._srcMacAddress = base.getSrcMacAddress();
        this._trafficMatch = base.getTrafficMatch();
        if (base instanceof NewFlowImpl) {
            NewFlowImpl impl = (NewFlowImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match) {
            this._inPort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getInPort();
            this._srcMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getSrcMacAddress();
            this._dstMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getDstMacAddress();
            this._srcIpAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getSrcIpAddress();
            this._dstIpAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getDstIpAddress();
            this._trafficMatch = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getTrafficMatch();
            this._flowPriority = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getFlowPriority();
            this._idleTimeout = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getIdleTimeout();
            this._hardTimeout = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getHardTimeout();
            this._customInfo = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match)arg).getCustomInfo();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Match] \n" +
              "but was: " + arg
            );
        }
    }

    public CustomInfo getCustomInfo() {
        return _customInfo;
    }
    
    public Ipv4Prefix getDstIpAddress() {
        return _dstIpAddress;
    }
    
    public MacAddress getDstMacAddress() {
        return _dstMacAddress;
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
    
    public NodeConnectorId getInPort() {
        return _inPort;
    }
    
    public Ipv4Prefix getSrcIpAddress() {
        return _srcIpAddress;
    }
    
    public MacAddress getSrcMacAddress() {
        return _srcMacAddress;
    }
    
    public TrafficType getTrafficMatch() {
        return _trafficMatch;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public NewFlowBuilder setCustomInfo(final CustomInfo value) {
        this._customInfo = value;
        return this;
    }
    
     
    public NewFlowBuilder setDstIpAddress(final Ipv4Prefix value) {
        this._dstIpAddress = value;
        return this;
    }
    
     
    public NewFlowBuilder setDstMacAddress(final MacAddress value) {
        this._dstMacAddress = value;
        return this;
    }
    
     
    public NewFlowBuilder setFlowPriority(final java.lang.Integer value) {
        this._flowPriority = value;
        return this;
    }
    
     
    public NewFlowBuilder setHardTimeout(final java.lang.Integer value) {
        this._hardTimeout = value;
        return this;
    }
    
     
    public NewFlowBuilder setIdleTimeout(final java.lang.Integer value) {
        this._idleTimeout = value;
        return this;
    }
    
     
    public NewFlowBuilder setInPort(final NodeConnectorId value) {
        this._inPort = value;
        return this;
    }
    
     
    public NewFlowBuilder setSrcIpAddress(final Ipv4Prefix value) {
        this._srcIpAddress = value;
        return this;
    }
    
     
    public NewFlowBuilder setSrcMacAddress(final MacAddress value) {
        this._srcMacAddress = value;
        return this;
    }
    
     
    public NewFlowBuilder setTrafficMatch(final TrafficType value) {
        this._trafficMatch = value;
        return this;
    }
    
    public NewFlowBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public NewFlowBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public NewFlow build() {
        return new NewFlowImpl(this);
    }

    private static final class NewFlowImpl implements NewFlow {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow.class;
        }

        private final CustomInfo _customInfo;
        private final Ipv4Prefix _dstIpAddress;
        private final MacAddress _dstMacAddress;
        private final java.lang.Integer _flowPriority;
        private final java.lang.Integer _hardTimeout;
        private final java.lang.Integer _idleTimeout;
        private final NodeConnectorId _inPort;
        private final Ipv4Prefix _srcIpAddress;
        private final MacAddress _srcMacAddress;
        private final TrafficType _trafficMatch;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>> augmentation = Collections.emptyMap();

        private NewFlowImpl(NewFlowBuilder base) {
            this._customInfo = base.getCustomInfo();
            this._dstIpAddress = base.getDstIpAddress();
            this._dstMacAddress = base.getDstMacAddress();
            this._flowPriority = base.getFlowPriority();
            this._hardTimeout = base.getHardTimeout();
            this._idleTimeout = base.getIdleTimeout();
            this._inPort = base.getInPort();
            this._srcIpAddress = base.getSrcIpAddress();
            this._srcMacAddress = base.getSrcMacAddress();
            this._trafficMatch = base.getTrafficMatch();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public CustomInfo getCustomInfo() {
            return _customInfo;
        }
        
        @Override
        public Ipv4Prefix getDstIpAddress() {
            return _dstIpAddress;
        }
        
        @Override
        public MacAddress getDstMacAddress() {
            return _dstMacAddress;
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
        public NodeConnectorId getInPort() {
            return _inPort;
        }
        
        @Override
        public Ipv4Prefix getSrcIpAddress() {
            return _srcIpAddress;
        }
        
        @Override
        public MacAddress getSrcMacAddress() {
            return _srcMacAddress;
        }
        
        @Override
        public TrafficType getTrafficMatch() {
            return _trafficMatch;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_customInfo);
            result = prime * result + Objects.hashCode(_dstIpAddress);
            result = prime * result + Objects.hashCode(_dstMacAddress);
            result = prime * result + Objects.hashCode(_flowPriority);
            result = prime * result + Objects.hashCode(_hardTimeout);
            result = prime * result + Objects.hashCode(_idleTimeout);
            result = prime * result + Objects.hashCode(_inPort);
            result = prime * result + Objects.hashCode(_srcIpAddress);
            result = prime * result + Objects.hashCode(_srcMacAddress);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow)obj;
            if (!Objects.equals(_customInfo, other.getCustomInfo())) {
                return false;
            }
            if (!Objects.equals(_dstIpAddress, other.getDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_dstMacAddress, other.getDstMacAddress())) {
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
            if (!Objects.equals(_inPort, other.getInPort())) {
                return false;
            }
            if (!Objects.equals(_srcIpAddress, other.getSrcIpAddress())) {
                return false;
            }
            if (!Objects.equals(_srcMacAddress, other.getSrcMacAddress())) {
                return false;
            }
            if (!Objects.equals(_trafficMatch, other.getTrafficMatch())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                NewFlowImpl otherImpl = (NewFlowImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("NewFlow [");
            boolean first = true;
        
            if (_customInfo != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_customInfo=");
                builder.append(_customInfo);
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
            if (_dstMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstMacAddress=");
                builder.append(_dstMacAddress);
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
            if (_inPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_inPort=");
                builder.append(_inPort);
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
            if (_srcMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_srcMacAddress=");
                builder.append(_srcMacAddress);
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
