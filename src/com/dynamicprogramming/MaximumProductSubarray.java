package com.dynamicprogramming;

public class MaximumProductSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProduct(int[] A) {
    	 // boundary check
    	
    	if(A==null || A.length<=0) return Integer.MIN_VALUE;
    	int maxP = A[0];
    	int preMax = A[0];
    	int preMin = A[0];
    	int curMax = A[0];
    	int curMin = A[0];
    	for(int i=1; i<A.length; i++){
    		curMax = Math.max(Math.max(preMax*A[i], preMin*A[i]), A[i]);
    		curMin = Math.min(Math.min(preMax*A[i], preMin*A[i]), A[i]);
    		if(curMax>maxP){
    			maxP = curMax;
    		}
    		preMax = curMax;
    		preMin = curMin;
    	}
    	return maxP;
    }

}
