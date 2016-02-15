package com.linkedin;

public class MaxSubArray {
	
	// O(log(n))
		
	public int maxSubArraySimple(int[] A){
		int sum = 0, maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < A.length; i++){
			sum += A[i];
			maxSum = Math.max(sum, maxSum);
            sum = Math.max(sum, 0);
		}
		return maxSum;
	}
	
	// O(n)
	public int maxSubArray(int[] A) {
		int sum = 0, maxSum = Integer.MIN_VALUE, start = 0, end = 0, maxS = 0, maxE = 0;
		for(int i = 0; i < A.length; i++){
			if(A[i] <= 0){
				if(sum <= 0){
					sum = A[i];
					start = i;
				}
				else
					sum += A[i];
			} else {
				if(sum <= 0){
					sum = A[i];
					start = i;
				}
				else
					sum += A[i];
			}
			end = i;
			if(sum > maxSum){
				maxS = start;
				maxE = end;
				maxSum = sum;
			}
		}
		
		for(int i = maxS; i <= maxE; i++){
			System.out.print(A[i] + ", ");
		}
		System.out.println();
		return maxSum;
    }
	
	public static void main(String[] args){
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//		int[] A = {-2, -1, -3, -10, -1, -2, -1, -5, -7};
		MaxSubArray max = new MaxSubArray();
		int maxSum = max.maxSubArray(A);
		System.out.println(maxSum + ", " + max.maxSubArraySimple(A));
	
	}

}
