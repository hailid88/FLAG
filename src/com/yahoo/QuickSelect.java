package com.yahoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSelect {

	/**
	 * @param args
	 */
	public static int quickSelect(int[] A, int k){
		if(A == null || A.length <= 0)
			return -1;
		Random r = new Random();
		int pivot = r.nextInt(A.length); //nextInt   [0, A.length-1]
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
		//int result = quickSelect(A, 0, A.length-1, A.length/2);
		//System.out.println(result);
	}
	
	
	
	
//	//second solution. 
//	public static int quickSelect(int items[], int first, int last, int k) {
//	    int pivot = partition(items, first, last);
//	    if (k < pivot-first) {
//	        return quickSelect(items, first, pivot, k);
//	    } else if (k > pivot) {
//	        return quickSelect(items, pivot+1, last, k-pivot);
//	    } else {
//	        return items[k];
//	    }
//	}
//	
//	
//	public static int partition(int[] input, int start, int end){
//		if(input == null || input.length <= 0)
//			return 0;
//		
//		int pivot = input[(start + end)/ 2];
//
//		while(start <= end){ //pay attention, that it should have the equal. 
//			while(start <= end && input[start] < pivot)      //3 5 2 1 6 7   pivot 5   start = 0, end = 5. 
//				start++;                                     //3 1 2 5 6 7
//			while(start <= end && input[end] > pivot)        //2 1 3 4 5 6  
//				end--;
//	
//			if(start <= end){
//				if(start<end && input[start]!=input[end]){
//					int tmp = input[start];
//					input[start] = input[end];
//					input[end] = tmp;
//				}
//				//else is the start = end, we do not need to change these two numbers. 
//				start++;
//				end--;
//			}
//		} // while
//		
//		return start;
//	}

}
