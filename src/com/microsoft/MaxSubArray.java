package com.microsoft;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 3, -2, 3, 4};
		int result = getMaxSub(a);
		System.out.println(result);

	}
	
	public static int getMaxSub(int[] a){
		if(a.length<=0) return Integer.MIN_VALUE;
		int currSum = a[0];
		int maxSum = a[0];
		for(int i = 1; i<a.length; i++){
			currSum = Math.max(currSum+a[i], a[i]);
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

}
