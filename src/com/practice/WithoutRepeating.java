package com.practice;

/**
 * http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * @author Clarence
 *
 */

public class WithoutRepeating {
	public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int len = s.length();
        if(s==null || len <= 0)
        	return maxLen;
        if (len == 1)
            return len;
        int[] locArray = new int[257];
        for(int i = 0; i < locArray.length; i++)
            locArray[i] = -1;
        
        int start = 0;
        locArray[s.charAt(start)] = 0;
        
        
        for(int end = 1; end < len; end++)
        {
            if(locArray[s.charAt(end)] >= start)
                start = locArray[s.charAt(end)] + 1;
            maxLen = Math.max(maxLen, end - start + 1);
            locArray[s.charAt(end)] = end;
        }
        
        return maxLen;
    }
}
