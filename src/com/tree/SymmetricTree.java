package com.tree;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSymmetric(TreeNode root){
		if(root==null) return true;
		return check(root.left, root.right);
		
	}
	public boolean check(TreeNode l, TreeNode r){
		if(l==null && r==null) return true;
		if(l==null ^ r==null) return false;
		if(l.val!=r.val) return false;
		return check(l.left, r.right) && check(l.right, r.left);
	}

}
