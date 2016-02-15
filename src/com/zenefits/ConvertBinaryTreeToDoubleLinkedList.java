package com.zenefits;
import com.tree.TreeNode;

public class ConvertBinaryTreeToDoubleLinkedList {
	// rv.head points to the head of the doubly linked list
	// rv.tail points to the tail of the doubly linked list
	// in this way, you do not need to traverse the doubly linked list to find the head and tail
	public ReturnValue convert(TreeNode root){
		if(root == null)
			return null;
		ReturnValue rv = new ReturnValue();
		ReturnValue rvLeft = convert(root.left);
		ReturnValue rvRight = convert(root.right);
		if(rvLeft == null)
			rv.head = root;
		else
			rv.head = rvLeft.head;
		if(rvRight == null)
			rv.tail = root;
		else
			rv.tail = rvRight.tail;
		
		////the following is to create a circle. 
//		rv.head.left = rv.tail;
//		rv.tail.right = rv.head;
		
		if(rvLeft != null){
			root.left = rvLeft.tail;
			rvLeft.tail.right = root;
		}
		if(rvRight != null){
			root.right = rvRight.head;
			rvRight.head.left = root;
		}
		return rv;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.right = new TreeNode(9);
		root.left.left = new TreeNode(7);
		root.right = new TreeNode(12);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(13);
		ConvertBinaryTreeToDoubleLinkedList c = new ConvertBinaryTreeToDoubleLinkedList();
		TreeNode t = c.convert(root).head;
		TreeNode anchor = t;
		System.out.print(t.val + "->");
		t = t.right;
		while(t != anchor){
			System.out.print(t.val + "->");
			t = t.right;
		}
	}
}

class ReturnValue{
	TreeNode head, tail;
}

