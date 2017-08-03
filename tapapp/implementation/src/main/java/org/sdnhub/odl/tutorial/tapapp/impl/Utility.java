package org.sdnhub.odl.tutorial.tapapp.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility {
	
	public static boolean equalLists(List<String> one, List<String> two){     
	    if (one == null && two == null){
	        return true;
	    }

	    if((one == null && two != null) 
	      || one != null && two == null
	      || one.size() != two.size()){
	        return false;
	    }

	    //to avoid messing the order of the lists we will use a copy
	    one = new ArrayList<String>(one); 
	    two = new ArrayList<String>(two);   

	    Collections.sort(one);
	    Collections.sort(two);      
	    return one.equals(two);
	}
	
	public static List<String> getDifferntPath(List<List<String>> paths, List<String> path) {
		for (List<String> diffPath : paths) {
			if (!equalLists(diffPath, path)) {
				return diffPath;
			}
		}
		return null;
	}
	
//	public static boolean equalLists(List<Integer> one, List<Integer> two){     
//	    if (one == null && two == null){
//	        return true;
//	    }
//
//	    if((one == null && two != null) 
//	      || one != null && two == null
//	      || one.size() != two.size()){
//	        return false;
//	    }
//
//	    //to avoid messing the order of the lists we will use a copy
//	    one = new ArrayList<Integer>(one); 
//	    two = new ArrayList<Integer>(two);   
//
//	    Collections.sort(one);
//	    Collections.sort(two);      
//	    return one.equals(two);
//	}
	
	
//	public static boolean isPathContainInGraph(Path givenPath, ArrayList<Path> graphActiveTraffic){     
//	    for (Path path : graphActiveTraffic) {
//			return Utilities.equalLists(path.getOrderedNodeListInInteger(), givenPath.getOrderedNodeListInInteger());
//		}
//	    return false;
//	}
}