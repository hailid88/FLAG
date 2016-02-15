package com.tree.graphs;

import java.util.LinkedList;

public class SearchRoute {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public enum State{
		Unvisted, Visited, Visting; 
	}
	LinkedList<TreeNode> llist = new LinkedList<TreeNode>();
	public static boolean search(GraphNode a, GraphNode b){
		a.visit=true;
		
		for(GraphNode m: a.ajacentNodes){
			
			if(m.visit==false)
			{
				if(m == b){
					return true;
				}
				
				m.visit=true;
			}
		}
		
		return true;
		
	}
}
