package com.yahoo;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class ListNode{
		int val;
		ListNode next;
	    
		ListNode(int x) {
			val = x;
			next = null;
	    }
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
        ListNode rst = null;
    	if(lists == null || lists.size() <= 0)
    		return rst;
    	
    	PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
    		@Override
    		public int compare(ListNode l1, ListNode l2){
    			if(l1.val > l2.val)
    				return 1;
    			else if(l1.val < l2.val)
    				return -1;
    			else
    				return 0;
    		}
    	});
    	//init
    	for(ListNode l : lists){
    	    if(l != null)
    		    minHeap.offer(l);
    	}
    	
    	// merge
    	ListNode head = null;
    	while(!minHeap.isEmpty()){
    		ListNode l = minHeap.poll();
    		if(l.next != null)
    			minHeap.offer(l.next);
    		if(rst == null){
    			rst = l;
    			head = rst;
    		}
    		else{
    			rst.next = l;
    			rst = rst.next;
    		}
    	}
    	
    	return head;
    }

}
