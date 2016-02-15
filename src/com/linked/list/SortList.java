package com.linked.list;

public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//the sort for O(nlogn) is using merge sort. 
	public ListNode sortList(ListNode head) {
       if(head == null || head.next == null)
			return head;
		// split into 
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		//then slow is in the middle. separate them into left part and right part. 
		fast = slow.next;	// right part is from slow.next to end
		slow.next = null;  // left part is from head to slow
		
		//sort each individual part, and then merge them into one linkedlist. 
		ListNode left = sortList(head);
		ListNode right = sortList(fast);
		
		return merge(left, right);
	}
		
	private ListNode merge(ListNode left, ListNode right){
		ListNode fakeHead = new ListNode(-1), anchor = fakeHead;
		while(left != null || right != null){
			if(left == null){
				fakeHead.next = right;
				break;
			}
			if(right == null){
				fakeHead.next = left;
				break;
			}
			if(left.val <= right.val){
				fakeHead.next = left;
				left = left.next;
			}
			else{
				fakeHead.next = right;
				right = right.next;
			}
			fakeHead = fakeHead.next;
		} // while
		return anchor.next;
	}

}
