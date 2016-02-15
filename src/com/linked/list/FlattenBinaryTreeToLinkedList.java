package com.linked.list;

public class FlattenBinaryTreeToLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeNode lastVisited = null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode right = root.right;
        //since we need to change the left to right. 
        if(lastVisited!=null){
            lastVisited.left = null;
            lastVisited.right = root;
        }
        lastVisited = root;
        flatten(root.left);
        flatten(right);
        
    } 

}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
