package com.practice;

/**
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * @author Clarence
 *
 */
public class StringToInteger {
	public int atoi(String str) {
        int len = str.length();
        
        if(len <= 0)
        {
        	//throw new IllegalArgumentException("Number cannot be null/empty.");
        	return 0;
        }
            
        int i = 0;
        boolean negative = false;
        boolean isDigit = false;
        
        long result = 0;
        char digit;
        while(i < len)
        {
        	digit = str.charAt(i);
        	if(!isDigit && digit == ' ')
        	{
        		i++;
        		continue;
        	}
        	
        	if(result == 0 && str.charAt(i) == '-')
        	{
        		if(isDigit) return 0;
        		negative = true;
                i++;
                isDigit = true;
                continue;
        	}
        	else if(result == 0 && str.charAt(i) == '+')
        	{
        		if(isDigit) return 0;
        		i++;
        		isDigit = true;
        		continue;
        	}
        	isDigit = true;
        	if(digit < '0' || digit > '9')
        	{
        		//throw new IllegalArgumentException("Number contains characters other than digits at index " + i);
        		//return 0;
        		break;
        	}
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if(negative)
            result = -result;
        if(result > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        return (int)result;
    }
}
