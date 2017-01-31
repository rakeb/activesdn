package org.sdnhub.odl.tutorial.tapapp.impl;

import java.util.HashMap;
import java.util.List;

import org.jgrapht.DirectedGraph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.AllDirectedPaths;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.NeighborIndex;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetNetworkTopologyOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

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

public class NetworkGraph
{

	//UndirectedGraph<String, DefaultEdge> networkTopology;
	DirectedGraph<String, DefaultEdge> networkTopology;
	HashMap<String, LinkInfo> links = new HashMap<String, LinkInfo>();
	NeighborIndex<String, DefaultEdge> neighborGraph;
	//This stores all the links of a switch
	//HashMap<Integer, List<String>> switchLinks = new HashMap<Integer, List<String>>();
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
    //~ Constructors ———————————————————

    public NetworkGraph() {
    	//networkTopology = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
    	networkTopology = new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
    }
    
    public NetworkGraph(GetNetworkTopologyOutput topologyOutput){
    	if (networkTopology == null) {
        	networkTopology = new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
    	}
    	for (NetworkLinks link : topologyOutput.getNetworkLinks()){
    		int leftSwitch = Integer.parseInt(link.getSrcNode().getValue().split(":")[1]);
    		int rightSwitch = Integer.parseInt(link.getDstNode().getValue().split(":")[1]);
    		int leftSwitchPortNumber = Integer.parseInt(link.getSrcNodeConnector().getValue().split(":")[2]);
    		int rightSwitchPortNumber = Integer.parseInt(link.getDstNodeConnector().getValue().split(":")[2]);
    		
    		addLinkInfo(leftSwitch, rightSwitch, leftSwitchPortNumber, rightSwitchPortNumber);
    	}
    	neighborGraph = new NeighborIndex<String, DefaultEdge>(networkTopology);
    }

    //~ Methods ———————————————————
    
    public void addLinkInfo(int leftSwitch, int rightSwitch, int leftSwitchPortNumber, int rightSwitchPortNumber){
    	if (links.containsKey(Integer.toString(leftSwitch) + ":" + Integer.toString(rightSwitch)) == false){
    		LinkInfo link1 = new LinkInfo(leftSwitch, rightSwitch, leftSwitchPortNumber, rightSwitchPortNumber);
    		LinkInfo link2 = new LinkInfo(rightSwitch, leftSwitch, rightSwitchPortNumber, leftSwitchPortNumber);
   
        	links.put((Integer.toString(leftSwitch) + ":" + Integer.toString(rightSwitch)), link1);
        	links.put((Integer.toString(rightSwitch) + ":" + Integer.toString(leftSwitch)), link2);
        	
        	if (networkTopology.containsVertex(Integer.toString(leftSwitch)) == false){
        		networkTopology.addVertex(Integer.toString(leftSwitch));
        	}
        	if (networkTopology.containsVertex(Integer.toString(rightSwitch)) == false){
        		networkTopology.addVertex(Integer.toString(rightSwitch));
        	}
        	networkTopology.addEdge(Integer.toString(leftSwitch), Integer.toString(rightSwitch));
        	networkTopology.addEdge(Integer.toString(rightSwitch), Integer.toString(leftSwitch));
        	//-------------
        	//if (switchLinks.containsKey(leftSwitch)){
        	//	switchLinks.get(leftSwitch).add((Integer.toString(leftSwitch) + ":" + Integer.toString(rightSwitch)));
        	//}
        	//else {
        	//	List<String> 
        	//	switchLinks.put(leftSwitch, value)
        	//}
        	
    	}
    }
    
    public void removelinkInfo(int leftSwitch, int rightSwitch){
    	if (links.containsKey(Integer.toString(leftSwitch) + ":" + Integer.toString(rightSwitch)) == true){
    		networkTopology.removeEdge(Integer.toString(leftSwitch), Integer.toString(rightSwitch));
    		networkTopology.removeEdge(Integer.toString(rightSwitch), Integer.toString(leftSwitch));
    		
    		neighborGraph = new NeighborIndex<String, DefaultEdge>(networkTopology);
    		links.remove(Integer.toString(leftSwitch) + ":" + Integer.toString(rightSwitch));
    		links.remove(Integer.toString(rightSwitch) + ":" + Integer.toString(leftSwitch));
    	}
    }
    
    public LinkInfo findLink (int leftSwitch, int rightSwitch){
    	if (links.containsKey(Integer.toString(leftSwitch) + ":" + Integer.toString(rightSwitch)) == true) {
    		return links.get(Integer.toString(leftSwitch) + ":" + Integer.toString(rightSwitch));
    	}
    	return null;
    }

    public LinkInfo findLinkUsingOneSide(int leftSwitch, int leftSwitchPort){
    	List<String> neighbors = findNeighbors(leftSwitch);
    	for (String neighborId : neighbors){
    		LinkInfo link = findLink(leftSwitch, Integer.parseInt(neighborId));
    		if (link != null){
    			if (link.getLeftSwitchPortNumber() == leftSwitchPort) {
    				return link;
    			}
    		}
    	}
    	return null;
    }

