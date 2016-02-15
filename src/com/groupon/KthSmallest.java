package com.groupon;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,5,3,6,4};
		int k = 7;
		KthSmallest obj = new KthSmallest();
		Integer resl = obj.getKth(a, k);
		System.out.println(resl);
	}
	
	public Integer getKth(int[] a, int k){
		if(a.length<k){
			return null;
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
		
		for(int i = 0; i<a.length; i++){
			if(maxHeap.size()<k){
				maxHeap.add(a[i]);
			}
			//System.out.println(maxHeap.peek());
			else if (maxHeap.peek()>a[i]){
				maxHeap.poll();
				maxHeap.offer(a[i]);
			}
		}
		return maxHeap.peek();
	}

}
