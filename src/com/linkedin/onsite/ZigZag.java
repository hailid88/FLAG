package com.linkedin.onsite;

/**
 * dp[i][0] denote the max len with positive when A[i] > A[j]
 * dp[i][1] denote the max len with negative when A[i] < A[j]
 * @author Clarence
 *
 */
public class ZigZag {
	public static int getMaxZigZag(int[] A){
		if(A == null || A.length <= 0)
			return 0;
		int n = A.length;
		int[][] dp = new int[n][2];
		for(int i = 0; i < n; i++){
			dp[i][0] = dp[i][1] = 1;
			for(int j = 0; j < i; j++){
				if(A[j] < A[i])
					dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
				if(A[j] > A[i])
					dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
			}
		}
		return Math.max(dp[n-1][0], dp[n-1][1]);
	}
	
	public static void main(String[] args){
		int[] A = {1,17,5,10,13,15,10,5,16,8};
		System.out.println(getMaxZigZag(A));
	}
}
