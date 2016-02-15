package com.dynamicprogramming;

public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	 * 
'.' Matches any single character.
'*' Matches zero or more of the preceding element. 

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "a*") ¡ú true
isMatch("aa", ".*") ¡ú true
isMatch("ab", ".*") ¡ú true
isMatch("aab", "c*a*b") ¡ú true
	 */
	
	public boolean isMatch(String s, String p) {
        if(s == null || p == null)
			return s == null && p == null;
		
		int m = s.length(), n = p.length();
		if(m <= 0 || n <= 0){
			if(m <= 0 && n <= 0) return true;
			if(n <= 0) return false;
		}
		
		char[] cs = s.toCharArray(), cp = p.toCharArray();
		int startP = 0;
		for(startP = 0; startP < n; startP++){
			if(cp[startP] != '*')
				break;
		}
		int pi = 0;
		boolean[] star = new boolean[n];
		for(int i = startP; i < n; i++, pi++){
			cp[pi] = cp[i];
			while(i+1 < n && cp[i+1] == '*'){
				star[pi] = true;
				i++;
			} // while
		} // for : i
		
		n = pi;
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for(int j = 1; j <= n; j++){
			dp[0][j] |= dp[0][j-1] & star[j-1];
		}
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(cs[i-1] == cp[j-1] || cp[j-1] == '.'){
					dp[i][j] |= dp[i-1][j-1];
					if(star[j-1])
						dp[i][j] |= dp[i-1][j];
				}
				if(star[j-1])
					dp[i][j] |= dp[i][j-1];
			} // for : j
		} // for : i
		
		return dp[m][n];
    }

}
