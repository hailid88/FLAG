package com.depthfirstsearch;

public class FlattenBinaryTreeToLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeNode lastVisited = null;
	public void flatten(TreeNode root) {
        if(root == null)
        	return;
        TreeNode right = root.right;
        if(lastVisited != null){
        	lastVisited.left = null;
        	lastVisited.right = root;
        }
        lastVisited = root;
        flatten(root.left);
        flatten(right);
    }

}
