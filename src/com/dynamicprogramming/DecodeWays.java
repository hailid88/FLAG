package com.dynamicprogramming;

public class DecodeWays {

	/**
	 * @param args
	 * 
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "100";
		System.out.println(numDecodings(s));

	}
	
	public static int numDecodings(String s) {
		if(s==null || s.length()<=0) return 0;
		if(s.charAt(0)=='0') return 0;
		if(s.length()==1) return 1;
		int n = s.length();
		int f1 = 1;  //initialization: one character.
		int f2 = 1;
		int f3 = 0;
		for(int i=0; i<n; i++){
			f3 = 0;
			if(s.charAt(i)!='0'){
				f3 = f3+f1;
			}
			if(i>0){
				if(s.charAt(i-1)=='0' && s.charAt(i)=='0') return 0;
				int a = Integer.parseInt(s.substring(i-1, i+1));
				if(a<=26 && a>0 && s.charAt(i-1)!='0'){
					f3 = f3 + f2;
				}
			}
			f2= f1;
			f1= f3;
		}
		return f3;
		
    }

}
