package com.facebook;

import java.util.ArrayList;

public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,-2,1,1,3, -2};
		MaximumSubarray obj = new MaximumSubarray();
		System.out.println("max sum is " + obj.maxSubArray(A));
		int[] result = obj.maxSubArrayIndx(A);
		for(int indx : result){
			System.out.println(indx);
		}
	}
	/*
	 * 
Find the contiguous subarray within an array (containing at least one number) 
which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
	 */
	public int maxSubArray(int[] A) {
		int maxV = A[0];
		int curSum = A[0];
		for(int i = 1; i<A.length; i++){
			curSum = Math.max(curSum+A[i], A[i]);
			maxV = Math.max(maxV, curSum);
		}
		return maxV;
	}
	
	//if the method name is the same, but the return type is different, will be error. 
	//Duplicate method maxSubArray(int[]) in type MaximumSubarray
	
	//get the subarray start indx and end indx that has the maximum sum. 
	public int[] maxSubArrayIndx(int[] A){
		int[] resl = new int[2];
		resl[0] = 0;
		resl[1] = 0;
		int maxS = A[0];
		int curS = A[0];
		int startIdx=0;
		int endIdx=0;
		for(int i=1; i<A.length; i++){
			if(curS+A[i]<A[i]){
				curS = A[i];
				startIdx = i;
				endIdx = i;
			}else{
				curS = curS + A[i];
				endIdx = i;
			}
			if(maxS<curS){
				maxS = curS;
				resl[0]= startIdx;
				resl[1] = endIdx;
			}
			
		}
		
		return resl;
	}
	//get the start indx and end indx of the subarray. 

}
