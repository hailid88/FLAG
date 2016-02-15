package com.array.string;

public class StringToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -2147483648;
		System.out.println(x);

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
		
		double result = 0;
		
		for(; left<=right; left++){
			if(!(str.charAt(left)>='0' && str.charAt(left)<='9')){
				break;
			}else{
				result = result*10 + (str.charAt(left)-'0');
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
