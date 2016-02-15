package com.practice;

public class BinaryTreeMaximumPathSum {

	TreeNode root;
	int maxInValue;
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
		solution.root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		solution.root.left = left;
		solution.root.right = right;
		solution.root.left.left = new TreeNode(8);
		solution.root.left.right = new TreeNode(80);
		solution.root.right.right = new TreeNode(20);
		System.out.println(solution.maxPathSum(solution.root));
	}
	
	public int maxPathSum(TreeNode root) {
		this.maxInValue = Integer.MIN_VALUE;
		int maxOutValue = this.getMax(root);
		return Math.max(maxInValue, maxOutValue);
    }
	
	public int getMax(TreeNode root)
	{
		if(root == null)
			return 0;
		int left = this.getMax(root.left);
		int right = this.getMax(root.right);
		int curValue = root.val;
		if(left > 0)
			curValue += left;
		if(right > 0)
			curValue += right;
		this.maxInValue = Math.max(this.maxInValue, curValue);
		return Math.max(root.val, Math.max(root.val + left, root.val + right));
		
	}

}
