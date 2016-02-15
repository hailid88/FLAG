package com.linked.list;

public class PartitionList {

	/**
	 * @param args
	 * 
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode lS = null;
        ListNode lE = null;
        ListNode rS = null;
        ListNode rE = null;
        while(head!=null){
        	if(head.val>=x){
        		if(rS==null){
        			rS = new ListNode(head.val);
        			rE = rS;
        		}
        		else{
        			rE.next = new ListNode(head.val);
        			rE = rE.next;
        		}
        	}
        	else{
        		if(lS==null){
        			lS = new ListNode(head.val);
        			lE = lS;
        		}
        		else{
        			lE.next = new ListNode(head.val);
        			lE = lE.next;
        		}
        	}
        	head = head.next;
        }
		
        if(lS==null) return rS;
        if(rS==null) return lS;
        lE.next = rS;
        return lS;
        
    }

}
