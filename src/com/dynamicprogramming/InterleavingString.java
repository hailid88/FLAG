package com.dynamicprogramming;

public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean isInterleave(String s1, String s2, String s3) {
		//boundary check. 
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
		
		
		if(s1.length()==0||s2.length()==0){
		    if(s1.length()==0) return s2.equals(s3);
		    if(s2.length()==0) return s1.equals(s3);
		}
		
		
		if(s1.length() + s2.length() != s3.length())
			return false;
		
		int m = s1.length(), n = s2.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		
		//initialization, that all the previous i-1 words of s3 is from s1 or s2. 
		for(int i = 1; i <= m; i++){
			if(s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0])
				dp[i][0] = true;
		}
		for(int i = 1; i <= n; i++){
			if(s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1])
				dp[0][i] = true;
		}
		
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if((s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]))
					dp[i][j] = true;
			} // for : j
		} // for : i
		
		return dp[m][n];
	}

}
