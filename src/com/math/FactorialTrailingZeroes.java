package com.math;

public class FactorialTrailingZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		FactorialTrailingZeroes obj = new FactorialTrailingZeroes();
		System.out.println(obj.trailingZeroes(10));

	}
	
	
	/*
	 * O(log_5(N)) (base 5!) is faster than any polynomial. 
	 * You need no more than 14 iterations to get the result. 
	 * You just need to count how many times 5 appears in n! 
	 * during multiplication in different forms: 5, 25, 125, 625, ... . 
	 * when any 5 is multiplied by 2 (we have many of them) then we 
	 * get 0 at the end. That's it.
	 */
	public int trailingZeroes(int n){
		int r = 0;
		//just remember this rule. 
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
	}

}
