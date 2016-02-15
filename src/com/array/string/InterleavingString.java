package com.array.string;

/**
 * Interleaving String Total Accepted: 19733 Total Submissions: 100584 My Submissions Question Solution 
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 * 
 * 
 * Solution: This is a DP problem
 * 1. dp[i][j] = true meaning that s1's i characters and s2's j 
 * 	  characters can form s3's (i+j) characters
 * 2. dp[i][j] = true
 * 		if s1[i - 1] == s3[i + j - 1] && dp[i - 1][j]  // go down: check up
 *      or s2[j - 1] == s3[i + j - 1] && dp[i][j - 1] // go right: check left
 * 3. The initialization state is dp[0][0] = true
 * 4. finally check dp[s1.length()][s2.length()]
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null){
			if(s1 == null){
				if(s2 == null)
					return s2 == s3;
				else
					return s2.equals(s3);
			}
			else if(s2 == null){
				if(s1 == null)
					return s1 == s3;
				else
					return s1.equals(s3);
			}
			else
				return false;
		}
		
		if(s1.length() + s2.length() != s3.length())
			return false;
		
		int m = s1.length(), n = s2.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		
		//initialization.
		for(int i = 1; i <= m; i++){
			if(s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0])
				dp[i][0] = true;
		}
		for(int i = 1; i <= n; i++){
			if(s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1])
				dp[0][i] = true;
		}
		
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n; j++){
				if((s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) ||
						(s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]))
					dp[i][j] = true;
			} // for : j
		} // for : i
		
		return dp[m][n];
	}
}
