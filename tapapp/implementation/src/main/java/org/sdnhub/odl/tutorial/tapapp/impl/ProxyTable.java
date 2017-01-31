package org.sdnhub.odl.tutorial.tapapp.impl;

import java.util.ArrayList;
import java.util.HashMap;

public class ProxyTable {
	ArrayList<String> source;
	HashMap<String, String> action;
	HashMap<String, String> forwardTo;
	
	public ProxyTable() {
		this.source = new ArrayList<String>();
		this.action = new HashMap<String, String>();
		this.forwardTo = new HashMap<String, String>();
	}

	public ProxyTable(ArrayList<String> source, HashMap<String, String> action,
			HashMap<String, String> forwardTo) {
		super();
		this.source = source;
		this.action = action;
		this.forwardTo = forwardTo;
	}

	public ArrayList<String> getSource() {
		return source;
	}

	public void setSource(ArrayList<String> source) {
		this.source = source;
	}

	public HashMap<String, String> getAction() {
		return action;
	}

	public void setAction(HashMap<String, String> action) {
		this.action = action;
	}

	public HashMap<String, String> getForwardTo() {
		return forwardTo;
	}

	public void setForwardTo(HashMap<String, String> forwardTo) {
		this.forwardTo = forwardTo;
	}
}
