package com.microsoft;

public class MaxDistanceOfTwoNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.left.right.right = new TreeNode(1);
		root.left.right.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(1);
		int[] max = new int[1];
		max[0] =0;
		maxDist(root, max);
		System.out.println(max[0]-1);
	}
	
	private static int maxDist(TreeNode root, int[] max){
		if(root == null) return 0;
		int left = maxDist(root.left, max);
		int right = maxDist(root.right, max);
		int curr = Math.max(left, right) + 1;
		max[0] = Math.max(left+right+1, max[0]);
		return curr;
	}

}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		this.val = x;
	}
}