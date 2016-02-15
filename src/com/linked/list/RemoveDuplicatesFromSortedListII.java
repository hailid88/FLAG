package com.linked.list;

public class RemoveDuplicatesFromSortedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next==null) return head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode anchor = pre;
        ListNode curr = head;
        
        //test case. {1,2,3}
        while(curr != null && curr.next != null) {
        	if(curr.val!=curr.next.val){
            	pre = pre.next;
            	curr = curr.next;
        	}
        	else{
        		while(curr.next!=null && curr.next.val==curr.val){
        			curr.next = curr.next.next;
        		}
        		pre.next = curr.next;
        		curr = curr.next;
        	}
        } // anchor
        return anchor.next;
    }

}
