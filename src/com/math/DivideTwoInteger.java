package com.math;

public class DivideTwoInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int divide(int dividend, int divisor) {
		if(divisor == 0)
			return Integer.MAX_VALUE;
		
		long denominator = Math.abs((long)divisor);
		long numerator = Math.abs((long)dividend);
		
		long rst = 0;
		while(numerator >= denominator){
			long numBits = 0;
			while(numerator >= (denominator << numBits)) // check the boundary
				numBits++; // after moving numBits left bits, denominator will be bigger than numerator
			rst += 1L << (numBits - 1);
			numerator -= denominator << (numBits - 1);
		}// while
		
		if(!((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)))
			rst = -rst;
		rst = rst > Integer.MAX_VALUE ? Integer.MAX_VALUE : rst;
		rst = rst < Integer.MIN_VALUE ? Integer.MIN_VALUE : rst;
		return (int) rst;
		
    }

}
