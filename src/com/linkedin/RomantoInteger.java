package com.linkedin;

public class RomantoInteger {

	final int cToInt(char c){
		switch(c){
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
	public int romanToInt(String s) {
		if(s == null)
			return 0;
		int len = s.length();
		if(len <= 0)
			return 0;
		int sum = 0, preNum, num;
		for(int i = 0; i < len; i++){
			preNum = cToInt(s.charAt(i));
			if(i == len - 1){
				sum += preNum;
				break;
			}
			num = cToInt(s.charAt(i + 1));
			if(num > preNum)
				sum -= preNum;
			else
				sum += preNum;
			
		}
		return sum;
	}
	
	public static void main(String[] args){
		String s = "IVVV";
		RomantoInteger r = new RomantoInteger();
		System.out.println(r.romanToInt(s));
	}
}
