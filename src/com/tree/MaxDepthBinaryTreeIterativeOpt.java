package com.tree;

import java.util.Stack;

public class MaxDepthBinaryTreeIterativeOpt {

	
    public int maxDepth(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode current = root;
    	boolean done = false;
    	int depth = 0, maxDepth = 0;
    	while(!done) {
    		if(current != null) {
				depth += 1;
    			stack.push(current);
    			System.out.println("Node=" + current.val);
    			current = current.left;
    		}
    		else{
    			if(stack.empty()){
    				done = true;
    			}
    			else{
    				if(depth > maxDepth)
    					maxDepth = depth;
    				current = stack.pop();
    				if(current.left != null)
    					depth -= 1;
    				current = current.right;
    			} // if-else
    		} // if-else
    		//System.out.println(depth);
    	} // while
    	return maxDepth;
    }
	
	public static void main(String[] args) {
		MaxDepthBinaryTreeIterativeOpt mdbt = new MaxDepthBinaryTreeIterativeOpt();
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
