package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.LocalIpv4Prefix;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev100924.MacAddress;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import java.util.Objects;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.TapActions;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1
 *
 */
public class Tap1Builder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1> {

    private java.lang.Long _count;
    private LocalIpv4Prefix _dstIpAddress;
    private MacAddress _dstMacAddress;
    private java.lang.Long _duration;
    private java.lang.String _id;
    private NodeConnectorId _inPortConnector;
    private Tap1Key _key;
    private NodeId _node;
    private LocalIpv4Prefix _sourceIpAddress;
    private MacAddress _sourceMacAddress;
    private TapActions _tapActions;
    private TrafficType _trafficMatch;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>> augmentation = Collections.emptyMap();

    public Tap1Builder() {
    }
    public Tap1Builder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.EventActions arg) {
        this._tapActions = arg.getTapActions();
    }
    public Tap1Builder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping arg) {
        this._node = arg.getNode();
        this._inPortConnector = arg.getInPortConnector();
        this._sourceMacAddress = arg.getSourceMacAddress();
        this._dstMacAddress = arg.getDstMacAddress();
        this._sourceIpAddress = arg.getSourceIpAddress();
        this._dstIpAddress = arg.getDstIpAddress();
        this._trafficMatch = arg.getTrafficMatch();
    }

    public Tap1Builder(Tap1 base) {
        if (base.getKey() == null) {
            this._key = new Tap1Key(
                base.getId()
            );
            this._id = base.getId();
        } else {
            this._key = base.getKey();
            this._id = _key.getId();
        }
        this._count = base.getCount();
        this._dstIpAddress = base.getDstIpAddress();
        this._dstMacAddress = base.getDstMacAddress();
        this._duration = base.getDuration();
        this._inPortConnector = base.getInPortConnector();
        this._node = base.getNode();
        this._sourceIpAddress = base.getSourceIpAddress();
        this._sourceMacAddress = base.getSourceMacAddress();
        this._tapActions = base.getTapActions();
        this._trafficMatch = base.getTrafficMatch();
        if (base instanceof Tap1Impl) {
            Tap1Impl impl = (Tap1Impl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping</li>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.EventActions</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping) {
            this._node = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping)arg).getNode();
            this._inPortConnector = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping)arg).getInPortConnector();
            this._sourceMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping)arg).getSourceMacAddress();
            this._dstMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping)arg).getDstMacAddress();
            this._sourceIpAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping)arg).getSourceIpAddress();
            this._dstIpAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping)arg).getDstIpAddress();
            this._trafficMatch = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping)arg).getTrafficMatch();
            isValidArg = true;
        }
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.EventActions) {
            this._tapActions = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.EventActions)arg).getTapActions();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapGrouping, org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.EventActions] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.Long getCount() {
        return _count;
    }
    
    public LocalIpv4Prefix getDstIpAddress() {
        return _dstIpAddress;
    }
    
    public MacAddress getDstMacAddress() {
        return _dstMacAddress;
    }
    
    public java.lang.Long getDuration() {
        return _duration;
    }
    
    public java.lang.String getId() {
        return _id;
    }
    
    public NodeConnectorId getInPortConnector() {
        return _inPortConnector;
    }
    
    public Tap1Key getKey() {
        return _key;
    }
    
    public NodeId getNode() {
        return _node;
    }
    
    public LocalIpv4Prefix getSourceIpAddress() {
        return _sourceIpAddress;
    }
    
    public MacAddress getSourceMacAddress() {
        return _sourceMacAddress;
    }
    
    public TapActions getTapActions() {
        return _tapActions;
    }
    
    public TrafficType getTrafficMatch() {
        return _trafficMatch;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkCountRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public Tap1Builder setCount(final java.lang.Long value) {
    if (value != null) {
        checkCountRange(value);
    }
        this._count = value;
        return this;
    }
    
     
    public Tap1Builder setDstIpAddress(final LocalIpv4Prefix value) {
        this._dstIpAddress = value;
        return this;
    }
    
     
    public Tap1Builder setDstMacAddress(final MacAddress value) {
        this._dstMacAddress = value;
        return this;
    }
    
     
     private static void checkDurationRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public Tap1Builder setDuration(final java.lang.Long value) {
    if (value != null) {
        checkDurationRange(value);
    }
        this._duration = value;
        return this;
    }
    
     
    public Tap1Builder setId(final java.lang.String value) {
        this._id = value;
        return this;
    }
    
     
    public Tap1Builder setInPortConnector(final NodeConnectorId value) {
        this._inPortConnector = value;
        return this;
    }
    
     
    public Tap1Builder setKey(final Tap1Key value) {
        this._key = value;
        return this;
    }
    
     
    public Tap1Builder setNode(final NodeId value) {
        this._node = value;
        return this;
    }
    
     
    public Tap1Builder setSourceIpAddress(final LocalIpv4Prefix value) {
        this._sourceIpAddress = value;
        return this;
    }
    
     
    public Tap1Builder setSourceMacAddress(final MacAddress value) {
        this._sourceMacAddress = value;
        return this;
    }
    
     
    public Tap1Builder setTapActions(final TapActions value) {
        this._tapActions = value;
        return this;
    }
    
     
    public Tap1Builder setTrafficMatch(final TrafficType value) {
        this._trafficMatch = value;
        return this;
    }
    
    public Tap1Builder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public Tap1Builder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Tap1 build() {
        return new Tap1Impl(this);
    }

    private static final class Tap1Impl implements Tap1 {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1.class;
        }

        private final java.lang.Long _count;
        private final LocalIpv4Prefix _dstIpAddress;
        private final MacAddress _dstMacAddress;
        private final java.lang.Long _duration;
        private final java.lang.String _id;
        private final NodeConnectorId _inPortConnector;
        private final Tap1Key _key;
        private final NodeId _node;
        private final LocalIpv4Prefix _sourceIpAddress;
        private final MacAddress _sourceMacAddress;
        private final TapActions _tapActions;
        private final TrafficType _trafficMatch;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>> augmentation = Collections.emptyMap();

        private Tap1Impl(Tap1Builder base) {
            if (base.getKey() == null) {
                this._key = new Tap1Key(
                    base.getId()
                );
                this._id = base.getId();
            } else {
                this._key = base.getKey();
                this._id = _key.getId();
            }
            this._count = base.getCount();
            this._dstIpAddress = base.getDstIpAddress();
            this._dstMacAddress = base.getDstMacAddress();
            this._duration = base.getDuration();
            this._inPortConnector = base.getInPortConnector();
            this._node = base.getNode();
            this._sourceIpAddress = base.getSourceIpAddress();
            this._sourceMacAddress = base.getSourceMacAddress();
            this._tapActions = base.getTapActions();
            this._trafficMatch = base.getTrafficMatch();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Long getCount() {
            return _count;
        }
        
        @Override
        public LocalIpv4Prefix getDstIpAddress() {
            return _dstIpAddress;
        }
        
        @Override
        public MacAddress getDstMacAddress() {
            return _dstMacAddress;
        }
        
        @Override
        public java.lang.Long getDuration() {
            return _duration;
        }
        
        @Override
        public java.lang.String getId() {
            return _id;
        }
        
        @Override
        public NodeConnectorId getInPortConnector() {
            return _inPortConnector;
        }
        
        @Override
        public Tap1Key getKey() {
            return _key;
        }
        
        @Override
        public NodeId getNode() {
            return _node;
        }
        
        @Override
        public LocalIpv4Prefix getSourceIpAddress() {
            return _sourceIpAddress;
        }
        
        @Override
        public MacAddress getSourceMacAddress() {
            return _sourceMacAddress;
        }
        
        @Override
        public TapActions getTapActions() {
            return _tapActions;
        }
        
        @Override
        public TrafficType getTrafficMatch() {
            return _trafficMatch;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_count);
            result = prime * result + Objects.hashCode(_dstIpAddress);
            result = prime * result + Objects.hashCode(_dstMacAddress);
            result = prime * result + Objects.hashCode(_duration);
            result = prime * result + Objects.hashCode(_id);
            result = prime * result + Objects.hashCode(_inPortConnector);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_node);
            result = prime * result + Objects.hashCode(_sourceIpAddress);
            result = prime * result + Objects.hashCode(_sourceMacAddress);
            result = prime * result + Objects.hashCode(_tapActions);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1 other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1)obj;
            if (!Objects.equals(_count, other.getCount())) {
                return false;
            }
            if (!Objects.equals(_dstIpAddress, other.getDstIpAddress())) {
                return false;
            }
            if (!Objects.equals(_dstMacAddress, other.getDstMacAddress())) {
                return false;
            }
            if (!Objects.equals(_duration, other.getDuration())) {
                return false;
            }
            if (!Objects.equals(_id, other.getId())) {
                return false;
            }
            if (!Objects.equals(_inPortConnector, other.getInPortConnector())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_node, other.getNode())) {
                return false;
            }
            if (!Objects.equals(_sourceIpAddress, other.getSourceIpAddress())) {
                return false;
            }
            if (!Objects.equals(_sourceMacAddress, other.getSourceMacAddress())) {
                return false;
            }
            if (!Objects.equals(_tapActions, other.getTapActions())) {
                return false;
            }
            if (!Objects.equals(_trafficMatch, other.getTrafficMatch())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                Tap1Impl otherImpl = (Tap1Impl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Tap1 [");
            boolean first = true;
        
            if (_count != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_count=");
                builder.append(_count);
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
            if (_duration != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_duration=");
                builder.append(_duration);
             }
            if (_id != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_id=");
                builder.append(_id);
             }
            if (_inPortConnector != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_inPortConnector=");
                builder.append(_inPortConnector);
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
            if (_node != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_node=");
                builder.append(_node);
             }
            if (_sourceIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sourceIpAddress=");
                builder.append(_sourceIpAddress);
             }
            if (_sourceMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sourceMacAddress=");
                builder.append(_sourceMacAddress);
             }
            if (_tapActions != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_tapActions=");
                builder.append(_tapActions);
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
