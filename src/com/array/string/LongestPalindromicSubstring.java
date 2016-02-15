package com.array.string;

public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abaabcc";
		
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		String result = obj.longestPalindrome(input);
		System.out.println(result);
	}
	
	
	public String longestPalindrome(String s) {
		if(s==null || s.length()<=0) return "";
		int n = s.length();
		char[] a = s.toCharArray();
		boolean[][] P = new boolean[n][n];
		for(int i=0; i<n; i++){
			P[i][i] = true;
		}
		
		int maxLen = 1;
		String maxSub = s.substring(0,1);
		for(int j = 1; j < n; j++){
			for(int i = 0; i < j; i++){
				if(a[i]==a[j]){
					if(j-i<2 || P[i+1][j-1]){
						P[i][j] = true;
						if(j-i+1>maxLen){
							maxSub = s.substring(i, j+1);
							maxLen = j-i+1;
						}
					}
				}
			}
		}
		
		return maxSub;
//		
//		int maxLen = 0;
//		String maxSub = "";
//		for(int i = 0; i<n; i++){
//			for (int j = n-1; j>=i; j--){
//				if(P[i][j]){
//					if(j-i+1 > maxLen){
//						maxLen = j-i+1;
//						maxSub = s.substring(i, j+1);
//					}
//					
//				}
//			}
//		}
		
//		return maxSub;
    }

}
