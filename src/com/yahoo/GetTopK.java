package com.yahoo;
import java.util.*;

public class GetTopK {

	public List<WordFeq> getTopK(List<WordFeq> input, int k){
		if(input == null || k <= 0)
			throw new RuntimeException("Invaid input");
		if(input.size() <= k)
			return input;
		
		//this is for getting the maxHeap
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
		Queue<WordFeq> minHeap = new PriorityQueue<>(k, new Comparator<WordFeq>(){
			@Override
			public int compare(WordFeq w1, WordFeq w2){
				if(w1.freq < w2.freq)
					return -1;
				else if(w1.freq > w2.freq)
					return 1;
				else
					return 0;
			}
		});
		
		for(WordFeq w : input){
			if(minHeap.size() < k)
				minHeap.add(w);
			else{
				if(minHeap.peek().freq < w.freq){
					minHeap.poll();
					minHeap.offer(w);
				} // if
			} // if - else
		} // for : w
		
		return new ArrayList<WordFeq>(minHeap);
	}
	
	
	public static void main(String[] args){
		
	}
}

class WordFeq{
	String word = null;
	int freq = 0;
}
