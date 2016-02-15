package com.math;

public class StringToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int atoi(String str){
		
		//first remove all the spaces from in the left and right.
		int strLen = str.length();
		if(strLen<=0){
			return 0;
		}
		int left = 0; 
		int right = strLen-1;
		
		
		while(str.charAt(left)==' '){
			left++;
		}
		while(str.charAt(right)==' '){
			right--;
		}
		
		//left is the start;
		//right is the end. 
		if(left>right){
			return 0;
		}
		
		boolean positive = true;
		if(str.charAt(left)=='-' || str.charAt(left)=='+'){
			if(str.charAt(left)=='-'){
				positive = false;
			}
			left++;
		}
		
		double result = 0;   //pay attention to the upper bound and lower bound of the result. 
		
		for(; left<=right; left++){
		    if(Character.isDigit(str.charAt(left))){
		        result = result*10 + (str.charAt(left)-'0');
		    }
		    else{
		        break;
		    }
		}
		
		if(!positive) result = -result;
		
		if(result > Integer.MAX_VALUE){
		    return Integer.MAX_VALUE;
		}
		
		if(result<Integer.MIN_VALUE){
		    return Integer.MIN_VALUE;
		}
		
		return (int)result;
		
		
	}

}
