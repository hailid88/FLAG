package com.tree;

public class MaxDepthBinaryTree {

	int countDepth = 0;
    public int maxDepth(TreeNode root) {
        traverseTree(root, 0);
        return countDepth;
    }
    
    private int traverseTree(TreeNode node, int depth) {
        if(node == null){
        	if(depth > countDepth)
        		countDepth = depth;
            return depth;
        }
        else{
            depth += 1;
        }
        traverseTree(node.left, depth);
        traverseTree(node.right, depth);
        return 0;
    }
	
	public static void main(String[] args) {
		MaxDepthBinaryTree mdbt = new MaxDepthBinaryTree();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(20);
		root.right = new TreeNode(21);
		root.right.right = new TreeNode(21);
		root.right.right.right = new TreeNode(21);
		root.right.right.right.right = new TreeNode(21);
		//root.left.left.left = new TreeNode(30);
		System.out.println(mdbt.maxDepth(root));
	}

}
