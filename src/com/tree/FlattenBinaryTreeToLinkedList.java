package com.tree;

public class FlattenBinaryTreeToLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeNode lastVisited = null;
	public void flatten(TreeNode root){
		if(root == null) return;
		TreeNode right = root.right;
		if(lastVisited!=null){
			lastVisited.right = root;
			lastVisited.left = null;
		}
		lastVisited = root;
		flatten(root.left);
		flatten(right);
	}
	
	public void flatten2(TreeNode root){
		if(root == null) return;
		TreeNode right = root.right;
		flatten2(root.left);
		flatten2(right);
		root.right = root.left;
		root.left = null;
		TreeNode curr = root.left;
		while(curr.right!=null){
			curr = curr.right;
		}
		curr.right = right;
	}
	
}
