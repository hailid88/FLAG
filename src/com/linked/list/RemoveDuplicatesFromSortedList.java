package com.linked.list;

public class RemoveDuplicatesFromSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode p1 = head;
        
        while(p1.next!=null){
            if(p1.val == p1.next.val){
            	p1.next = p1.next.next;
            }
            else{
            	p1 = p1.next;
            }
        }
        return head;
    }

}
