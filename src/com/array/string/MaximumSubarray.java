package com.array.string;

public class MaximumSubarray {
	public static void main(String args[] ) throws Exception {
		int[] A = {1,2,3,-2,1,1,3, -2};
		MaximumSubarray obj = new MaximumSubarray();
		System.out.println("max sum is " + obj.maxSubArray(A));
		int[] result = obj.maxSubArrayIndx(A);
		for(int indx : result){
			System.out.println(indx);
		}
	}
	
	//this is only used to return the maximumal value. 
	public int maxSubArray(int[] A) {
        int Alen = A.length;
        int maxSum = A[0];
        int currSum = A[0];
        for(int i = 1; i<Alen; i++){
        	currSum = Math.max(currSum + A[i], A[i]);
        	maxSum = Math.max(currSum, maxSum);
        }
        
        return maxSum;
    }
	
	
	//revise the code little bit to get the subarray that has the maximumal value. 
	
	public int[] maxSubArrayIndx(int[] A){
		//return the start and endIndx;
		int Alen = A.length;
        int maxSum = A[0];
        int currSum = A[0];
        int[] indxes = new int[2];
        int currStart = 0;
        int currEnd = 0;
        for(int i = 1; i<Alen; i++){
        	if(currSum + A[i] > A[i]){
        		currEnd = i;
        	}
        	else{
        		currStart = i;
        		currEnd = i;
        	}
        	currSum = Math.max(currSum + A[i], A[i]);
        	if(currSum>maxSum){
        		maxSum = currSum;
        		indxes[0] = currStart;
        		indxes[1] = currEnd;
        	}
        	
        }
        return indxes;
	}

}
