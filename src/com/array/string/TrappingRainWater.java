package com.array.string;

public class TrappingRainWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 */
	public int trap(int[] A) {
        if(A==null || A.length<=1) return 0;
        int n = A.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        lMax[0] = 0;
        lMax[1] = A[0];
        int currMax = A[0];
        for(int i = 2; i<n; i++){
        	currMax = Math.max(currMax, A[i-1]);
        	lMax[i] = currMax;
        }
        currMax = A[n-1];
        rMax[n-1] = 0;
        rMax[n-2] = A[n-1];
        for(int i=n-3; i>0; i--){
        	currMax = Math.max(currMax, A[i+1]);
        	rMax[i] = currMax;
        }
        
        //with lMax and rMax, we can have the 
        int trap = 0;
        int minMax = 0;
        for(int i = 0; i<n; i++){
        	minMax = Math.min(lMax[i], rMax[i]);
            if(minMax>A[i]){
        	    trap = trap + minMax - A[i];
            }
        }
    	
    	return trap;
        
        
    }

}
