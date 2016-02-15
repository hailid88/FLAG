package com.practice;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a = -2147483648;
		
		double mm = 1e2;
		int a = 5;
		int b = 10;
		int c = a - b;
		int[] intArray = new int[5];
		//System.out.println(intArray.length);
		//System.out.println(Integer.toBinaryString(c)); 
		int k = c >>> 31;
		
		//System.out.println((int)1.0);
		
		
		int maxValue = a - k * (a - b);
		//System.out.println(Integer.toBinaryString((~1+1)) + ", " +  maxValue + ", " + (1 << 11) + ", " + (1024 >>> 10));
		
		
		int d = 0;
		
		for (int i = 0; i < 27; i++){
			d |= (1 << i);
			System.out.println(d + "," + Integer.toBinaryString((d)));
		}
		
		
		//System.out.println((int)(a));
		//System.out.println(Long.MIN_VALUE);
		//System.out.println(atoi(" ++1"));
	}
	
	public static int atoi(String str) {
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
