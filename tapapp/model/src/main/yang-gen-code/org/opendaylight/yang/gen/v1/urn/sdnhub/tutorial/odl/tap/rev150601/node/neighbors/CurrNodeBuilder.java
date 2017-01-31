package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors;
import java.util.Objects;
import java.util.List;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode
 *
 */
public class CurrNodeBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode> {

    private NodeId _currNodeId;
    private CurrNodeKey _key;
    private List<Neighbors> _neighbors;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>> augmentation = Collections.emptyMap();

    public CurrNodeBuilder() {
    }

    public CurrNodeBuilder(CurrNode base) {
        if (base.getKey() == null) {
            this._key = new CurrNodeKey(
                base.getCurrNodeId()
            );
            this._currNodeId = base.getCurrNodeId();
        } else {
            this._key = base.getKey();
            this._currNodeId = _key.getCurrNodeId();
        }
        this._neighbors = base.getNeighbors();
        if (base instanceof CurrNodeImpl) {
            CurrNodeImpl impl = (CurrNodeImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public NodeId getCurrNodeId() {
        return _currNodeId;
    }
    
    public CurrNodeKey getKey() {
        return _key;
    }
    
    public List<Neighbors> getNeighbors() {
        return _neighbors;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public CurrNodeBuilder setCurrNodeId(final NodeId value) {
        this._currNodeId = value;
        return this;
    }
    
     
    public CurrNodeBuilder setKey(final CurrNodeKey value) {
        this._key = value;
        return this;
    }
    
     
    public CurrNodeBuilder setNeighbors(final List<Neighbors> value) {
        this._neighbors = value;
        return this;
    }
    
    public CurrNodeBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public CurrNodeBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public CurrNode build() {
        return new CurrNodeImpl(this);
    }

    private static final class CurrNodeImpl implements CurrNode {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode.class;
        }

        private final NodeId _currNodeId;
        private final CurrNodeKey _key;
        private final List<Neighbors> _neighbors;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>> augmentation = Collections.emptyMap();

        private CurrNodeImpl(CurrNodeBuilder base) {
            if (base.getKey() == null) {
                this._key = new CurrNodeKey(
                    base.getCurrNodeId()
                );
                this._currNodeId = base.getCurrNodeId();
            } else {
                this._key = base.getKey();
                this._currNodeId = _key.getCurrNodeId();
            }
            this._neighbors = base.getNeighbors();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public NodeId getCurrNodeId() {
            return _currNodeId;
        }
        
        @Override
        public CurrNodeKey getKey() {
            return _key;
        }
        
        @Override
        public List<Neighbors> getNeighbors() {
            return _neighbors;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_currNodeId);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_neighbors);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode)obj;
            if (!Objects.equals(_currNodeId, other.getCurrNodeId())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_neighbors, other.getNeighbors())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                CurrNodeImpl otherImpl = (CurrNodeImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("CurrNode [");
            boolean first = true;
        
            if (_currNodeId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_currNodeId=");
                builder.append(_currNodeId);
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
            if (_neighbors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_neighbors=");
                builder.append(_neighbors);
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
