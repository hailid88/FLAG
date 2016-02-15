package com.tree;

public class DeepestLeftLeafNodeInBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result resl = new Result();
		DeepestLeftLeafNodeInBinaryTree obj = new DeepestLeftLeafNodeInBinaryTree();
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		if(root != null){
			obj.recurse(resl, root, 1, true);
		}
		System.out.println(resl.depth);
		System.out.println(resl.data);
	}
	
	
	public void recurse(Result result, TreeNode node, int depth, boolean isLeft){
		if (node == null) return;
		if(isLeft && node.left == null && node.right == null){
			//we are the left leaf node. 
			if(depth > result.depth){
				result.depth = depth;
				result.data = node.val;
			}
		}
		recurse(result, node.left, depth+1, true);
		recurse(result, node.right, depth+1, false);
	}
}




class Result{
	int depth;
	int data;
}