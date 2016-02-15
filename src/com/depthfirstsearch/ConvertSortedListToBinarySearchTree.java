package com.depthfirstsearch;

public class ConvertSortedListToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
        if(head.next==null) return new TreeNode(head.val);
		if(head.next.next == null){
			TreeNode root = new TreeNode(head.val);
			TreeNode r = new TreeNode(head.next.val);
			root.right = r;
			return root;
		}
        ListNode pre= new ListNode(-1);
        pre.next = head;
        ListNode p1= head;
        ListNode p2= head;
        while(p2.next!=null && p2.next.next!=null){
            pre = pre.next;
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        TreeNode root = new TreeNode(p1.val);
        ListNode right = p1.next;
        pre.next = null;
        ListNode left = head;
        TreeNode l = sortedListToBST(left);
        TreeNode r = sortedListToBST(right);
        root.left = l;
        root.right = r;
        return root;
    }

}
