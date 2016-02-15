package com.linked.list;

public class DeleteSortedDuplicates {

	/**
	 * 
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * For example,
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode deleteDuplicates(ListNode head) {
        
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        if(head==null) return null;
        if(head.next == null) return head;
        pointer2 = pointer2.next;
        while(pointer2!=null){
            if(pointer1.val == pointer2.val){
                pointer2 = pointer2.next;
                pointer1.next = pointer2;
            }else{
                pointer1.next = pointer2;
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
        }
        return head;
    }

}
