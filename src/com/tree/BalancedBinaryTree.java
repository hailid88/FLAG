package com.tree;

public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		    1
		   / \
		  1   1
		 /     \  
		1       1 
		 */
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);                                   
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(1);
		BalancedBinaryTree obj = new BalancedBinaryTree();
		boolean flag = false;
		boolean result = obj.isBalanced(root, flag);
		System.out.println(result);
	}
	
	public boolean isBalanced(TreeNode root, boolean flag) {
		if(root==null) return true;
		if(flag){
			if(Math.abs(depth(root.left)-depth(root.right))>1) return false;
			return isBalanced(root.left, flag) && isBalanced(root.right, flag);
		}
		else{
			if(isB(root)==-1){
				return false;
			}
			else{
				return true;
			}
		}
	}
	
	public int depth(TreeNode root){
		if(root==null) return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.max(left, right)+1;
	}
	
	
	public int isB(TreeNode root){
		if(root == null) return 0;
		int left = isB(root.left);
		if(left==-1) return -1;
		int right = isB(root.right);
		if(right==-1) return -1;
		if(Math.abs(left-right)>1){
			return -1;
		}
		return Math.max(left, right)+1;
	}

}
