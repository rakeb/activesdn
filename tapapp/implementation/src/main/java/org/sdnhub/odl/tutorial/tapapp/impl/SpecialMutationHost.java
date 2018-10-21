package org.sdnhub.odl.tutorial.tapapp.impl;

import java.util.ArrayList;
import java.util.List;

import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.special.mutation.input.HMi;

/**
 * Created by mislam7 on 10/18/18.
 */
public class SpecialMutationHost {
    class Pair<L, R> {
        private final L dest;
        private final R mutatedDst;

        Pair(L dest, R mutatedDst) {
            this.dest = dest;
            this.mutatedDst = mutatedDst;
        }

        public L getDest() {
            return dest;
        }

        public R getMutatedDst() {
            return mutatedDst;
        }
    }

    ConnectedHostInfo connectedHostInfo;
    List<String> mutaionIpTable;
    double mi; //Mutable address per host = (n-1)*mi
    int n; //Number of total host in the network.
    List<Pair> mutationPair = new ArrayList<Pair>(); // Mainly contains H1-->(H3,H8), (H4,H11)
    boolean isMutable = false;

    String hostName;
    int availableIpIndex = 0;

	public SpecialMutationHost(ConnectedHostInfo connectedHostInfo,	List<HMi> hMiList, int n, List<String> unusedIpRange) {
		this.connectedHostInfo = connectedHostInfo;
		this.hostName = connectedHostInfo.getHostIP();
		this.n = n;
		String hostIp;

		// if host is mutable
		for (HMi hmi : hMiList) {
			hostIp = hmi.getH();
			if (hostIp.equals(hostName)) {
				this.isMutable = true;
				this.mi = Double.parseDouble(hmi.getMi());

				int mutableAddressPerHostRange = (int) ((n - 1) * (mi-1));
				this.mutaionIpTable = new ArrayList<String>(unusedIpRange.subList(0, mutableAddressPerHostRange));
				for (int i = 0; i < mutableAddressPerHostRange; i++) {
	                if (i < unusedIpRange.size())
	                    unusedIpRange.remove(0);
	            }

				// populate the mutation IP table up to n-1
				for (int i = mutableAddressPerHostRange; i < n - 1; i++) {
					mutaionIpTable.add(i, mutaionIpTable.get(i - 1));
				}
				break;
			}
		}
		
	}
	
//    public SpecialMutationHost(String hostName, List<String> h, int n, List<String> unusedIpRange, List<String> miList) {
//        this.hostName = hostName;
//        this.n = n;
//        String hostIp = hostName;
//
//        //if host is mutable
//        if (h.contains(hostIp)) {
//            this.isMutable = true;
//            int index = h.indexOf(hostIp);
//            this.mi = Double.parseDouble(miList.get(index));
//
//            int mutableAddressPerHostRange = (int) ((n - 1) * mi);
//            this.mutaionIpTable = new ArrayList<String>(unusedIpRange.subList(0, mutableAddressPerHostRange));
////            unusedIpRange = unusedIpRange.subList(mutableAddressPerHostRange, unusedIpRange.size());
//            for (int i = 0; i < mutableAddressPerHostRange; i++) {
//                if (i < unusedIpRange.size())
//                    unusedIpRange.remove(0);
//            }
//
//            //populate the mutation IP table upto n-1
//            for (int i = mutableAddressPerHostRange; i < n - 1; i++) {
//                mutaionIpTable.add(i, mutaionIpTable.get(i - 1));
//            }
//        }
//    }

    public String getNextAvailableMutationIp() {
        if (availableIpIndex < mutaionIpTable.size()) {
            return mutaionIpTable.get(availableIpIndex++);
        }

        return null;
    }

    public void updateMutationPair(SpecialMutationHost dst) {
        if (!dst.isMutable)
            return;
        Pair<String, String> pair = new Pair<String, String>(dst.hostName, dst.getNextAvailableMutationIp());
        this.mutationPair.add(pair);
    }

    @Override
    public String toString() {
        return hostName;
    }
}
