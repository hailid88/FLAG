package com.linkedin;

/**
 * Naturally, we next may think how to do it in O(logn).
 *  
 * We have a relation that x^n = x^(n/2) * x^(n/2) * x^(n%2). 
 * 
 * By using this relation, a recursive solution can easily be written.
 */

public class PowXN {
	
	public double pow(double x, int n) {
		if(n == 0 || x == 0)
			return 1;
		
		double v = pow(x, n/2);
		if(n % 2 == 0)
			return v * v;
		if(n < 0)
			return v * v / x;
		else
			return v * v * x;
	}
	
	public double powIterative(double x, int n) {
		if(n == 0)
			return 1;
		double result = 1;
		int pn = n >= 0 ? n : -n;
		
		for(int i = 1; i <= pn; i++)
			result *= x;
		if(n < 0)
			return 1 / result;
		return result;
	}
	
	 
	
	public static void main(String[] args){
		double x = -2;
		int n = 0;
		PowXN p = new PowXN();
		System.out.println(p.pow(x, n) + ", " + p.powIterative(x, n));
	}
}
