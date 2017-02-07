package org.sdnhub.odl.tutorial.tapapp.impl;

import java.util.HashMap;

class SwitchStatsSnapshot {
	public HashMap<String, FlowStatsTuple> listOfFlows = new HashMap<String, FlowStatsTuple>();
	public long snapshotTime;
	public int snapshotId;
}
