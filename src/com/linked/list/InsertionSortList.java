package com.linked.list;

public class InsertionSortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode insertionSortList(ListNode head){
		if (head == null || head.next == null)
			return head;
		ListNode pre = new ListNode(-1), cur = null, next = null;
	    pre.next = head;
	    ListNode anchor = pre;
	    cur = head;
		
	    while(cur!=null){
	    	next = cur.next;
	    	if(next!=null && cur.val>next.val){
	    		pre = anchor;
	    		while(pre!=null && pre.val<next.val && pre.next!=null && pre.next.val<next.val){
	    			pre = pre.next;
	    		}
	    		cur.next = next.next;
	    		next.next = pre.next;
	    		pre.next = next;
	    	}
	    	else{
	    		cur = cur.next;
	    	}
	    }
	    return anchor.next;
	}
}
