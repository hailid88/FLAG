package com.dynamicprogramming;

public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "AABAZDCee";
		String T = "ABACBADee";
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		System.out.println(obj.lcs(S, T));
		System.out.println(obj.getLength(S, T));

	}
	
	
	public int getLength(String s1, String s2){
		if(s1 == null || s2 == null || s1.length() <= 0 ||
				s2.length() <= 0)
			return 0;
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[m+1][n+1];
		
		int maxLen = Integer.MIN_VALUE;
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			} // for : j
		} // for : i
		return dp[m][n];
	}
	
/*
 * 
To find the sequence, we just walk backwards through matrix starting the lower-right corner. 
If either the cell directly above or directly to the right contains a value equal to the value 
in the current cell, then move to that cell (if both to, then chose either one). If both such 
cells have values strictly less than the value in the current cell, then move diagonally up-left 
(this corresponts to applying Case 2), and output the associated character. This will output the 
characters in the LCS in reverse order. For instance, running on the matrix above, this outputs DABA.
 */
	
	public String lcs(String s1, String s2){
		if(s1 == null || s2 == null || s1.length() <= 0 || s2.length() <= 0) return "";
		int m = s1.length(), n = s2.length();
		
		int[][] dp = new int[m+1][n+1]; //base 1. 
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(s1.charAt(i - 1) == s2.charAt(j - 1)){   //base 0. 
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			} // for : j
		} // for : i
		
		
		
		int i = m; 
		int j = n;
		StringBuffer resl = new StringBuffer();
		while(i>=1&&j>=1){
			if((dp[i][j] > dp[i-1][j]) && dp[i][j]>dp[i][j-1]){
				i--; 
				j--;
				resl.append(s1.charAt(i));
			}
			else{
				if(dp[i][j]==dp[i-1][j]){
					i--;
				}
				else{
					j--;
				}
			}
		}
		return resl.reverse().toString();
	}
	
	//more about LCS: Discussion and Extensions. 
	//An equivalent problem to LCS is the "minimum edit distance" problem, where the legal operations are insert and delete. 
	//(e.g., the unix "diff" command, where S and T are files, and the elements of S and T are lines of text.) 
	//The minimum edit distance to transform S into T is achieved by doing |S|-LCS(S, T)
	//deletes and |T| - LCS(S, T) inserts.
}
