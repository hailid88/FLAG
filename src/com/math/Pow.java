package com.math;


public class Pow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double pow(double x, int n) {
        if(n == 0 || x == 0)
			return 1;
		if(n == 1)
			return x;
		if(n == -1)
			return 1/x;
		double v = pow(x, n/2);
		
		if(n % 2 == 0)
			return v * v;
		if(n < 0)
			return v * v / x;
		else
			return v * v * x;
    }
	

}
