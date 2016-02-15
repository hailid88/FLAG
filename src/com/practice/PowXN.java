package com.practice;

// Implement pow(x, n). 
// http://oj.leetcode.com/problems/powx-n/

public class PowXN {
    
    public static void main(String[] args)
    {
    	double x=2;
    	int n=5;
    	double result=pow(x, n);
    }
    
    
   public static double power(double x, int n)
   {
   		double result=0;
   		if(n==0)
        {
        	result=1;
        }
        if(n==1)
        {
        	result=x;
        }
        
        if(x==0)
        {	
        	result=0;
        }
        
        double v = power(x, n / 2);
 
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
        
        
   }
    
    public static double pow(double x, int n) {
        double result=0;
        
        
        if(n<0)
        {
        	result=1/power(x, -n);
        }
        else
        {
        	result=power(x, n);
        }
        return result;
    }
}
