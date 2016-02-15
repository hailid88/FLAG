package com.linked.list;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode newH = new RandomListNode(head.label);
        RandomListNode anchor = newH;
        Map<RandomListNode, RandomListNode> tracker = new HashMap<RandomListNode, RandomListNode>();
        tracker.put(head, newH);
        while(head!=null){
        	RandomListNode random = head.random, next = head.next;
        	if(random!=null){
	        	if(tracker.containsKey(random)){
	        		newH.random = tracker.get(random);
	        	}
	        	else{
	        		RandomListNode newR = new RandomListNode(random.label);
	        		newH.random = newR;
	        		tracker.put(random, newR);
	        	}
        	}
        	if(next!=null){
        		if(tracker.containsKey(next)){
	        		newH.next = tracker.get(next);
	        	}
	        	else{
	        		RandomListNode newN = new RandomListNode(next.label);
	        		newH.next = newN;
	        		tracker.put(next, newN);
	        	}
        		
        	}
        	head = head.next;
        	newH = newH.next;
        }
        return anchor;
    }

}


class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};