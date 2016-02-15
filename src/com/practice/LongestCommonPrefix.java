package com.practice;

/**
 * http://oj.leetcode.com/problems/longest-common-prefix/
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author Clarence
 *
 */ 

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        String result = "";
        if(len <= 0)
        	return result;
        result = strs[0];
        if(len <= 1)
        	return result;
        
        // match the prefix for each of the string, start from 1 to len
        for(int i = 1; i < len; i++)
        {
        	result = matchPrefix(result, strs[i]);
        	
        	// this is the part to be used for optimization
        	if(result.length() <= 0)
        		break;
        }
        return result;
    }
	
	// find the common part in the two input string
	public String matchPrefix(String result, String str) {
		int l1 = result.length();
		int l2 = str.length();
		StringBuffer common = new StringBuffer();
		for(int i = 0, j = 0; i < l1 && j < l2; i++, j++)
		{
			if(result.charAt(i) == str.charAt(j))
				common = common.append(result.charAt(i));
			else
				break;
		}
		return common.toString();
	}
	
	public static void main(String[] args){
		String[] strs = {"absfd", "abdsfdfds"};
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(strs));
	}
}
