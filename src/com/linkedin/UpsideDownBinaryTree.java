package com.linkedin;

public class UpsideDownBinaryTree {

	public static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;
	
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		TreeNode parent = null;
		TreeNode parentRight = null;
		return upsideDownBinaryTree(root, parent, parentRight); 
	}

	private TreeNode upsideDownBinaryTree(TreeNode cur, TreeNode parent, TreeNode parentRight) {
		if (cur == null) {
			return parent;
		}
		TreeNode left = cur.left;
		TreeNode curRight = cur.right;
		cur.left = parentRight;
		cur.right = parent;
		return upsideDownBinaryTree(left, cur, curRight);
	}
}
