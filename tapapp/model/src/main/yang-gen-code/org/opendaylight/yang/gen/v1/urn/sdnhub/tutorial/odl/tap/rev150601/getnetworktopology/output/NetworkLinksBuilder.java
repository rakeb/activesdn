package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output;
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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks
 *
 */
public class NetworkLinksBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks> {

    private NodeId _dstNode;
    private NodeConnectorId _dstNodeConnector;
    private java.lang.String _id;
    private NetworkLinksKey _key;
    private NodeId _srcNode;
    private NodeConnectorId _srcNodeConnector;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>> augmentation = Collections.emptyMap();

    public NetworkLinksBuilder() {
    }
    public NetworkLinksBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NetworkLink arg) {
        this._srcNode = arg.getSrcNode();
        this._srcNodeConnector = arg.getSrcNodeConnector();
        this._dstNode = arg.getDstNode();
        this._dstNodeConnector = arg.getDstNodeConnector();
    }

    public NetworkLinksBuilder(NetworkLinks base) {
        if (base.getKey() == null) {
            this._key = new NetworkLinksKey(
                base.getId()
            );
            this._id = base.getId();
        } else {
            this._key = base.getKey();
            this._id = _key.getId();
        }
        this._dstNode = base.getDstNode();
        this._dstNodeConnector = base.getDstNodeConnector();
        this._srcNode = base.getSrcNode();
        this._srcNodeConnector = base.getSrcNodeConnector();
        if (base instanceof NetworkLinksImpl) {
            NetworkLinksImpl impl = (NetworkLinksImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NetworkLink</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NetworkLink) {
            this._srcNode = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NetworkLink)arg).getSrcNode();
            this._srcNodeConnector = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NetworkLink)arg).getSrcNodeConnector();
            this._dstNode = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NetworkLink)arg).getDstNode();
            this._dstNodeConnector = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NetworkLink)arg).getDstNodeConnector();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NetworkLink] \n" +
              "but was: " + arg
            );
        }
    }

    public NodeId getDstNode() {
        return _dstNode;
    }
    
    public NodeConnectorId getDstNodeConnector() {
        return _dstNodeConnector;
    }
    
    public java.lang.String getId() {
        return _id;
    }
    
    public NetworkLinksKey getKey() {
        return _key;
    }
    
    public NodeId getSrcNode() {
        return _srcNode;
    }
    
    public NodeConnectorId getSrcNodeConnector() {
        return _srcNodeConnector;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public NetworkLinksBuilder setDstNode(final NodeId value) {
        this._dstNode = value;
        return this;
    }
    
     
    public NetworkLinksBuilder setDstNodeConnector(final NodeConnectorId value) {
        this._dstNodeConnector = value;
        return this;
    }
    
     
    public NetworkLinksBuilder setId(final java.lang.String value) {
        this._id = value;
        return this;
    }
    
     
    public NetworkLinksBuilder setKey(final NetworkLinksKey value) {
        this._key = value;
        return this;
    }
    
     
    public NetworkLinksBuilder setSrcNode(final NodeId value) {
        this._srcNode = value;
        return this;
    }
    
     
    public NetworkLinksBuilder setSrcNodeConnector(final NodeConnectorId value) {
        this._srcNodeConnector = value;
        return this;
    }
    
    public NetworkLinksBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public NetworkLinksBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public NetworkLinks build() {
        return new NetworkLinksImpl(this);
    }

    private static final class NetworkLinksImpl implements NetworkLinks {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks.class;
        }

        private final NodeId _dstNode;
        private final NodeConnectorId _dstNodeConnector;
        private final java.lang.String _id;
        private final NetworkLinksKey _key;
        private final NodeId _srcNode;
        private final NodeConnectorId _srcNodeConnector;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>> augmentation = Collections.emptyMap();

        private NetworkLinksImpl(NetworkLinksBuilder base) {
            if (base.getKey() == null) {
                this._key = new NetworkLinksKey(
                    base.getId()
                );
                this._id = base.getId();
            } else {
                this._key = base.getKey();
                this._id = _key.getId();
            }
            this._dstNode = base.getDstNode();
            this._dstNodeConnector = base.getDstNodeConnector();
            this._srcNode = base.getSrcNode();
            this._srcNodeConnector = base.getSrcNodeConnector();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public NodeId getDstNode() {
            return _dstNode;
        }
        
        @Override
        public NodeConnectorId getDstNodeConnector() {
            return _dstNodeConnector;
        }
        
        @Override
        public java.lang.String getId() {
            return _id;
        }
        
        @Override
        public NetworkLinksKey getKey() {
            return _key;
        }
        
        @Override
        public NodeId getSrcNode() {
            return _srcNode;
        }
        
        @Override
        public NodeConnectorId getSrcNodeConnector() {
            return _srcNodeConnector;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_dstNode);
            result = prime * result + Objects.hashCode(_dstNodeConnector);
            result = prime * result + Objects.hashCode(_id);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_srcNode);
            result = prime * result + Objects.hashCode(_srcNodeConnector);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks)obj;
            if (!Objects.equals(_dstNode, other.getDstNode())) {
                return false;
            }
            if (!Objects.equals(_dstNodeConnector, other.getDstNodeConnector())) {
                return false;
            }
            if (!Objects.equals(_id, other.getId())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_srcNode, other.getSrcNode())) {
                return false;
            }
            if (!Objects.equals(_srcNodeConnector, other.getSrcNodeConnector())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                NetworkLinksImpl otherImpl = (NetworkLinksImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("NetworkLinks [");
            boolean first = true;
        
            if (_dstNode != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstNode=");
                builder.append(_dstNode);
             }
            if (_dstNodeConnector != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstNodeConnector=");
                builder.append(_dstNodeConnector);
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
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_srcNode != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_srcNode=");
                builder.append(_srcNode);
             }
            if (_srcNodeConnector != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_srcNodeConnector=");
                builder.append(_srcNodeConnector);
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
