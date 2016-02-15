package com.tree;

public class DeepestNodeInBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepNode resl = new DepNode();
		DeepestNodeInBinaryTree obj = new DeepestNodeInBinaryTree();
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(100);
		if(root != null){
			obj.recurse(resl, root, 1);
		}
		System.out.println(resl.depth);
		System.out.println(resl.node.val);

	}
	
	public void recurse(DepNode resl, TreeNode root, int depth){
		if(root == null) return;
		if(depth>resl.depth && root.left==null && root.right==null){
			resl.depth=depth;
			resl.node = root;
		}
		recurse(resl, root.left, depth+1);
		recurse(resl, root.right, depth+1);
	}

}


class DepNode{
	int depth;
	TreeNode node;
}