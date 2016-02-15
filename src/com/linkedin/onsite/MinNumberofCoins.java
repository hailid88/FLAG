package com.linkedin.onsite;

/**
 * dp[i] denote the fact that the min # of coins used to 
 * construct value i
 * 
 * dp[i] = min(dp[i], dp[i-value[j]] + 1), if i > value[j]
 */
public class MinNumberofCoins {
	public int minNumber(int[] coins, int target){
		int n = target + 1;
		int[] dp = new int[n];
		for(int i = 0; i < n; i++)
			dp[i] = Integer.MAX_VALUE;
		
		dp[0] = 0;
		for(int i = 1; i < n; i++){
			for(int j = 0; j < coins.length; j++){
				if(i >= coins[j])
					dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
			}
		}
		
		return dp[n-1];
	}
	
	public static void main(String[] args){
		int[] coins = {1, 3, 5};
		int target = 4;
		MinNumberofCoins m = new MinNumberofCoins();
		System.out.println(m.minNumber(coins, target));
	}
}
