package com.math;

import java.util.HashMap;

public class RomanToInt {

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = "DCXXI";
       int output = romanToInt(s);
       System.out.println(output);

	 }
	
	
	 public int romanToInt2(String s) {
			if(s == null)
				return 0;
			int len = s.length();
			if(len <= 0)
				return 0;
			int rst = 0;
			for(int i = 1; i < len; i++){
				if(cToInt(s.charAt(i)) > cToInt(s.charAt(i - 1)))
					rst -= cToInt(s.charAt(i - 1));
				else
					rst += cToInt(s.charAt(i - 1));
			}
			rst += cToInt(s.charAt(len - 1));
			return rst;
	  }
		
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
		
		public static int romanToInt(String s){
			
	        HashMap<String, Integer> stand =  new HashMap<String, Integer>();
	        stand.put("I", 1);
	        stand.put("V", 5);
	        stand.put("X", 10);
	        stand.put("L", 50);
	        stand.put("C", 100);
	        stand.put("D", 500);
	        stand.put("M", 1000);
	        
	        String reverse = new StringBuffer(s).reverse().toString();
	
	        int out = stand.get(reverse.substring(0, 1));
	        for (int i = 1; i <reverse.length(); i++) {
	            if (stand.get(reverse.substring(i, i+1)) < stand.get(reverse.substring(i-1, i))) {
	                out -= stand.get(reverse.substring(i, i+1));                   
	            }
	            else
	                out += stand.get(reverse.substring(i, i+1));
	        }
	
	            return out;
		}

}
