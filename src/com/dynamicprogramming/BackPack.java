package com.dynamicprogramming;

public class BackPack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 90;
		int[] A = {12,3,7,4,5,13,2,8,4,7,6,5,7};
		BackPack obj = new BackPack();
		int c = obj.backPack(m, A);
		System.out.println(c);

	}
	
	public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        int[][] dp = new int[n+1][m+1];
        for(int j = 0; j<=m; j++){
            for(int i = 1; i<=n; i++){
                if(A[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j-A[i-1]] + A[i-1], dp[i-1][j]);
                }
                else{
                	dp[i][j] = dp[i-1][j];
                	
                }
            }
        }
        return dp[n][m];
    }

}
