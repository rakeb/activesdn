package org.sdnhub.odl.tutorial.tapapp.impl;

public class PathProfile {
	private Overlap overlap;
	private Integer maxPathLength;
	private Integer availableBandwith;
	private Integer maxRisk;
	
	
	public PathProfile() {
	}

	public PathProfile(Overlap overlap, Integer maxPathLength,
			Integer availableBandwith, Integer maxRisk) {
		super();
		this.overlap = overlap;
		this.maxPathLength = maxPathLength;
		this.availableBandwith = availableBandwith;
		this.maxRisk = maxRisk;
	}

	

	public Overlap getOverlap() {
		return overlap;
	}

	public void setOverlap(Overlap overlap) {
		this.overlap = overlap;
	}

	public Integer getMaxPathLength() {
		return maxPathLength;
	}

	public void setMaxPathLength(Integer maxPathLength) {
		this.maxPathLength = maxPathLength;
	}

	public Integer getAvailableBandwith() {
		return availableBandwith;
	}

	public void setAvailableBandwith(Integer availableBandwith) {
		this.availableBandwith = availableBandwith;
	}

	public Integer getMaxRisk() {
		return maxRisk;
	}

	public void setMaxRisk(Integer maxRisk) {
		this.maxRisk = maxRisk;
	}
}
