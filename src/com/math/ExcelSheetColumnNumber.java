package com.math;

public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int titleToNumber(String s) {
		int result = 0;
		if(s==null || s.length()<=0) return result;
		int n = s.length();
		for(int i = 0; i<n; i++){
			result = result*26+ (s.charAt(i)-'A' +1);
		}
		return result;
    }

}
