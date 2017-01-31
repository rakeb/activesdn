package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Objects;


public class FlowStatisticKey
 implements Identifier<FlowStatistic> {
    private static final long serialVersionUID = -4218694163165486739L;
    private final java.lang.String _flowId;


    public FlowStatisticKey(java.lang.String _flowId) {
    
    
        this._flowId = _flowId;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public FlowStatisticKey(FlowStatisticKey source) {
        this._flowId = source._flowId;
    }


    public java.lang.String getFlowId() {
        return _flowId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_flowId);
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
        FlowStatisticKey other = (FlowStatisticKey) obj;
        if (!Objects.equals(_flowId, other._flowId)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatisticKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_flowId != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_flowId=");
            builder.append(_flowId);
         }
        return builder.append(']').toString();
    }
}

