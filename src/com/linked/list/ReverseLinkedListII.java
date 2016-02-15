package com.linked.list;

public class ReverseLinkedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //ListNode anchor = pre;
        
        ListNode pre = dummy;
        for(int i = 1; i<m; i++){
        	pre = pre.next;
        	head = head.next;
        }
        
        while(n>m && head!=null && head.next!=null){
        	ListNode tmp = head.next;
        	head.next = tmp.next;
        	tmp.next = pre.next;
        	pre.next = tmp;
        	n--;
        }
        
        return dummy.next;
        
        
        
        
    }

}
