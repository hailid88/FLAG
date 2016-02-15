package com.linked.list;

public class RotateList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		RotateList obj = new RotateList();
		ListNode result = obj.rotateRight(head, 1);
		System.out.println(result.val + " " + result.next.val);
	}
	
	public ListNode rotateRight(ListNode head, int n) {
		if(n <= 0 || head == null)
			return head;
		ListNode anchor = head;
		int len = 1;   //len is used to get the length of the linked list. 
		while(head.next != null){
			len++;
			head = head.next;
		} // while: head
		head.next = anchor;
		int k = len - n % len;
		while(k> 0){
			head = head.next;
			k = k-1;
		}
		anchor = head.next;
		head.next = null;
		return anchor;
    }

}
