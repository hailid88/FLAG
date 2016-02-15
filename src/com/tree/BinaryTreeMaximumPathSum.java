package com.tree;

public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 * 
	 * 
	 *  1. Node only
		2. L-sub + Node
		3. R-sub + Node
		4. L-sub + Node + R-sub
		Keep trace the four path and pick up the max one in the end
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	
	public int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0]=Integer.MIN_VALUE;
		dfsMax(root, max);
		return max[0];
	}
	
	 private int dfsMax(TreeNode root, int[] max){
		 if(root == null)
			return 0;
		 int val = root.val;
		 int left = dfsMax(root.left, max);
		 int right = dfsMax(root.right, max);
		 int current = Math.max(0, Math.max(right, left)) + val;
		 max[0] = Math.max(max[0], Math.max(current, val + left + right));
		 return current;
	 }
}
