package com.linkedin.onsite;

/**
 * dp[i] denote the max length from 0 to i
 * dp[i] = max(dp[i], dp[j] + 1) if A[i] >= A[j]
 * @author Clarence
 *
 */
public class MathLenghNonDecreasing {
	public static int getMax(int[] A){
		if(A == null || A.length <= 0)
			return 0;
		int n = A.length;
		int[] dp = new int[n];
		for(int i = 0; i < n; i++)
			dp[i] = 1;
		for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				if(A[i] >= A[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		
		return dp[n-1];
	}
	
	public static void main(String[] args){
		int[] A = {5, 3, 4, 8, 9, 10, 9};
		System.out.println(getMax(A));
	}
}