    public List<List<String>> findAllPaths(int leftSwitch, int rightSwitch){
    	List shortestPath = DijkstraShortestPath.findPathBetween(networkTopology, 
    			Integer.toString(leftSwitch), Integer.toString(rightSwitch));
    	int shortestPathLength = 0;
    	try {
    		if (shortestPath.size() == 0) {
    			String exception = " No Path exists between nodes " + Integer.toString(leftSwitch) 
    					+ " and " + Integer.toString(rightSwitch);
				throw new Exception(exception);
        	}
    		else {
        		shortestPathLength = shortestPath.size();
        		AllDirectedPaths<String, DefaultEdge> allPaths = 
            			new AllDirectedPaths<String, DefaultEdge>(networkTopology);
            	List<GraphPath<String, DefaultEdge>> paths = allPaths.getAllPaths(Integer.toString(leftSwitch), 
            			Integer.toString(rightSwitch), true, shortestPathLength);
            	if (paths.size() == 1) {
                	paths = allPaths.getAllPaths(Integer.toString(leftSwitch), 
                			Integer.toString(rightSwitch), true, shortestPathLength + 1);
            	}
            	List<List<String>> networkPaths = Lists.newArrayList();
            	for (GraphPath<String, DefaultEdge> path: paths){
            		//LOG.debug(" ======================================================================== ");
            		//LOG.debug(path.toString());
            		//LOG.debug(" ======================================================================== ");
            		List<String> networkPath = Lists.newArrayList();
            		String prevNode = Integer.toString(leftSwitch);
            		for (DefaultEdge edge : path.getEdgeList()){
                		String link = edge.toString();
                		String leftswitchId = link.substring(link.indexOf("(") + 1, link.indexOf(":")).trim();
                		String rightswitchId = link.substring(link.indexOf(":") + 1, link.indexOf(")")).trim();
                		
                		//LOG.debug("     ==================================================================     ");
                		//LOG.debug(link + "      " + leftswitchId  +  "      " + rightswitchId);
                		//LOG.debug("      ==================================================================     ");
                		if (leftswitchId.equals(prevNode)) {
                			networkPath.add(rightswitchId);
                			prevNode = rightswitchId;
                		}
                		else {
                			networkPath.add(leftswitchId);
                			prevNode = leftswitchId;
                		}
                	}
            		networkPaths.add(networkPath);
            		//LOG.debug(" ======================================================================== ");
            		//LOG.debug(networkPath.toString());
            		//LOG.debug(" ======================================================================== ");
            	}
            	return networkPaths;
    		}
        	
    	} catch (Exception e){
    		
    		return null;
    	}
    	
    }
    
    public List<String> findShortestPath (int leftSwitch, int rightSwitch){
    	List path = DijkstraShortestPath.findPathBetween(networkTopology, 
    			Integer.toString(leftSwitch), Integer.toString(rightSwitch));
    	if (path == null){
    		LOG.debug("     ==================================================================     ");
    		LOG.debug("     No Path exists between SrcSwitch {} and DstSwitch {}", 
    				Integer.toString(leftSwitch), Integer.toString(rightSwitch));
    		LOG.debug("      ==================================================================     ");
    		return null;
    	}
    	List<String> networkPath = Lists.newArrayList();
    	networkPath.add(Integer.toString(leftSwitch));
    	String prevNode = Integer.toString(leftSwitch);
    	for (Object node : path){
    		DefaultEdge dEdge = (DefaultEdge) node;
    		String link = dEdge.toString();
    		String leftswitchId = link.substring(link.indexOf("(") + 1, link.indexOf(":")).trim();
    		String rightswitchId = link.substring(link.indexOf(":") + 1, link.indexOf(")")).trim();
    		
    		//LOG.debug("     ==================================================================     ");
    		//LOG.debug(link + "      " + leftswitchId  +  "      " + rightswitchId);
    		//LOG.debug("      ==================================================================     ");
    		if (leftswitchId.equals(prevNode)) {
    			networkPath.add(rightswitchId);
    			prevNode = rightswitchId;
    		}
    		else {
    			networkPath.add(leftswitchId);
    			prevNode = leftswitchId;
    		}
    	
    	}
    	return networkPath;
    }
    
    public int findPortID(int leftSwitch, int rightSwitch){
    	LinkInfo link = findLink(leftSwitch, rightSwitch);
    	if (link != null) {
    		return link.getLeftSwitchPortNumber();
    	}
    	return -1;
    }

    public List findNeighbors(int switchId) {
    	if (networkTopology.containsVertex(Integer.toString(switchId)) == false) {
    		return null;
    	}
    	else {
    		if (neighborGraph == null){
    			neighborGraph = new NeighborIndex<String, DefaultEdge>(networkTopology);
    		}
    		return this.neighborGraph.neighborListOf(Integer.toString(switchId));
    	}
    }
}
