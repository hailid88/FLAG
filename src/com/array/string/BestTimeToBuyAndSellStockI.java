package com.array.string;

public class BestTimeToBuyAndSellStockI {

	/**
	 * @param args
	 * 
Say you have an array for which the ith element is the price of a given stock on day i. 
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	 public int maxProfit(int[] prices) {
	        int len = prices.length;
	        if(len<2) return 0;
	        int min = prices[0];
	        int profit = 0;
	        for(int i = 1; i<len; i++){
	            if(prices[i]-min > profit){
	                profit = prices[i]-min;
	            }
	            if(min > prices[i]){
	                min = prices[i];
	            }
	        }
	        
	        return profit;
	 }

}
