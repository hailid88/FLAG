package com.linkedin.onsite;
import java.util.*;

public class TestPriorityQueue {
	public static void test(){
		
		ArrayList<Integer> p = new ArrayList<>();
		p.add(1);
		p.add(2);
		p.add(3);
		p.add(0);
		p.add(-100);
		p.add(100);
		PriorityQueue<Integer> pp = new PriorityQueue<>(p);
		while(!pp.isEmpty())
			System.out.println(pp.remove());
	}
	
	public static void main(String[] args){
		test();
		System.out.println((4>>>1) + ", " + (4 >> 1));
	}
	
	private void heapify() {
//		for (int i = (size >>> 1) - 1; i >= 0; i--)
//		siftDown(i, (E) queue[i]);
	}

}
