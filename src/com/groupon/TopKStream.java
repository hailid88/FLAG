package com.groupon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class TopKStream {
	public ArrayList<Integer> getTopk(ArrayList<Integer> list, int k){
		if(list == null || k <= 0)
			throw new RuntimeException("Invaid input");
		if(list.size() <= k)
			return list;
		
		//this is for getting the maxHeap
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
		Queue<Integer> minHeap = new PriorityQueue<>(k);
		
		for(Integer item : list){
			if(minHeap.size() < k)
				minHeap.add(item);
			else{
				if(minHeap.peek() < item){
					minHeap.poll();
					minHeap.offer(item);
				} // if
			} // if - else
		} // for : w
		
		return new ArrayList<Integer>(minHeap);
	}

}
