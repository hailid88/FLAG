package com.array.string;

public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isPalindrome(String s){
		s= s.toLowerCase();
		if(s==null || s.length()<=1) return true;
		int n = s.length();
		int left = 0;
		int right = n-1;
		while(left<right){
			while(!Character.isLetterOrDigit(s.charAt(left))){
				left++;
			}
			while(!Character.isLetterOrDigit(s.charAt(right))){
				right--;
			}
			if(left>right) return false;
			if(left == right) return true;
			if(s.charAt(left)!=s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}

}
