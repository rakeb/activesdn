package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors
 *
 */
public class NeighborsBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors> {

    private NeighborsKey _key;
    private NodeConnectorId _neighPort;
    private NodeId _neighborNodeId;
    private NodeConnectorId _srcPort;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>> augmentation = Collections.emptyMap();

    public NeighborsBuilder() {
    }

    public NeighborsBuilder(Neighbors base) {
        if (base.getKey() == null) {
            this._key = new NeighborsKey(
                base.getNeighborNodeId()
            );
            this._neighborNodeId = base.getNeighborNodeId();
        } else {
            this._key = base.getKey();
            this._neighborNodeId = _key.getNeighborNodeId();
        }
        this._neighPort = base.getNeighPort();
        this._srcPort = base.getSrcPort();
        if (base instanceof NeighborsImpl) {
            NeighborsImpl impl = (NeighborsImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public NeighborsKey getKey() {
        return _key;
    }
    
    public NodeConnectorId getNeighPort() {
        return _neighPort;
    }
    
    public NodeId getNeighborNodeId() {
        return _neighborNodeId;
    }
    
    public NodeConnectorId getSrcPort() {
        return _srcPort;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public NeighborsBuilder setKey(final NeighborsKey value) {
        this._key = value;
        return this;
    }
    
     
    public NeighborsBuilder setNeighPort(final NodeConnectorId value) {
        this._neighPort = value;
        return this;
    }
    
     
    public NeighborsBuilder setNeighborNodeId(final NodeId value) {
        this._neighborNodeId = value;
        return this;
    }
    
     
    public NeighborsBuilder setSrcPort(final NodeConnectorId value) {
        this._srcPort = value;
        return this;
    }
    
    public NeighborsBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public NeighborsBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Neighbors build() {
        return new NeighborsImpl(this);
    }

    private static final class NeighborsImpl implements Neighbors {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors.class;
        }

        private final NeighborsKey _key;
        private final NodeConnectorId _neighPort;
        private final NodeId _neighborNodeId;
        private final NodeConnectorId _srcPort;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>> augmentation = Collections.emptyMap();

        private NeighborsImpl(NeighborsBuilder base) {
            if (base.getKey() == null) {
                this._key = new NeighborsKey(
                    base.getNeighborNodeId()
                );
                this._neighborNodeId = base.getNeighborNodeId();
            } else {
                this._key = base.getKey();
                this._neighborNodeId = _key.getNeighborNodeId();
            }
            this._neighPort = base.getNeighPort();
            this._srcPort = base.getSrcPort();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public NeighborsKey getKey() {
            return _key;
        }
        
        @Override
        public NodeConnectorId getNeighPort() {
            return _neighPort;
        }
        
        @Override
        public NodeId getNeighborNodeId() {
            return _neighborNodeId;
        }
        
        @Override
        public NodeConnectorId getSrcPort() {
            return _srcPort;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_neighPort);
            result = prime * result + Objects.hashCode(_neighborNodeId);
            result = prime * result + Objects.hashCode(_srcPort);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors)obj;
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_neighPort, other.getNeighPort())) {
                return false;
            }
            if (!Objects.equals(_neighborNodeId, other.getNeighborNodeId())) {
                return false;
            }
            if (!Objects.equals(_srcPort, other.getSrcPort())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                NeighborsImpl otherImpl = (NeighborsImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Neighbors [");
            boolean first = true;
        
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_neighPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_neighPort=");
                builder.append(_neighPort);
             }
            if (_neighborNodeId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_neighborNodeId=");
                builder.append(_neighborNodeId);
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
