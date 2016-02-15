package com.math;

public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 1000021;
		PalindromeNumber obj = new PalindromeNumber();
		System.out.println(obj.isPalindrome(input));

	}
	public boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		
		// get the number of digits of x
		int div = 1;
		while(x / div >= 10)
			div *= 10;
		
		
		while(x > 0){
			if(x / div != x % 10)
				return false;
			x = (x % div) / 10;
			div /= 100;
		}
		
		return true;
	}

}
