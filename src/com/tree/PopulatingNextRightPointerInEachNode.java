package com.tree;
import java.util.Queue;
import java.util.LinkedList;
public class PopulatingNextRightPointerInEachNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//use recurisve to solve the problem. 
	public void connect_r(TreeLinkNode root){
		if(root == null) return;
		if(root.left!=null){
			root.left.next = root.right;
			if(root.next!=null){
				root.right.next = root.next.left;
			}
		}
		connect_r(root.left);
		connect_r(root.right);
	}
	
	//use Queue to solve the problem. 
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		Queue<TreeLinkNode> curr = new LinkedList<TreeLinkNode>();
		curr.offer(root);
		while(!curr.isEmpty()){
			Queue<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
			TreeLinkNode node1 = curr.poll();
			if(node1.left!=null){
				next.offer(node1.left);
			}
			if(node1.right!=null){
				next.offer(node1.right);
			}
			while(!curr.isEmpty()){
				TreeLinkNode node2 = curr.poll();
				if(node2.left!=null){
					next.offer(node2.left);
				}
				if(node2.right!=null){
					next.offer(node2.right);
				}
				node1.next = node2;
				node1 = node2;
			}
			node1.next = null;
			curr = next;
		}
	}

}
