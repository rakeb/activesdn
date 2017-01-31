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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput
 *
 */
public class UnsubscribeForLinkFloodingCheckInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput> {

    private java.lang.Integer _connectorId;
    private java.lang.Integer _switchId;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>> augmentation = Collections.emptyMap();

    public UnsubscribeForLinkFloodingCheckInputBuilder() {
    }

    public UnsubscribeForLinkFloodingCheckInputBuilder(UnsubscribeForLinkFloodingCheckInput base) {
        this._connectorId = base.getConnectorId();
        this._switchId = base.getSwitchId();
        if (base instanceof UnsubscribeForLinkFloodingCheckInputImpl) {
            UnsubscribeForLinkFloodingCheckInputImpl impl = (UnsubscribeForLinkFloodingCheckInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.Integer getConnectorId() {
        return _connectorId;
    }
    
    public java.lang.Integer getSwitchId() {
        return _switchId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public UnsubscribeForLinkFloodingCheckInputBuilder setConnectorId(final java.lang.Integer value) {
        this._connectorId = value;
        return this;
    }
    
     
    public UnsubscribeForLinkFloodingCheckInputBuilder setSwitchId(final java.lang.Integer value) {
        this._switchId = value;
        return this;
    }
    
    public UnsubscribeForLinkFloodingCheckInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public UnsubscribeForLinkFloodingCheckInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public UnsubscribeForLinkFloodingCheckInput build() {
        return new UnsubscribeForLinkFloodingCheckInputImpl(this);
    }

    private static final class UnsubscribeForLinkFloodingCheckInputImpl implements UnsubscribeForLinkFloodingCheckInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput.class;
        }

        private final java.lang.Integer _connectorId;
        private final java.lang.Integer _switchId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>> augmentation = Collections.emptyMap();

        private UnsubscribeForLinkFloodingCheckInputImpl(UnsubscribeForLinkFloodingCheckInputBuilder base) {
            this._connectorId = base.getConnectorId();
            this._switchId = base.getSwitchId();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Integer getConnectorId() {
            return _connectorId;
        }
        
        @Override
        public java.lang.Integer getSwitchId() {
            return _switchId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_connectorId);
            result = prime * result + Objects.hashCode(_switchId);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput)obj;
            if (!Objects.equals(_connectorId, other.getConnectorId())) {
                return false;
            }
            if (!Objects.equals(_switchId, other.getSwitchId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                UnsubscribeForLinkFloodingCheckInputImpl otherImpl = (UnsubscribeForLinkFloodingCheckInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.UnsubscribeForLinkFloodingCheckInput>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("UnsubscribeForLinkFloodingCheckInput [");
            boolean first = true;
        
            if (_connectorId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_connectorId=");
                builder.append(_connectorId);
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
