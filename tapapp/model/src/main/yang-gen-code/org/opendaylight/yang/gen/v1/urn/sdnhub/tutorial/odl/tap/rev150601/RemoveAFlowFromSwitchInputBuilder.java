package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput
 *
 */
public class RemoveAFlowFromSwitchInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput> {

    private java.lang.String _flowKey;
    private NodeId _nodeId;
    private java.lang.Short _tableId;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>> augmentation = Collections.emptyMap();

    public RemoveAFlowFromSwitchInputBuilder() {
    }

    public RemoveAFlowFromSwitchInputBuilder(RemoveAFlowFromSwitchInput base) {
        this._flowKey = base.getFlowKey();
        this._nodeId = base.getNodeId();
        this._tableId = base.getTableId();
        if (base instanceof RemoveAFlowFromSwitchInputImpl) {
            RemoveAFlowFromSwitchInputImpl impl = (RemoveAFlowFromSwitchInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getFlowKey() {
        return _flowKey;
    }
    
    public NodeId getNodeId() {
        return _nodeId;
    }
    
    public java.lang.Short getTableId() {
        return _tableId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public RemoveAFlowFromSwitchInputBuilder setFlowKey(final java.lang.String value) {
        this._flowKey = value;
        return this;
    }
    
     
    public RemoveAFlowFromSwitchInputBuilder setNodeId(final NodeId value) {
        this._nodeId = value;
        return this;
    }
    
     
     private static void checkTableIdRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public RemoveAFlowFromSwitchInputBuilder setTableId(final java.lang.Short value) {
    if (value != null) {
        checkTableIdRange(value);
    }
        this._tableId = value;
        return this;
    }
    
    public RemoveAFlowFromSwitchInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public RemoveAFlowFromSwitchInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public RemoveAFlowFromSwitchInput build() {
        return new RemoveAFlowFromSwitchInputImpl(this);
    }

    private static final class RemoveAFlowFromSwitchInputImpl implements RemoveAFlowFromSwitchInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput.class;
        }

        private final java.lang.String _flowKey;
        private final NodeId _nodeId;
        private final java.lang.Short _tableId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>> augmentation = Collections.emptyMap();

        private RemoveAFlowFromSwitchInputImpl(RemoveAFlowFromSwitchInputBuilder base) {
            this._flowKey = base.getFlowKey();
            this._nodeId = base.getNodeId();
            this._tableId = base.getTableId();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getFlowKey() {
            return _flowKey;
        }
        
        @Override
        public NodeId getNodeId() {
            return _nodeId;
        }
        
        @Override
        public java.lang.Short getTableId() {
            return _tableId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_flowKey);
            result = prime * result + Objects.hashCode(_nodeId);
            result = prime * result + Objects.hashCode(_tableId);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput)obj;
            if (!Objects.equals(_flowKey, other.getFlowKey())) {
                return false;
            }
            if (!Objects.equals(_nodeId, other.getNodeId())) {
                return false;
            }
            if (!Objects.equals(_tableId, other.getTableId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                RemoveAFlowFromSwitchInputImpl otherImpl = (RemoveAFlowFromSwitchInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("RemoveAFlowFromSwitchInput [");
            boolean first = true;
        
            if (_flowKey != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_flowKey=");
                builder.append(_flowKey);
             }
            if (_nodeId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_nodeId=");
                builder.append(_nodeId);
             }
            if (_tableId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_tableId=");
                builder.append(_tableId);
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
