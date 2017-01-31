package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts;
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
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost
 *
 */
public class ConnectedHostBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost> {

    private java.lang.String _hostFirstSeen;
    private LocalIpv4Prefix _hostIpAddress;
    private java.lang.String _hostLastSeen;
    private MacAddress _hostMacAddress;
    private ConnectedHostKey _key;
    private NodeId _nodeConnectedTo;
    private NodeConnectorId _nodeConnectorConnectedTo;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>> augmentation = Collections.emptyMap();

    public ConnectedHostBuilder() {
    }
    public ConnectedHostBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo arg) {
        this._hostMacAddress = arg.getHostMacAddress();
        this._hostIpAddress = arg.getHostIpAddress();
        this._hostLastSeen = arg.getHostLastSeen();
        this._hostFirstSeen = arg.getHostFirstSeen();
        this._nodeConnectedTo = arg.getNodeConnectedTo();
        this._nodeConnectorConnectedTo = arg.getNodeConnectorConnectedTo();
    }

    public ConnectedHostBuilder(ConnectedHost base) {
        if (base.getKey() == null) {
            this._key = new ConnectedHostKey(
                base.getHostIpAddress()
            );
            this._hostIpAddress = base.getHostIpAddress();
        } else {
            this._key = base.getKey();
            this._hostIpAddress = _key.getHostIpAddress();
        }
        this._hostFirstSeen = base.getHostFirstSeen();
        this._hostLastSeen = base.getHostLastSeen();
        this._hostMacAddress = base.getHostMacAddress();
        this._nodeConnectedTo = base.getNodeConnectedTo();
        this._nodeConnectorConnectedTo = base.getNodeConnectorConnectedTo();
        if (base instanceof ConnectedHostImpl) {
            ConnectedHostImpl impl = (ConnectedHostImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo) {
            this._hostMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo)arg).getHostMacAddress();
            this._hostIpAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo)arg).getHostIpAddress();
            this._hostLastSeen = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo)arg).getHostLastSeen();
            this._hostFirstSeen = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo)arg).getHostFirstSeen();
            this._nodeConnectedTo = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo)arg).getNodeConnectedTo();
            this._nodeConnectorConnectedTo = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo)arg).getNodeConnectorConnectedTo();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.HostInfo] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.String getHostFirstSeen() {
        return _hostFirstSeen;
    }
    
    public LocalIpv4Prefix getHostIpAddress() {
        return _hostIpAddress;
    }
    
    public java.lang.String getHostLastSeen() {
        return _hostLastSeen;
    }
    
    public MacAddress getHostMacAddress() {
        return _hostMacAddress;
    }
    
    public ConnectedHostKey getKey() {
        return _key;
    }
    
    public NodeId getNodeConnectedTo() {
        return _nodeConnectedTo;
    }
    
    public NodeConnectorId getNodeConnectorConnectedTo() {
        return _nodeConnectorConnectedTo;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public ConnectedHostBuilder setHostFirstSeen(final java.lang.String value) {
        this._hostFirstSeen = value;
        return this;
    }
    
     
    public ConnectedHostBuilder setHostIpAddress(final LocalIpv4Prefix value) {
        this._hostIpAddress = value;
        return this;
    }
    
     
    public ConnectedHostBuilder setHostLastSeen(final java.lang.String value) {
        this._hostLastSeen = value;
        return this;
    }
    
     
    public ConnectedHostBuilder setHostMacAddress(final MacAddress value) {
        this._hostMacAddress = value;
        return this;
    }
    
     
    public ConnectedHostBuilder setKey(final ConnectedHostKey value) {
        this._key = value;
        return this;
    }
    
     
    public ConnectedHostBuilder setNodeConnectedTo(final NodeId value) {
        this._nodeConnectedTo = value;
        return this;
    }
    
     
    public ConnectedHostBuilder setNodeConnectorConnectedTo(final NodeConnectorId value) {
        this._nodeConnectorConnectedTo = value;
        return this;
    }
    
    public ConnectedHostBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public ConnectedHostBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public ConnectedHost build() {
        return new ConnectedHostImpl(this);
    }

    private static final class ConnectedHostImpl implements ConnectedHost {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost.class;
        }

        private final java.lang.String _hostFirstSeen;
        private final LocalIpv4Prefix _hostIpAddress;
        private final java.lang.String _hostLastSeen;
        private final MacAddress _hostMacAddress;
        private final ConnectedHostKey _key;
        private final NodeId _nodeConnectedTo;
        private final NodeConnectorId _nodeConnectorConnectedTo;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>> augmentation = Collections.emptyMap();

        private ConnectedHostImpl(ConnectedHostBuilder base) {
            if (base.getKey() == null) {
                this._key = new ConnectedHostKey(
                    base.getHostIpAddress()
                );
                this._hostIpAddress = base.getHostIpAddress();
            } else {
                this._key = base.getKey();
                this._hostIpAddress = _key.getHostIpAddress();
            }
            this._hostFirstSeen = base.getHostFirstSeen();
            this._hostLastSeen = base.getHostLastSeen();
            this._hostMacAddress = base.getHostMacAddress();
            this._nodeConnectedTo = base.getNodeConnectedTo();
            this._nodeConnectorConnectedTo = base.getNodeConnectorConnectedTo();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getHostFirstSeen() {
            return _hostFirstSeen;
        }
        
        @Override
        public LocalIpv4Prefix getHostIpAddress() {
            return _hostIpAddress;
        }
        
        @Override
        public java.lang.String getHostLastSeen() {
            return _hostLastSeen;
        }
        
        @Override
        public MacAddress getHostMacAddress() {
            return _hostMacAddress;
        }
        
        @Override
        public ConnectedHostKey getKey() {
            return _key;
        }
        
        @Override
        public NodeId getNodeConnectedTo() {
            return _nodeConnectedTo;
        }
        
        @Override
        public NodeConnectorId getNodeConnectorConnectedTo() {
            return _nodeConnectorConnectedTo;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_hostFirstSeen);
            result = prime * result + Objects.hashCode(_hostIpAddress);
            result = prime * result + Objects.hashCode(_hostLastSeen);
            result = prime * result + Objects.hashCode(_hostMacAddress);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_nodeConnectedTo);
            result = prime * result + Objects.hashCode(_nodeConnectorConnectedTo);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost)obj;
            if (!Objects.equals(_hostFirstSeen, other.getHostFirstSeen())) {
                return false;
            }
            if (!Objects.equals(_hostIpAddress, other.getHostIpAddress())) {
                return false;
            }
            if (!Objects.equals(_hostLastSeen, other.getHostLastSeen())) {
                return false;
            }
            if (!Objects.equals(_hostMacAddress, other.getHostMacAddress())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_nodeConnectedTo, other.getNodeConnectedTo())) {
                return false;
            }
            if (!Objects.equals(_nodeConnectorConnectedTo, other.getNodeConnectorConnectedTo())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                ConnectedHostImpl otherImpl = (ConnectedHostImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("ConnectedHost [");
            boolean first = true;
        
            if (_hostFirstSeen != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hostFirstSeen=");
                builder.append(_hostFirstSeen);
             }
            if (_hostIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hostIpAddress=");
                builder.append(_hostIpAddress);
             }
            if (_hostLastSeen != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hostLastSeen=");
                builder.append(_hostLastSeen);
             }
            if (_hostMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hostMacAddress=");
                builder.append(_hostMacAddress);
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
            if (_nodeConnectedTo != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_nodeConnectedTo=");
                builder.append(_nodeConnectedTo);
             }
            if (_nodeConnectorConnectedTo != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_nodeConnectorConnectedTo=");
                builder.append(_nodeConnectorConnectedTo);
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
