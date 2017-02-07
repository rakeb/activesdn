package org.sdnhub.odl.tutorial.tapapp.impl;

class LinkInfo {
	private int leftSwitch;
	private int rightSwitch;
	private int leftSwitchPortNumber;
	private int rightSwitchPortNumber;
	
	LinkInfo (int leftSwitch, int rightSwitch, int leftSwitchPortNumber, int rightSwitchPortNumber){
		this.leftSwitch = leftSwitch;
		this.rightSwitch = rightSwitch;
		this.leftSwitchPortNumber =leftSwitchPortNumber;
		this.rightSwitchPortNumber = rightSwitchPortNumber;
	}
	
	public int getLeftSwitch() { return this.leftSwitch;}
	public int getRightSwitch() {return this.rightSwitch;}
	public int getLeftSwitchPortNumber() { return this.leftSwitchPortNumber;}
	public int getRightSwitchPortNumber() { return this.rightSwitchPortNumber; }
}
