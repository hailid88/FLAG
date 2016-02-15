package com.practice;

/*
 * This is quite trivial for using recursive way. 
 */
/*
 * In this traversal the left sub tree of the given node is visited first, 
 * then the value at the given node is printed and then the right sub tree 
 * of the given node is visited. This process is applied recursively all the node
 * in the tree until either the left sub tree is empty or the right sub tree is empty.
 */


public class BinaryTreeInorderTraversal {
	/**
	 * Printing the contents of the tree in an inorder way.
	 */
	public void printInorder(Node root){
	  printInOrderRec(root);
	  System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(Node currRoot){
	  if ( currRoot == null ){
	    return;
	  }
	  printInOrderRec(currRoot.left);
	  System.out.print(currRoot.value+", ");
	  printInOrderRec(currRoot.right);
	}
}



class Node {
	public int value;
	public Node left;
	public Node right;

    public Node(int value) {
	    this.value = value;
	}

}


