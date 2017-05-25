package org.sdnhub.odl.tutorial.tapapp.impl;

/**
 * Suppose s1,x and s2,y are left and right switch,port respectively, then link l is s1:x---------y:s2.
 * So leftSwitchPortNumber is x and rightSwitchPortNumber is y
 */
class LinkInfo {
	private int leftSwitch;
	private int rightSwitch;
	private int leftSwitchPortNumber;
	private int rightSwitchPortNumber;
	
	/**
	 * Suppose s1,x and s2,y are left and right switch,port respectively, then link l is s1:x---------y:s2.
	 * So leftSwitchPortNumber is x and rightSwitchPortNumber is y
	 * @param leftSwitch
	 * @param rightSwitch
	 * @param leftSwitchPortNumber
	 * @param rightSwitchPortNumber
	 */
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
