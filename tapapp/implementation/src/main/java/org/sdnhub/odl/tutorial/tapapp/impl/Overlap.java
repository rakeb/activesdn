package org.sdnhub.odl.tutorial.tapapp.impl;

public class Overlap {
	public static final int NO_OVERLAP = 0;
	public static final int PERCENTAGE = 1;
	public static final int EXCLUDE_SPECIFIC_LINK = 2;
	public static final int INCLUDE_SPECIFIC_LINK = 3;
	
	private int overlapStatus;
	private String overlapValue;
	
	public Overlap() {
		
	}

	public Overlap(int overlapStatus, String overlapValue) {
		super();
		this.overlapStatus = overlapStatus;
		this.overlapValue = overlapValue;
	}

	public int getOverlapStatus() {
		return overlapStatus;
	}

	public void setOverlapStatus(int noOverlap) {
		this.overlapStatus = noOverlap;
	}

	public String getOverlapValue() {
		return overlapValue;
	}

	public void setOverlapValue(String overlapValue) {
		this.overlapValue = overlapValue;
	}
	
	
}