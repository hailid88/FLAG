package com.array.string;
/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

	You have the following 3 operations permitted on a word:
	
	a) Insert a character
	b) Delete a character
	c) Replace a character
	
 * */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if(word1 == null || word2 == null)
			return 0;
		int m = word1.length(), n = word2.length();
		if(m == 0 || n == 0)
			return m > 0 ? m : n;
		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i <= m; i++)
			dp[i][0] = i;
		for(int j = 0; j <= n; j++)
			dp[0][j] = j;
		
		for(int i = 1; i <= m; i++){
			char c1 = word1.charAt(i - 1);
			for(int j = 1; j <= n; j++){
				char c2 = word2.charAt(j - 1);
				if(c1 == c2)
					dp[i][j] = dp[i-1][j-1];
				else{
					int insert = dp[i][j-1] + 1;
					int delete = dp[i-1][j] + 1;
					int replace = dp[i-1][j-1] + 1;
					int min = Math.min(insert, delete);
					min = Math.min(min, replace);
					dp[i][j] = min;
				} // if - else
			} // for : j
		} // for : i
		
		return dp[m][n];
    }

}
