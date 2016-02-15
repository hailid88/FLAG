package com.tree;

public class ValidateBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 2147483647;
		
	}
	
	public boolean isValidBST(TreeNode root) {
        //if(root==null) return true;
		
        return isB(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
	public boolean isB(TreeNode root, double min, double max){
		if(root==null) return true;
		if(root.val<=min || root.val>=max){return false;}
		return isB(root.left, min, root.val) && isB(root.right, root.val, max);
		
	}

}
