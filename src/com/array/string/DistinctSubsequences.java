package com.array.string;

/*
 * 
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by 
deleting some (can be none) of the characters without disturbing the relative positions 
of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 * * 
	 * Solution: This is a dp problem
	 * 1. dp[i][j] denote the # for the first j characters of T in the first i characters of S
	 * 2. updating rules
	 * 	  S[i] == T[j],	dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
	 * 	  S[i] != T[j], dp[i][j] = dp[i-1][j]
	 * 3. initial state
	 *    dp[i][0] = 1
 * 
 */

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
        if(S==null||T==null) return S==T?1:0;
        int m = S.length();
        int n = T.length();
        if(m==0||n==0) return n==0?1:0;
        int[][] dp = new int[m+1][n+1];
//dp[i][j] denote the # for the first j characters of T in the first i characters of S
        for(int i=0; i<=m; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<=m; i++){
            char c1 = S.charAt(i-1);
            for(int j=1; j<=i && j<=n; j++){
                char c2 = T.charAt(j-1);
                if(c1==c2){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1]; 
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
