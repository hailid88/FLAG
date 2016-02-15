package com.tree;

public class SumRootToLeafNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode root, int sum){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 10*sum+root.val;
        return sumNumbers(root.left, 10*sum+root.val) + sumNumbers(root.right, 10*sum+root.val);
    }
}
