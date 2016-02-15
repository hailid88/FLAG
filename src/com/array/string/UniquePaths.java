package com.array.string;

public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//as it will time exceeded by simply use Fibnacci like algorithm. So we need to use
	//dynamic programming to solve it. 
	 public int uniquePaths(int m, int n) {
		 	if(m<0 || n<0) return 0;
		 	if(m==0 && n==0) return 1;
	        if((n==0) ^(m==0)) return 1;
	        int[][] pN = new int[m][n];
	        pN[0][0] = 0;
	        for(int i = 1; i<m; i++){
	        	pN[i][0] = 1;
	        }
	        for(int j=1; j<n; j++){
	        	pN[0][j] =1;
	        }
	        for(int i = 1; i<m; i++){
	        	for(int j = 1; j<n; j++){
	        		pN[i][j] = pN[i-1][j] + pN[i][j-1];
	        	}
	        }
	        return pN[m-1][n-1];
    }

}
