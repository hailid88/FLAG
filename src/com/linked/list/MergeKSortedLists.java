package com.linked.list;

import java.util.*;

public class MergeKSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(0);
		ListNode dummy = a1;
		dummy.next = new ListNode(3);
		dummy = dummy.next;
		dummy.next = new ListNode(5);
		
		ListNode a2 = new ListNode(1);
		ListNode dummy2 = a2;
		dummy2.next = new ListNode(2);
		dummy2 = dummy2.next;
		dummy2.next = new ListNode(4);
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(a1);
		lists.add(a2);
		MergeKSortedLists obj = new MergeKSortedLists();
		ListNode result = obj.mergeKLists(lists);
		while(result!=null){
			System.out.println(result.val);
			result = result.next;
		}

	}
	
	
	public ListNode mergeKLists_Heap(List<ListNode> lists) {
        ListNode rst = null;
    	if(lists == null || lists.size() <= 0)
    		return rst;
    	
    	/*
    	 * PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 
          Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
    	 */
    	
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
	
	
	//
	public ListNode mergeKLists(List<ListNode> lists) {
	     if(lists==null || lists.size()<=0) return null;
	     ArrayList<ListNode> lists2 = new ArrayList<ListNode>();
	     for(ListNode list:lists){
	    	 if(list!=null) lists2.add(list);
	     }
	     ListNode head = new ListNode(0);
	     ListNode dummy = head;
	     while(!lists2.isEmpty()){
	    	 int min = Integer.MAX_VALUE;
	    	 int index = 0;
	    	 for (int i = 0; i<lists2.size(); i++){
	    		 if(lists2.get(i)!=null && lists2.get(i).val<min){
	    			 min = lists2.get(i).val;
	    			 index = i;
	    		 }
	    	 }
	    	 head.next = lists2.get(index);
	    	 head = head.next;
	    	 if(lists2.get(index).next!=null){
	    		 ListNode tmp = lists2.get(index).next;
	    		 lists2.set(index, tmp);
	    	 }
	    	 else{
	    		 lists2.remove(index);
	    	 }
	     }
	     return dummy.next;
    }

}
