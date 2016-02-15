package com.tree;

public class MaxDepthBinaryTreeRecursiveOpt {

	int countDepth = 0;
	TreeNode depthNode = null;
    public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }
	
	public static void main(String[] args) {
		MaxDepthBinaryTreeRecursiveOpt mdbt = new MaxDepthBinaryTreeRecursiveOpt();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(20);
		root.right = new TreeNode(21);
		root.right.right = new TreeNode(21);
		root.right.right.right = new TreeNode(21);
		root.right.right.right.right = new TreeNode(264);
		root.right.right.right.left = new TreeNode(263);
		//root.left.left.left = new TreeNode(30);
		System.out.println(mdbt.maxDepth(root));
		//System.out.println(mdbt.depthNode.val);
	}

}
