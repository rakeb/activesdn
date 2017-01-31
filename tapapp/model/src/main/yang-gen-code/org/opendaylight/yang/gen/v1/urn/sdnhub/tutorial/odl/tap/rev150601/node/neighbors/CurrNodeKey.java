package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors;
import org.opendaylight.yangtools.yang.binding.Identifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import java.util.Objects;


public class CurrNodeKey
 implements Identifier<CurrNode> {
    private static final long serialVersionUID = -8589298343693274043L;
    private final NodeId _currNodeId;


    public CurrNodeKey(NodeId _currNodeId) {
    
    
        this._currNodeId = _currNodeId;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public CurrNodeKey(CurrNodeKey source) {
        this._currNodeId = source._currNodeId;
    }


    public NodeId getCurrNodeId() {
        return _currNodeId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_currNodeId);
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
        CurrNodeKey other = (CurrNodeKey) obj;
        if (!Objects.equals(_currNodeId, other._currNodeId)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNodeKey.class.getSimpleName()).append(" [");
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
        return builder.append(']').toString();
    }
}

