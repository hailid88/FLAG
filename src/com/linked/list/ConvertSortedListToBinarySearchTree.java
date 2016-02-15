package com.linked.list;

public class ConvertSortedListToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) return null;
		if(head.next==null){
			TreeNode node = new TreeNode(head.val);
			return node;
		}
		if(head.next.next==null){
			TreeNode node = new TreeNode(head.next.val);
			node.left = new TreeNode(head.val);
			return node;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode pre = new ListNode(-1);
		while(p2!=null && p2.next!=null){
			pre = pre.next;
			p1 = p1.next;
			p2 = p2.next.next;
		}
		TreeNode root = new TreeNode(p1.val);
		ListNode right = p1.next;
		pre.next = null;
		ListNode left = head;
		TreeNode lft = sortedListToBST(left);
		TreeNode rht = sortedListToBST(right);
		root.left = lft;
		root.right = rht;
		return root;
	}

}
