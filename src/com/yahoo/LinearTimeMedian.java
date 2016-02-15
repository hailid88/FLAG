package com.yahoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinearTimeMedian {

	
	// simple randomized algorithm
	public static int quickSelect(int[] A, int k){
		if(A == null || A.length <= 0)
			return -1;
		Random r = new Random();
		int pivot = r.nextInt(A.length);
		List<Integer> less = new ArrayList<>(), greater = new ArrayList<>();
		for(int i = 0; i < A.length; i++){
			if(A[i] <= A[pivot])
				less.add(A[i]);
			else
				greater.add(A[i]);
		}
		if(less.size() - 1 == k)
			return getMax(less);
		else if(less.size() - 1 > k)
			return quickSelect(toIntArray(less), k);
		else
			return quickSelect(toIntArray(greater), k - less.size());
	}
	
	private static int[] toIntArray(List<Integer> input){
		if(input == null)
			return null;
		int[] output = new int[input.size()];
		int i = 0;
		for(Integer in : input)
			output[i++] = in;
		return output;

	}
	
	private static int getMax(List<Integer> input){
		int max = Integer.MIN_VALUE;
		for(Integer i : input)
			max = max < i ? i : max;
		return max;
	}
	
	public static void main(String[] args){
		int[] A = {1, 3, 5, 0, 19, 2, 4};
		System.out.println(quickSelect(A, A.length/2));
	}

}
