package com.linkedin;

/**
 * Key Analysis

   Let dp[i][j] stands for the edit distance between two strings
    with length i and j, i.e., word1[0,...,i-1] and word2[0,...,j-1].
    
   There is a relation between dp[i][j] and dp[i-1][j-1]. 
   Let's say we transform from one string to another. 
   The first string has length i and it's last character is "x"; 
   the second string has length j and its last character is "y". T
   
   	if x == y, then dp[i][j] == dp[i-1][j-1]
	if x != y, and we insert y for word1, then dp[i][j] = dp[i][j-1] + 1
	if x != y, and we delete x for word1, then dp[i][j] = dp[i-1][j] + 1
	if x != y, and we replace x with y for word1, then dp[i][j] = dp[i-1][j-1] + 1
	
	When x!=y, dp[i][j] is the min of the three situations.
	Initial condition:
	dp[i][0] = i, dp[0][j] = j

Java Code
 *
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
        int len1 = word1.length();
    	int len2 = word2.length();
     
    	// len1+1, len2+1, because finally return dp[len1][len2]
    	int[][] dp = new int[len1 + 1][len2 + 1];
     
    	for (int i = 0; i <= len1; i++) {
    		dp[i][0] = i;
    	}
     
    	for (int j = 0; j <= len2; j++) {
    		dp[0][j] = j;
    	}
    	
    	int replace = 0, insert = 0, delete = 0, min = 0;
     
    	//iterate though, and check last char
    	for (int i = 0; i < len1; i++) {
    		char c1 = word1.charAt(i);
    		for (int j = 0; j < len2; j++) {
    			char c2 = word2.charAt(j);
     
    			//if last two chars equal
    			if (c1 == c2) {
    				
    				//update dp value for +1 length
    				dp[i + 1][j + 1] = dp[i][j];
    			} else {
    				replace = dp[i][j] + 1;
    				insert = dp[i][j + 1] + 1;
    				delete = dp[i + 1][j] + 1;
     
    				min = replace > insert ? insert : replace;
    				min = delete > min ? min : delete;
    				dp[i + 1][j + 1] = min;
    			}
    		}
    	}
     
    	return dp[len1][len2];
    }
}
