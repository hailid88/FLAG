package com.dynamicprogramming;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a 
 * binary tree by partitioning it to two non-empty substrings recursively.
Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and 
swap its two children.
For example, if we choose the node "gr" and swap its 
two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of 
nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, 
determine if s2 is a scrambled string of s1.
 * 
 * 
 * Solution: This is a dp problem and also a recursive problem
 * Recursive solution:
 * 1. divide s1 into s11, s12 parts, divide s2 to be s21, s22 parts
 * 2. respectively compare <s11, s21> & <s12, s22> and also compare
 *    <s11, s22> & <s12, s21>
 * 3. complexity: O(2^n), every character needs to compare with any other character for two times
 *
 * DP solution:
 * 1. dp[k][i][j] denote the scramble status of length k substring: 
 * 	s1 starting from i and s2 starting from j
 * 2. dp[k-1][i][j] = (dp[m-1][i][j] & dp[k-m-1][i+m][j+m]) ||
 * 					  (dp[m-1][i][j+k-m] & dp[k-m-1][i+m][j])
 * 3. check the dp[L-1][0][0], where L is length of s1 and s2
 * 4. O(n^4)
 */
public class ScrambleString {
	
	// dynamic solution
	public boolean isScrambleDP(String s1, String s2) {
		if(s1 == null || s2 == null)
			return s1 == null && s2 == null;
		s1 = s1.toLowerCase(); s2 = s2.toLowerCase();
		char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
		if(cs1.length != cs2.length)
			return false;
		int[] count = new int[26];
		for(int i = 0; i < cs1.length; i++){
			count[cs1[i] - 'a']++;
			count[cs2[i] - 'a']--;
		}
		for(int i = 0; i < count.length; i++){
			if(count[i] != 0)
				return false;
		}
		
		boolean[][][] dp = new boolean[cs1.length][cs1.length][cs1.length];
		// initialization
		for(int i = 0; i < cs1.length; i++){
			for(int j = 0; j < cs2.length; j++){
				if(cs1[i] == cs2[j])
					dp[0][i][j] = true;
			} // for : j
		} // for : i
		
		// deduction
		for(int k = 2; k <= cs1.length; k++){
			for(int i = cs1.length - k; i >= 0; i--){
				for(int j = cs1.length - k; j >= 0; j--){
					boolean isScra = false;
					for(int m = 1; m < k; m++){
						isScra |= (dp[m-1][i][j] & dp[k-m-1][i+m][j+m]);
						isScra |= (dp[m-1][i][j+k-m] & dp[k-m-1][i+m][j]);
						if(isScra)
							break;
					} //for : m, for each from 0 to k - 1
					dp[k-1][i][j] = isScra;
				} // for : j, each position in s2
			} // for : i, each position in s1
		} // for : k, length from 1 to cs1 - 1
		
		return dp[cs1.length - 1][0][0];
	}
	
	// recursive solution
	public boolean isScramble(String s1, String s2) {
		if(s1 == null || s2 == null)
			return s1 == null && s2 == null;
		char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
		if(cs1.length != cs2.length)
			return false;
		
		if(s1.equals(s2))
			return true;
		int[] count = new int[26];
		for(int i = 0; i < cs1.length; i++){
			count[cs1[i] - 'a']++;
			count[cs2[i] - 'a']--;
		}
		for(int i = 0; i < count.length; i++){
			if(count[i] != 0)
				return false;
		}
		
		for(int i = 1; i < cs1.length; i++){
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, cs1.length);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, cs1.length);
			if(isScramble(s11, s21) && isScramble(s12, s22))
				return true;
			s21 = s2.substring(cs1.length - i, cs1.length);
			s22 = s2.substring(0, cs1.length - i);
			if(isScramble(s11, s21) && isScramble(s12, s22))
				return true;
		} // for : i, check for each split
		return false;
	}
}
