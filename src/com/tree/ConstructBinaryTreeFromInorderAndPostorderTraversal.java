package com.tree;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder ==null) return null;
        int n = inorder.length;
        int m = postorder.length;
        if(n!=m || n==0) return null;
        return buildTree(inorder, postorder, 0, n-1, 0, m-1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int lIn, int rIn, int lPost, int rPost){
        if(lIn>rIn || lPost>rPost) return null;
        int rVal = postorder[rPost];
        TreeNode root = new TreeNode(rVal);
        int newrIn;
        for(newrIn = lIn; newrIn<=rIn; newrIn++){
            if(inorder[newrIn]==root.val){
                break;
            }
        }
        TreeNode left = buildTree(inorder, postorder, lIn, newrIn-1, lPost, lPost + newrIn -1 - lIn);
        TreeNode right = buildTree(inorder, postorder, newrIn + 1, rIn, lPost + newrIn -lIn, rPost -1);
        root.left = left;
        root.right = right;
        return root;
    }
	

}
