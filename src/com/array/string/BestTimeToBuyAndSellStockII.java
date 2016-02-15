package com.array.string;

public class BestTimeToBuyAndSellStockII {

	/**
	 * @param args
	 * 
	 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
        //this is an greedy algorithm. 
        int profit =0;
        int len = prices.length;
        if(len<2) return 0;
        for (int i =0; i<len-1; i++){
            if(prices[i+1]>prices[i]){
                profit = profit + prices[i+1]-prices[i];
            }
            
        }
        return profit;
    }

}
