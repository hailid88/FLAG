package com.math;

public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int reverse(int x){
		boolean positive = true;
		if(x<0){
			positive = false;
			x=-x;
		}
		if(x==0) return x;
		int result =0;
		while(x>0){
			//need to check the upper bound of the integer. 
			if(((double)result)*10 + x%10 > Integer.MAX_VALUE){
				return 0;
			}else{
			result = result*10+x%10;
			}
			x=x/10;
		}
		return positive?result:-result;
		
	}

}
