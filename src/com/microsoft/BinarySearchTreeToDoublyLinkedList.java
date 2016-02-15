package com.microsoft;

public class BinarySearchTreeToDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public BSTreeNode bstToDoubleLinkedList(BSTreeNode root){
		BSTreeNode head = null, tail = null;
		helper(head, tail, root);
		return head;
	}
	public void helper(BSTreeNode head, BSTreeNode tail, BSTreeNode root){
		BSTreeNode lt = null, rh = null;
		
		if(root==null){
			head = null; 
			tail = null;
			return;
		}
		
		helper(head, lt, root.left);
		helper(rh, tail, root.right);
		if(lt==null){
			head = root;
		}
		else{
			lt.right = root;
			root.left = lt;
		}
		if(rh==null){
			tail = root;
		}
		else{
			root.right = rh;
			rh.left = root;
		}
	};
	

}

class BSTreeNode{
	int value;
	BSTreeNode left;
	BSTreeNode right;
}
