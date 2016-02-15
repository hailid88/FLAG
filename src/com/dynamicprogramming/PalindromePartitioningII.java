package com.dynamicprogramming;

public class PalindromePartitioningII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abb";
		PalindromePartitioningII obj = new PalindromePartitioningII();
		int result = obj.minCut(s);

	}
	
	public int minCut(String s) {
		if(s==null || s.length()<=1) return 0;
		int n = s.length();
		boolean[][] P = new boolean[n][n];
		for(int i =0; i<n; i++){
			P[i][i] = true;
		}
		
		for(int i = n-2; i>=0; i--){
			for(int j = i+1; j<n; j++){
				if(s.charAt(i) == s.charAt(j)){
					if(j-i<=2 || P[i+1][j-1]){
						P[i][j] = true;
					}
				}
			}
		}
		
		
		//here is for recording the cut number. 
		int[] d = new int[n+1];
		for(int i = n; i >= 0; i--)
			d[i] = n - i - 1;
		
		for(int i = n - 1; i >= 0; i--){
			for(int j = n-1; j >=i; j--){
				if(P[i][j]){
					d[i] = Math.min(d[i], 1 + d[j+1]);
				}
			} // for : j
		} // for : i
		
		return d[0];
		
	}

}
