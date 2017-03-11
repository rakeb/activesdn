package org.sdnhub.odl.tutorial.tapapp.impl;

class FlowStatsTuple {
	public String flowId;
	public String srcIPAddress, dstIPAddress;
	public long srcPort = -1, dstPort = -1;
	public long packetCount, byteCount;
	public long duration, timeWindow;
	
	public TrafficProtocolType traffic;
}
