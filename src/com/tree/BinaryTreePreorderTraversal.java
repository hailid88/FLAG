package com.tree;

import java.util.*;

import com.tree.TreeNode;

/*
 * In this traversal the value at the given node is printed first and 
 * then the left sub tree of the given node is visited and then the right 
 * sub tree of the given node is visited. This process is applied recursively 
 * all the node in the tree until either the left sub tree is empty or 
 * the right sub tree is empty.
 */

/*
*The following method use recursive, which is quite trivial. 
*
public class BinaryTreePreorderTraversal {
	public void printPreorder(Node root) {
	  printPreOrderRec(root);
	  System.out.println("");
	}

	
	 private void printPreOrderRec(Node currRoot) {
	  if (currRoot == null) {
	    return;
	  }
	  System.out.print(currRoot.value + ", ");
	  printPreOrderRec(currRoot.left);
	  printPreOrderRec(currRoot.right);
	}
}
*/

/**
 * Then the following is the iteratively method. 
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode node = root;
	    while(node != null || !stack.isEmpty()){
	        if(node != null){
	            list.add(node.val);
	            if(node.right != null)
	                stack.push(node.right);
	            node = node.left;
	        }else{
	            node = stack.pop();
	        }
	    }
	    return list;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		BinaryTreePreorderTraversal obj = new BinaryTreePreorderTraversal();
		ArrayList<Integer> resl = obj.preorderTraversal(root);
		for(Integer item:resl){
			System.out.println(item);
		}
	}
}



