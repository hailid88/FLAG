package com.array.string;

public class FirstMissingPositive {

	/**
	 * @param args
	 * Given an unsorted integer array, find the first missing positive integer. 
	 * For example, 
	 * Given [1,2,0] return 3
	 * and [3,4,-1,1] return 2
	 * Your algorithm should run in O(n) time and uses constant space. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int firstMissingPositive(int[] A){
		if(A==null || A.length<=0) return 1;
		int n = A.length;
		
		//if 0<num<=A.length, put it to A[num-1]
		for(int i=0; i<n; i++){
			if(A[i]<=A.length && A[i]>0 && A[A[i]-1] != A[i]){
				int temp = A[A[i]-1];
				A[A[i] - 1] = A[i];
				A[i] = temp;
				i--;
			}//swap. 
//			while(A[i] != i + 1 && A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]){
//				int temp = A[i];
//				A[i] = A[A[i] - 1];
//				A[temp - 1] = temp;
//			} // swap
		}
		
		for(int i = 0; i<A.length; i++){
			if(A[i]!=i+1){
				return i+1;
			}
		}
		return A.length+1;
	}

}
