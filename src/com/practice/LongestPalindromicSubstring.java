package com.practice;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author Clarence
 *
 */

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
        
        // pre-process
        String orgStr = s;
        s = preProcess(orgStr);
        int len = s.length();
        int[] lenArray = new int[len];
        for(int i = 0; i < len; i++)
            lenArray[i] = 0;
        int left = 0, right = 2, center = 1, iMirror = 0;
        
        for(int i = 1; i < len; i++)
        {
            iMirror = 2 * center - i;
            lenArray[i] = Math.min(lenArray[iMirror], right - i);
            while( i-lenArray[i] - 1 >= 0 && i+lenArray[i] + 1 < len && s.charAt(i-lenArray[i] - 1) == s.charAt(i+lenArray[i] + 1)  )
                lenArray[i]++;
            if(i+lenArray[i] >= right)
            {
                center = i;
                left = center - lenArray[i];
                right = center + lenArray[i];
            } //if
        } // for
        
        
        int maxLen = 0, locMax = 0;
        for(int i = 0; i < len; i++)
        {
            if(lenArray[i] > maxLen)
            {
                maxLen = lenArray[i];
                locMax = i;
            }
        }
        
        
        int startIdx = (locMax - maxLen) / 2;
        int endIdx = startIdx + maxLen;
        String result = orgStr.substring(startIdx, endIdx);
        return result;
    } // function
    
    public String preProcess(String input)
    {
        int len = input.length();
        String output = "#";
        for(int i = 0; i < len; i++)
        {
            output = output + input.charAt(i) + "#";
        }
        return output;
    } // function
}
