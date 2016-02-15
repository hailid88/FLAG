package com.linkedin.onsite;

/**
 * With repetition
 * 	dp[w] = max value achieved with capacity w
 * 	dp[w] = max(dp[w-w_i] + v_i, dp[w]) where w_i <= w
 * 
 * without repetition
 * 	dp[w][j] = max value achieved using items 1, 2, .., j with capacity w
 *  dp[w][j] = max(dp[w][j-1], dp[w-w_j][j-1] + v_j) when w_j <= w
 */
public class Knapsack {
	
	// max value without repetition
	public static int getMaxWithoutR(int[] weight, int[] value, int cap){
		if(weight == null || weight.length <= 0 || value == null ||
				value.length <= 0 || weight.length != value.length ||
				cap <= 0)
			return 0;
		int n = weight.length;
		int[][] dp = new int[cap+1][n+1];
		for(int i = 0; i <= cap; i++)
			dp[i][0] = 0;
		for(int i = 0; i <= n; i++)
			dp[0][i] = 0;
		
		for(int j = 1; j <= n; j++){
			for(int i = 1; i <= cap; i++){
				if(i < weight[j-1])
					dp[i][j] = dp[i][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-weight[j-1]][j-1] + value[j-1]);
			}
		}
		
		return dp[cap][n];
	}

	// max value with repetition
	public static int getMaxValue(int[] weight, int[] value, int cap){
		if(weight == null || weight.length <= 0 || value == null ||
				value.length <= 0 || weight.length != value.length ||
				cap <= 0)
			return 0;
		
		int n = weight.length;
		int[] dp = new int[cap+1];
		dp[0] = 0;
		for(int i = 1; i <= cap; i++){
			for(int j = 0; j < n; j++){
				if(i >= weight[j])
					dp[i] = Math.max(dp[i], dp[i-weight[j]] + value[j]);
			} // for : j
		} // for : i
		
		return dp[cap];
	}
	
	public static void main(String[] args){
		Knapsack k = new Knapsack();
		int[] weight = {6, 3, 4, 2}, value = {30, 14, 16, 9};
		int cap = 10;
		System.out.println(getMaxValue(weight, value, cap) + "\n" + getMaxWithoutR(weight, value, cap));
	}
}
