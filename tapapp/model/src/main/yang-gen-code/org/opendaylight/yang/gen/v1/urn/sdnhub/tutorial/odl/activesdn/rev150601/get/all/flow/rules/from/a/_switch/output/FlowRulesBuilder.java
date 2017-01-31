package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output;
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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules
 *
 */
public class FlowRulesBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules> {

    private java.lang.String _actionOutputPort;
    private java.lang.String _actionSetDstIpv4Address;
    private java.lang.Integer _actionSetIpv4Tos;
    private java.lang.Short _actionSetIpv4Ttl;
    private java.lang.Integer _actionSetPortQueue;
    private java.lang.String _actionSetSourceIpv4Address;
    private java.lang.Integer _actionSetTcpDstPort;
    private java.lang.Integer _actionSetTcpSrcPort;
    private java.lang.String _dstIpAddress;
    private java.lang.String _dstMacAddress;
    private java.lang.Integer _dstPort;
    private java.lang.String _flowId;
    private java.lang.Integer _flowPriority;
    private java.lang.Integer _hardTimeout;
    private java.lang.Integer _idleTimeout;
    private java.lang.Long _inPortId;
    private FlowRulesKey _key;
    private java.lang.String _srcIpAddress;
    private java.lang.String _srcMacAddress;
    private java.lang.Integer _srcPort;
    private java.lang.Integer _switchId;
    private TrafficType _typeOfTraffic;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>> augmentation = Collections.emptyMap();

