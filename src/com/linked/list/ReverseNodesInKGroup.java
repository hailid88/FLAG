package com.linked.list;

public class ReverseNodesInKGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		int k =2;
		ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
		ListNode result = obj.reverseKGroup(head, k);
		while(result!=null){
			System.out.println(result.val);
			result = result.next;
		}

	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
	      if(k<=1 || head == null) return head;
	      ListNode pre = new ListNode(0);
	      pre.next = head;
	      ListNode anchor = pre;
	      ListNode curr = head;
	      int count = 0;
	      while(curr!=null){
	          count++;
	    	  if(count%k==0){
	    		  pre = reverse(pre, curr);
	    		  curr = pre.next;
	    	  }
	    	  else{
	    		  curr=curr.next;
	    	  }
	      }
	      return anchor.next;
	}
	public ListNode reverse(ListNode pre, ListNode curr){
		//ListNode nextPre = curr;
		ListNode nextCurr = curr.next;
		curr = pre.next;
		while(curr!=null && curr.next!=nextCurr){
			ListNode tmp = curr.next;
			curr.next = tmp.next;
			tmp.next = pre.next;
			pre.next = tmp;
		}
		return curr;
		//return nextPre;
	}

}
