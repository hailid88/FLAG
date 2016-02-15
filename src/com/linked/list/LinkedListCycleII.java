package com.linked.list;

public class LinkedListCycleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode detectCycle(ListNode head){
		ListNode p1 = head;
        ListNode p2 = head;
        while(p2!=null&&p2.next!=null&&p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1==p2){
                break;
            }
        }
        if(p2==null||p2.next==null||p2.next.next==null) return null;
        p1 = head;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
	}
}
