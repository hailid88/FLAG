package com.practice;

/**
 * http://oj.leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 * @author Clarence
 *
 */

public class PalindromeNumber {
public boolean isPalindrome(int x) {
        
        if(x < 0)
        {
            return false;
        }
        
        int len=1;
        int temp1=x;
        
        while(temp1 / 10 > 0) {
        	temp1 = temp1 / 10;
        	len=len+1;
        }
        
        if(len <= 1)
        	return true;
        
        int rightFrom=0;
        int leftFrom=len-1;
        int leftNumber = 0;
        int rightNumber = 0;
        
        while (rightFrom < leftFrom) {
			leftNumber = ( x /( (int)Math.pow(10, leftFrom)) ) % 10;
			rightNumber = (x/((int)Math.pow(10,rightFrom))) % 10;
			if (leftNumber != rightNumber)
				return false;
 
            leftFrom--;
			rightFrom++;
		}
        return true;
        
    }
}
