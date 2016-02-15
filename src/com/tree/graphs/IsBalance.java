package com.tree.graphs;

public class IsBalance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//it is very simple, just calculate the max depth and min depth. 
	public static int maxDepth(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		else{
			return 1 + Math.max(maxDepth(root.leftNode), maxDepth(root.rightNode));
		}
	}
	
	public static int minDepth(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		else{
			return 1 + Math.min(minDepth(root.leftNode), minDepth(root.rightNode));
		}
	}
	
	public static boolean isBalance(BinaryTreeNode root){
		return (maxDepth(root)-minDepth(root)<=1);
	}
	

}
