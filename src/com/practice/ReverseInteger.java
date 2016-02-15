package com.practice;

/**
 * http://oj.leetcode.com/problems/reverse-integer/
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 * @author Clarence
 *
 */
public class ReverseInteger {

	public int reverse(int x) {
        boolean negative = false;
        if(x < 0) {
            negative = true; 
            x = -x;
        }
        
        int result = 0;
        while((x / 10) > 0)
        {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        result = result * 10 + x % 10;
        if(negative)
            result = -result;
        return result;
        
    }
}
