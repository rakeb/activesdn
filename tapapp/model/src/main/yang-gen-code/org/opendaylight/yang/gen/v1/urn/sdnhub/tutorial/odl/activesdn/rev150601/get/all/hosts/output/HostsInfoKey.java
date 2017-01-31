package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.hosts.output;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Objects;


public class HostsInfoKey
 implements Identifier<HostsInfo> {
    private static final long serialVersionUID = 1536806715886834888L;
    private final java.lang.Long _id;


    public HostsInfoKey(java.lang.Long _id) {
    
    
        this._id = _id;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public HostsInfoKey(HostsInfoKey source) {
        this._id = source._id;
    }


    public java.lang.Long getId() {
        return _id;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_id);
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
        HostsInfoKey other = (HostsInfoKey) obj;
        if (!Objects.equals(_id, other._id)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.hosts.output.HostsInfoKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_id != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_id=");
            builder.append(_id);
         }
        return builder.append(']').toString();
    }
}

