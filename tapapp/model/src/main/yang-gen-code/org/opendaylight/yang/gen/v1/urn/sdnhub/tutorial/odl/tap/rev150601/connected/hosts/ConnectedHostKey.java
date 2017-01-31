package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Objects;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.LocalIpv4Prefix;


public class ConnectedHostKey
 implements Identifier<ConnectedHost> {
    private static final long serialVersionUID = -6650712347451014506L;
    private final LocalIpv4Prefix _hostIpAddress;


    public ConnectedHostKey(LocalIpv4Prefix _hostIpAddress) {
    
    
        this._hostIpAddress = _hostIpAddress;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public ConnectedHostKey(ConnectedHostKey source) {
        this._hostIpAddress = source._hostIpAddress;
    }


    public LocalIpv4Prefix getHostIpAddress() {
        return _hostIpAddress;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_hostIpAddress);
        return result;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ConnectedHostKey other = (ConnectedHostKey) obj;
        if (!Objects.equals(_hostIpAddress, other._hostIpAddress)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHostKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_hostIpAddress != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_hostIpAddress=");
            builder.append(_hostIpAddress);
         }
        return builder.append(']').toString();
    }
}

