package com.array.string;

public class MaxConsecutiveSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaxConsecutiveSum obj = new MaxConsecutiveSum();
		int output = obj.maxConSum(input);
		System.out.println(output);

	}
	
	public int maxConSum(int[] input){
		if(input==null||input.length<=0) return Integer.MIN_VALUE;
		int maxSum = input[0];
		int curSum = input[0];
		for(int i =1; i<input.length; i++){
			curSum = Math.max(curSum+input[i], input[i]);
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}

}