    public FlowRulesBuilder() {
    }
    public FlowRulesBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs arg) {
        this._switchId = arg.getSwitchId();
        this._inPortId = arg.getInPortId();
        this._srcMacAddress = arg.getSrcMacAddress();
        this._dstMacAddress = arg.getDstMacAddress();
        this._srcIpAddress = arg.getSrcIpAddress();
        this._dstIpAddress = arg.getDstIpAddress();
        this._typeOfTraffic = arg.getTypeOfTraffic();
        this._srcPort = arg.getSrcPort();
        this._dstPort = arg.getDstPort();
        this._flowPriority = arg.getFlowPriority();
        this._idleTimeout = arg.getIdleTimeout();
        this._hardTimeout = arg.getHardTimeout();
        this._actionOutputPort = arg.getActionOutputPort();
        this._actionSetSourceIpv4Address = arg.getActionSetSourceIpv4Address();
        this._actionSetDstIpv4Address = arg.getActionSetDstIpv4Address();
        this._actionSetIpv4Tos = arg.getActionSetIpv4Tos();
        this._actionSetTcpSrcPort = arg.getActionSetTcpSrcPort();
        this._actionSetTcpDstPort = arg.getActionSetTcpDstPort();
        this._actionSetIpv4Ttl = arg.getActionSetIpv4Ttl();
        this._actionSetPortQueue = arg.getActionSetPortQueue();
    }

    public FlowRulesBuilder(FlowRules base) {
        if (base.getKey() == null) {
            this._key = new FlowRulesKey(
                base.getFlowId()
            );
            this._flowId = base.getFlowId();
        } else {
            this._key = base.getKey();
            this._flowId = _key.getFlowId();
        }
        this._actionOutputPort = base.getActionOutputPort();
        this._actionSetDstIpv4Address = base.getActionSetDstIpv4Address();
        this._actionSetIpv4Tos = base.getActionSetIpv4Tos();
        this._actionSetIpv4Ttl = base.getActionSetIpv4Ttl();
        this._actionSetPortQueue = base.getActionSetPortQueue();
        this._actionSetSourceIpv4Address = base.getActionSetSourceIpv4Address();
        this._actionSetTcpDstPort = base.getActionSetTcpDstPort();
        this._actionSetTcpSrcPort = base.getActionSetTcpSrcPort();
        this._dstIpAddress = base.getDstIpAddress();
        this._dstMacAddress = base.getDstMacAddress();
        this._dstPort = base.getDstPort();
        this._flowPriority = base.getFlowPriority();
        this._hardTimeout = base.getHardTimeout();
        this._idleTimeout = base.getIdleTimeout();
        this._inPortId = base.getInPortId();
        this._srcIpAddress = base.getSrcIpAddress();
        this._srcMacAddress = base.getSrcMacAddress();
        this._srcPort = base.getSrcPort();
        this._switchId = base.getSwitchId();
        this._typeOfTraffic = base.getTypeOfTraffic();
        if (base instanceof FlowRulesImpl) {
            FlowRulesImpl impl = (FlowRulesImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs) {
            this._switchId = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getSwitchId();
            this._inPortId = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getInPortId();
            this._srcMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getSrcMacAddress();
            this._dstMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getDstMacAddress();
            this._srcIpAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getSrcIpAddress();
            this._dstIpAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getDstIpAddress();
            this._typeOfTraffic = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getTypeOfTraffic();
            this._srcPort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getSrcPort();
            this._dstPort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getDstPort();
            this._flowPriority = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getFlowPriority();
            this._idleTimeout = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getIdleTimeout();
            this._hardTimeout = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getHardTimeout();
            this._actionOutputPort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getActionOutputPort();
            this._actionSetSourceIpv4Address = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getActionSetSourceIpv4Address();
            this._actionSetDstIpv4Address = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getActionSetDstIpv4Address();
            this._actionSetIpv4Tos = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getActionSetIpv4Tos();
            this._actionSetTcpSrcPort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getActionSetTcpSrcPort();
            this._actionSetTcpDstPort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getActionSetTcpDstPort();
            this._actionSetIpv4Ttl = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getActionSetIpv4Ttl();
            this._actionSetPortQueue = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs)arg).getActionSetPortQueue();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.String getActionOutputPort() {
        return _actionOutputPort;
    }
    
    public java.lang.String getActionSetDstIpv4Address() {
        return _actionSetDstIpv4Address;
    }
    
    public java.lang.Integer getActionSetIpv4Tos() {
        return _actionSetIpv4Tos;
    }
    
    public java.lang.Short getActionSetIpv4Ttl() {
        return _actionSetIpv4Ttl;
    }
    
    public java.lang.Integer getActionSetPortQueue() {
        return _actionSetPortQueue;
    }
    
    public java.lang.String getActionSetSourceIpv4Address() {
        return _actionSetSourceIpv4Address;
    }
    
    public java.lang.Integer getActionSetTcpDstPort() {
        return _actionSetTcpDstPort;
    }
    
    public java.lang.Integer getActionSetTcpSrcPort() {
        return _actionSetTcpSrcPort;
    }
    
    public java.lang.String getDstIpAddress() {
        return _dstIpAddress;
    }
    
    public java.lang.String getDstMacAddress() {
        return _dstMacAddress;
    }
    
    public java.lang.Integer getDstPort() {
        return _dstPort;
    }
    
    public java.lang.String getFlowId() {
        return _flowId;
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
    
    public java.lang.Long getInPortId() {
        return _inPortId;
    }
    
    public FlowRulesKey getKey() {
        return _key;
    }
    
    public java.lang.String getSrcIpAddress() {
        return _srcIpAddress;
    }
    
    public java.lang.String getSrcMacAddress() {
        return _srcMacAddress;
    }
    
    public java.lang.Integer getSrcPort() {
        return _srcPort;
    }
    
    public java.lang.Integer getSwitchId() {
        return _switchId;
    }
    
    public TrafficType getTypeOfTraffic() {
        return _typeOfTraffic;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public FlowRulesBuilder setActionOutputPort(final java.lang.String value) {
        this._actionOutputPort = value;
        return this;
    }
    
     
    public FlowRulesBuilder setActionSetDstIpv4Address(final java.lang.String value) {
        this._actionSetDstIpv4Address = value;
        return this;
    }
    
     
    public FlowRulesBuilder setActionSetIpv4Tos(final java.lang.Integer value) {
        this._actionSetIpv4Tos = value;
        return this;
    }
    
     
     private static void checkActionSetIpv4TtlRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public FlowRulesBuilder setActionSetIpv4Ttl(final java.lang.Short value) {
    if (value != null) {
        checkActionSetIpv4TtlRange(value);
    }
        this._actionSetIpv4Ttl = value;
        return this;
    }
    
     
    public FlowRulesBuilder setActionSetPortQueue(final java.lang.Integer value) {
        this._actionSetPortQueue = value;
        return this;
    }
    
     
    public FlowRulesBuilder setActionSetSourceIpv4Address(final java.lang.String value) {
        this._actionSetSourceIpv4Address = value;
        return this;
    }
    
     
    public FlowRulesBuilder setActionSetTcpDstPort(final java.lang.Integer value) {
        this._actionSetTcpDstPort = value;
        return this;
    }
    
     
    public FlowRulesBuilder setActionSetTcpSrcPort(final java.lang.Integer value) {
        this._actionSetTcpSrcPort = value;
        return this;
    }
    
     
    public FlowRulesBuilder setDstIpAddress(final java.lang.String value) {
        this._dstIpAddress = value;
        return this;
    }
    
     
    public FlowRulesBuilder setDstMacAddress(final java.lang.String value) {
        this._dstMacAddress = value;
        return this;
    }
    
     
    public FlowRulesBuilder setDstPort(final java.lang.Integer value) {
        this._dstPort = value;
        return this;
    }
    
     
    public FlowRulesBuilder setFlowId(final java.lang.String value) {
        this._flowId = value;
        return this;
    }
    
     
    public FlowRulesBuilder setFlowPriority(final java.lang.Integer value) {
        this._flowPriority = value;
        return this;
    }
    
     
    public FlowRulesBuilder setHardTimeout(final java.lang.Integer value) {
        this._hardTimeout = value;
        return this;
    }
    
     
    public FlowRulesBuilder setIdleTimeout(final java.lang.Integer value) {
        this._idleTimeout = value;
        return this;
    }
    
     
     private static void checkInPortIdRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public FlowRulesBuilder setInPortId(final java.lang.Long value) {
    if (value != null) {
        checkInPortIdRange(value);
    }
        this._inPortId = value;
        return this;
    }
    
     
    public FlowRulesBuilder setKey(final FlowRulesKey value) {
        this._key = value;
        return this;
    }
    
     
    public FlowRulesBuilder setSrcIpAddress(final java.lang.String value) {
        this._srcIpAddress = value;
        return this;
    }
    
     
    public FlowRulesBuilder setSrcMacAddress(final java.lang.String value) {
        this._srcMacAddress = value;
        return this;
    }
    
     
    public FlowRulesBuilder setSrcPort(final java.lang.Integer value) {
        this._srcPort = value;
        return this;
    }
    
     
    public FlowRulesBuilder setSwitchId(final java.lang.Integer value) {
        this._switchId = value;
        return this;
    }
    
     
    public FlowRulesBuilder setTypeOfTraffic(final TrafficType value) {
        this._typeOfTraffic = value;
        return this;
    }
    
    public FlowRulesBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public FlowRulesBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public FlowRules build() {
        return new FlowRulesImpl(this);
    }

    private static final class FlowRulesImpl implements FlowRules {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules.class;
        }

        private final java.lang.String _actionOutputPort;
        private final java.lang.String _actionSetDstIpv4Address;
        private final java.lang.Integer _actionSetIpv4Tos;
        private final java.lang.Short _actionSetIpv4Ttl;
        private final java.lang.Integer _actionSetPortQueue;
        private final java.lang.String _actionSetSourceIpv4Address;
        private final java.lang.Integer _actionSetTcpDstPort;
        private final java.lang.Integer _actionSetTcpSrcPort;
        private final java.lang.String _dstIpAddress;
        private final java.lang.String _dstMacAddress;
        private final java.lang.Integer _dstPort;
        private final java.lang.String _flowId;
        private final java.lang.Integer _flowPriority;
        private final java.lang.Integer _hardTimeout;
        private final java.lang.Integer _idleTimeout;
        private final java.lang.Long _inPortId;
        private final FlowRulesKey _key;
        private final java.lang.String _srcIpAddress;
        private final java.lang.String _srcMacAddress;
        private final java.lang.Integer _srcPort;
        private final java.lang.Integer _switchId;
        private final TrafficType _typeOfTraffic;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>> augmentation = Collections.emptyMap();

        private FlowRulesImpl(FlowRulesBuilder base) {
            if (base.getKey() == null) {
                this._key = new FlowRulesKey(
                    base.getFlowId()
                );
                this._flowId = base.getFlowId();
            } else {
                this._key = base.getKey();
                this._flowId = _key.getFlowId();
            }
            this._actionOutputPort = base.getActionOutputPort();
            this._actionSetDstIpv4Address = base.getActionSetDstIpv4Address();
            this._actionSetIpv4Tos = base.getActionSetIpv4Tos();
            this._actionSetIpv4Ttl = base.getActionSetIpv4Ttl();
            this._actionSetPortQueue = base.getActionSetPortQueue();
            this._actionSetSourceIpv4Address = base.getActionSetSourceIpv4Address();
            this._actionSetTcpDstPort = base.getActionSetTcpDstPort();
            this._actionSetTcpSrcPort = base.getActionSetTcpSrcPort();
            this._dstIpAddress = base.getDstIpAddress();
            this._dstMacAddress = base.getDstMacAddress();
            this._dstPort = base.getDstPort();
            this._flowPriority = base.getFlowPriority();
            this._hardTimeout = base.getHardTimeout();
            this._idleTimeout = base.getIdleTimeout();
            this._inPortId = base.getInPortId();
            this._srcIpAddress = base.getSrcIpAddress();
            this._srcMacAddress = base.getSrcMacAddress();
            this._srcPort = base.getSrcPort();
            this._switchId = base.getSwitchId();
            this._typeOfTraffic = base.getTypeOfTraffic();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getActionOutputPort() {
            return _actionOutputPort;
        }
        
        @Override
        public java.lang.String getActionSetDstIpv4Address() {
            return _actionSetDstIpv4Address;
        }
        
        @Override
        public java.lang.Integer getActionSetIpv4Tos() {
            return _actionSetIpv4Tos;
        }
        
        @Override
        public java.lang.Short getActionSetIpv4Ttl() {
            return _actionSetIpv4Ttl;
        }
        
        @Override
        public java.lang.Integer getActionSetPortQueue() {
            return _actionSetPortQueue;
        }
        
        @Override
        public java.lang.String getActionSetSourceIpv4Address() {
            return _actionSetSourceIpv4Address;
        }
        
        @Override
        public java.lang.Integer getActionSetTcpDstPort() {
            return _actionSetTcpDstPort;
        }
        
        @Override
        public java.lang.Integer getActionSetTcpSrcPort() {
            return _actionSetTcpSrcPort;
        }
        
        @Override
        public java.lang.String getDstIpAddress() {
            return _dstIpAddress;
        }
        
        @Override
        public java.lang.String getDstMacAddress() {
            return _dstMacAddress;
        }
        
        @Override
        public java.lang.Integer getDstPort() {
            return _dstPort;
        }
        
        @Override
        public java.lang.String getFlowId() {
            return _flowId;
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
        public java.lang.Long getInPortId() {
            return _inPortId;
        }
        
        @Override
        public FlowRulesKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.String getSrcIpAddress() {
            return _srcIpAddress;
        }
        
        @Override
        public java.lang.String getSrcMacAddress() {
            return _srcMacAddress;
        }
        
        @Override
        public java.lang.Integer getSrcPort() {
            return _srcPort;
        }
        
        @Override
        public java.lang.Integer getSwitchId() {
            return _switchId;
        }
        
        @Override
        public TrafficType getTypeOfTraffic() {
            return _typeOfTraffic;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_actionOutputPort);
            result = prime * result + Objects.hashCode(_actionSetDstIpv4Address);
            result = prime * result + Objects.hashCode(_actionSetIpv4Tos);
            result = prime * result + Objects.hashCode(_actionSetIpv4Ttl);
            result = prime * result + Objects.hashCode(_actionSetPortQueue);
            result = prime * result + Objects.hashCode(_actionSetSourceIpv4Address);
            result = prime * result + Objects.hashCode(_actionSetTcpDstPort);
            result = prime * result + Objects.hashCode(_actionSetTcpSrcPort);
            result = prime * result + Objects.hashCode(_dstIpAddress);
            result = prime * result + Objects.hashCode(_dstMacAddress);
            result = prime * result + Objects.hashCode(_dstPort);
            result = prime * result + Objects.hashCode(_flowId);
            result = prime * result + Objects.hashCode(_flowPriority);
            result = prime * result + Objects.hashCode(_hardTimeout);
            result = prime * result + Objects.hashCode(_idleTimeout);
            result = prime * result + Objects.hashCode(_inPortId);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_srcIpAddress);
            result = prime * result + Objects.hashCode(_srcMacAddress);
            result = prime * result + Objects.hashCode(_srcPort);
            result = prime * result + Objects.hashCode(_switchId);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules)obj;
            if (!Objects.equals(_actionOutputPort, other.getActionOutputPort())) {
                return false;
            }
            if (!Objects.equals(_actionSetDstIpv4Address, other.getActionSetDstIpv4Address())) {
                return false;
            }
            if (!Objects.equals(_actionSetIpv4Tos, other.getActionSetIpv4Tos())) {
                return false;
            }
            if (!Objects.equals(_actionSetIpv4Ttl, other.getActionSetIpv4Ttl())) {
                return false;
            }
            if (!Objects.equals(_actionSetPortQueue, other.getActionSetPortQueue())) {
                return false;
            }
            if (!Objects.equals(_actionSetSourceIpv4Address, other.getActionSetSourceIpv4Address())) {
                return false;
            }
            if (!Objects.equals(_actionSetTcpDstPort, other.getActionSetTcpDstPort())) {
                return false;
            }
            if (!Objects.equals(_actionSetTcpSrcPort, other.getActionSetTcpSrcPort())) {
                return false;
            }
            if (!Objects.equals(_dstIpAddress, other.getDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_dstMacAddress, other.getDstMacAddress())) {
                return false;
            }
            if (!Objects.equals(_dstPort, other.getDstPort())) {
                return false;
            }
            if (!Objects.equals(_flowId, other.getFlowId())) {
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
            if (!Objects.equals(_inPortId, other.getInPortId())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_srcIpAddress, other.getSrcIpAddress())) {
                return false;
            }
            if (!Objects.equals(_srcMacAddress, other.getSrcMacAddress())) {
                return false;
            }
            if (!Objects.equals(_srcPort, other.getSrcPort())) {
                return false;
            }
            if (!Objects.equals(_switchId, other.getSwitchId())) {
                return false;
            }
            if (!Objects.equals(_typeOfTraffic, other.getTypeOfTraffic())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                FlowRulesImpl otherImpl = (FlowRulesImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("FlowRules [");
            boolean first = true;
        
            if (_actionOutputPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_actionOutputPort=");
                builder.append(_actionOutputPort);
             }
            if (_actionSetDstIpv4Address != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_actionSetDstIpv4Address=");
                builder.append(_actionSetDstIpv4Address);
             }
            if (_actionSetIpv4Tos != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_actionSetIpv4Tos=");
                builder.append(_actionSetIpv4Tos);
             }
            if (_actionSetIpv4Ttl != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_actionSetIpv4Ttl=");
                builder.append(_actionSetIpv4Ttl);
             }
            if (_actionSetPortQueue != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_actionSetPortQueue=");
                builder.append(_actionSetPortQueue);
             }
            if (_actionSetSourceIpv4Address != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_actionSetSourceIpv4Address=");
                builder.append(_actionSetSourceIpv4Address);
             }
            if (_actionSetTcpDstPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_actionSetTcpDstPort=");
                builder.append(_actionSetTcpDstPort);
             }
            if (_actionSetTcpSrcPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_actionSetTcpSrcPort=");
                builder.append(_actionSetTcpSrcPort);
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
            if (_dstPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstPort=");
                builder.append(_dstPort);
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
            if (_inPortId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_inPortId=");
                builder.append(_inPortId);
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
            if (_srcPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_srcPort=");
                builder.append(_srcPort);
             }
            if (_switchId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_switchId=");
                builder.append(_switchId);
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
