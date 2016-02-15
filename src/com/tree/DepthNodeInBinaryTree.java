package com.tree;

public class DepthNodeInBinaryTree {

	int countDepth = 0;
	TreeNode depthNode = null;
    public int maxDepth(TreeNode root) {
        traverseTree(root, 0);
        return countDepth;
    }
    
    private int traverseTree(TreeNode node, int depth) {
        if(node == null){
        	if(depth > countDepth){
        		countDepth = depth;
        	}
            return depth;
        }
        else{
            depth += 1;
        }
        
        int rightDepth = traverseTree(node.right, depth);
        int leftDepth = traverseTree(node.left, depth);
        
        if(leftDepth == countDepth || rightDepth == countDepth)
        	depthNode = node;
        return 0;
    }
	
	public static void main(String[] args) {
		DepthNodeInBinaryTree mdbt = new DepthNodeInBinaryTree();
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
		System.out.println(mdbt.depthNode.val);
	}

}
