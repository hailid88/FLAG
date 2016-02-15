package com.tree.graphs;
import java.util.*;

public class TreeNode {
	int value;
	ArrayList<TreeNode> childNodes;
	boolean visited;
	public void dfsSearch(TreeNode root){
		if(root==null){
			return; 
		}
		root.visited = true;
		for (TreeNode n: root.childNodes){
			if(n.visited==false){
				dfsSearch(n);
			}
		}
	}
	public void bfsSearch(TreeNode root){
		if(root == null){
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		root.visited = true;
	    queue.add(root);
		
	    while(!queue.isEmpty()){
	    	TreeNode node = queue.getFirst();
	    	queue.remove(0);
	    	if(node!=null){
				for (TreeNode n: node.childNodes){
					n.visited=true;
					queue.add(n);
				}
	    	}
		}
	}

}
