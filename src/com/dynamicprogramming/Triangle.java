package com.dynamicprogramming;
import java.util.List;

public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle==null || triangle.size()<1) return 0;
		int n = triangle.size();
        List<Integer> lastRow = triangle.get(n-1);
        if(lastRow == null) return 0;
        
        int[] dp = new int[n];
        //initialization
        int j=0;
        
        for(int item:lastRow){
        	dp[j++] = item;
        }
        
        int layer = n-2;
        
        while(layer>=0){
        	List<Integer> currRow = triangle.get(layer);
        	if(currRow==null) return Integer.MAX_VALUE;
        	j = 0;
        	for(int item:currRow){
        		dp[j] = Math.min(dp[j], dp[j+1]) + item;
        		j++;
        	}
        	layer--;
        }
        return dp[0];
    }

}
