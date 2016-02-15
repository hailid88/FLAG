package com.tree.graphs;

import java.util.*;

public class GraphNode {
	List<GraphNode> ajacentNodes = null; 
	int value;
	boolean visit=false;
	//ArrayList<GraphNode>  alist = new ArrayList<GraphNode>();
	public void getAllNodes(GraphNode n, ArrayList<GraphNode>  alist){
		n.visit=true;
		for (GraphNode m : n.ajacentNodes){
			if(m.visit==false){
				m.visit=true;
				alist.add(m);
				getAllNodes(m, alist);
			}
		}
		
	}
	public GraphNode(int x){
		value = x;
		ajacentNodes = new ArrayList<GraphNode>();
	}
}


