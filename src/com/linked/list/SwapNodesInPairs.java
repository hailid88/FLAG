package com.linked.list;

public class SwapNodesInPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next==null){
            return head;
        }
        ListNode pre = new ListNode(0), preHead = pre;
        pre.next = head;
        
        
        ListNode tmp = head.next;
        
        while(head!=null && head.next!=null){
            tmp = head.next;
            head.next = head.next.next;
            tmp.next = pre.next;
            pre.next = tmp;
            
            pre = head;
            head = head.next;
            
        }
        return preHead.next;
    }

}
