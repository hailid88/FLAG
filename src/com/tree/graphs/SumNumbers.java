package com.tree.graphs;

public class SumNumbers {
	
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
    public static int result =0;
    public static int[] path = null;
    public static int sumNumbers(BinaryTreeNode root) {
        int treeDepth = depth(root);
        path = new int[treeDepth];
        
        sumNumber(root, 0);
        return result;
    }
    public static void sumNumber(BinaryTreeNode root, int level){
        if(root==null){
            return;
        }
        
        path[level]=root.value;
        
        if(root.leftNode == null && root.rightNode == null){
            int t = 0;
            for(int i = 0; i<=level; i++){
                t = t*10 + path[i];
            }
            result = result + t;
        }
        else
        {
            sumNumber(root.leftNode, level+1);
            sumNumber(root.rightNode, level+1);
        }
    }
    public static int depth(BinaryTreeNode root){
        if(root==null){
            return 0;
        }
        return 1 +  Math.max(depth(root.leftNode), depth(root.rightNode));
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root = new BinaryTreeNode(4);
		root.leftNode = new BinaryTreeNode(1);
		root.rightNode = new BinaryTreeNode(2);
		int output = sumNumbers(root);
		System.out.print(output);
	}
}
