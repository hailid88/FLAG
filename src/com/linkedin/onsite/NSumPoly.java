package com.linkedin.onsite;

import java.util.*;

/**
 * N sum with polynomial time
 * 
 * dp[w][j]: the number of ways to use 1, 2, ..., j numbers to construct w
 * dp[w][j] = dp[w][j-1], if w < input[j-1]
 * dp[w][j] = dp[w][j-1] + dp[w-input[j-1]][j-1], if w >= input[j-1] 
 */
public class NSumPoly {
	
	// dynamic programming method
	public static int getWays(List<Integer> input, int target){
		if(input == null || input.size() <= 0 || target < 0)
			return 0;
		int n = input.size();
		int[][] dp = new int[target+1][n+1];
		
		// initialization: only if the target is hit, count 1
		for(int i = 0; i <= n; i++)
			dp[0][i] = 1;
		
		for(int j = 1; j <= n; j++){
			for(int i = 0; i <= target; i++){
				if(i < input.get(j-1))
					dp[i][j] = dp[i][j-1];
				else
					dp[i][j] = dp[i][j-1] + dp[i-input.get(j-1)][j-1];
			}
		}
		return dp[target][n];
	}
	
	// recursive method, 2 ^ n
	public int getWays(List<Integer> input, int start, int target, int curSum){
		if(curSum == target)
			return 1;
		int ways = 0;
		for(int i = start; i < input.size(); i++){
			curSum += input.get(i);
			if(curSum <= target)
				ways += getWays(input, i + 1, target, curSum);
			curSum -= input.get(i);
		} // for : i
		return ways;
	}
	
	public static void main(String[] args){
		NSumPoly n = new NSumPoly();
		List<Integer> input = new ArrayList<>();
		input.add(2);
		input.add(4);
		input.add(4);
		input.add(10);
		input.add(20);
		input.add(8);
		input.add(6);
		int target = 10, curSum = 0, start = 0;
		System.out.println(n.getWays(input, start, target, curSum) + "\n" + 
				getWays(input, target));
	}
}
