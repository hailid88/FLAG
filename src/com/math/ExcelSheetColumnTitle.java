package com.math;

import java.util.HashMap;
import java.util.Stack;

public class ExcelSheetColumnTitle {

	/**
	 * @param args
	 * Given a non-zero positive integer, return its corresponding column title as appear in an Excel sheet.

		For example:
	
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int n = 3;
	    String result = convertToTitle(27);
	    System.out.println(result);

	}
	 public static String convertToTitle(int n) {
		 	if(n<=0) return null;

	        StringBuffer result = new StringBuffer();
	        while(n>0){
	        	if(n%26 ==0){
		        	result.append('Z');
		        	n--;
		        }else{
		        	result.append((char)('A' + n%26 - 1));
		        	
		        }
	        	n=n/26;
	        }
	       
	        return result.reverse().toString();
	 }
	 
	 

}
