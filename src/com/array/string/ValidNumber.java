package com.array.string;

public class ValidNumber {

	/**
	 * Validate if a given string is numeric.
	 * Some examples:
	 * "0" => true
	 * " 0.1 " => true
	 * "abc" => false
	 * "1 a" => false
	 * "2e10" => true
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isNumber(String s){
		String afterTrim = s.trim();
		int len = afterTrim.length();
		if(len<1) return false;
		int start =0;
		if(afterTrim.charAt(0)=='+' || afterTrim.charAt(0)=='-'){
			 start = 1;
		}
		boolean num = false;
		boolean dot = false;
		boolean exp = false;
		for(; start<len; start++){
			char c = afterTrim.charAt(start);
			if(Character.isDigit(c)){
				num = true;
			}
			else if(c=='.'){
				if(exp||dot) return false;
				dot = true;
			}
			else if(c=='e'){
				if(exp||num == false) return false;
				exp = true;
				num = false;
			}
			else if(c == '+' || c =='-'){
				if(s.charAt(start-1)!='e') return false;
			}
			else{
				return false;
			}
		}
		return num;
	}
}
