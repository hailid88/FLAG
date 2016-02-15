package com.dynamicprogramming;

/**
 * * mplement regular expression matching with support for '.' and '*'.

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
 * 
 * Solution: Dp problem
 * 	1. Consider as a 2D dp[i][j]
 *  2. go down or go right
 *  3. dp[i][j] denotes whether the first i characters * of s can be covered by the first j characters of p
 * 
 *  4. if s[i-1] == p[j-1] | p[j-1] == '.'
 *  	 dp[i][j] |= dp[i-1][j-1]
 *       if p[j-1] == '*', dp[i][j] |= dp[i-1][j] // the previous i-2 in s1 character matches 
 *       										  //	j-1 character in s2
 *  5. if p[j-1] == '*', dp[i][j] |= dp[i][j-1]   // repeat zero times
 *                         
 * Note that whole match means all the characters in s can be matched by p
 * 
 * This is a DP problem, 
 * dp[i][j] denotes whether the first i characters 
 * of s can be coverd by the first j characters of p
 * 
 * dp[i][j] = true, if dp[i-1][j-1] is true and s[i] == p[j]
 * 					or dp[i-1][j] is true and p[j] is *
 * 					or dp[i][j-1] is true and p[j] is *
 */
public class RegularExpressionMatching2 {
	public boolean isMatch(String s, String p) {
		if(s == null || p == null || s.length() <= 0 || p.length() <= 0){
			if(s == null && p == null) return true;
			if(s.length() <= 0 && p.length() <= 0) return true;
			if(p.length() <= 0)
				return false;
		}
		char[] cs = s.toCharArray(), cp = p.toCharArray();
		int m = cs.length, n = cp.length;
		// check the star position in p
		boolean[] isStar = new boolean[n];
		int pi = 0;
		for(int i = 0; i < n; i++, pi++){
			cp[pi] = cp[i];
			while(i + 1 < n && cp[i+1] == '*'){
				isStar[pi] = true;
				i++;
			}
		}
		n = pi;  // new length
		
		// initialization
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;
		for(int j = 1; j <= n ; j++)
			dp[0][j] |= dp[0][j-1] & isStar[j-1]; 
		
		// dynamically update the matching state
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(cs[i-1] == cp[j-1] || cp[j-1] == '.'){
					dp[i][j] |= dp[i-1][j-1];
					if(isStar[j-1])
						dp[i][j] |= dp[i-1][j];
				}
				if(isStar[j-1])
					dp[i][j] |= dp[i][j-1];
			} // for : j
		} // for : i
		
		return dp[m][n];
	}
	
	public static void main(String[] args){
    	String s = "abcd", p = "d*";
    	RegularExpressionMatching2 r = new RegularExpressionMatching2();
    	System.out.println(r.isMatch(s, p));
    }
}