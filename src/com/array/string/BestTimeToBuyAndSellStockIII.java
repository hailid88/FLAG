package com.array.string;

public class BestTimeToBuyAndSellStockIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProfit(int[] prices) {
		int pLen = prices.length;
        if(prices==null || pLen<=0) return 0;
        int[] lMP = new int[pLen];
		int lMin = prices[0];
		lMP[0] = 0;
		for(int i = 1; i<pLen; i++){
			lMP[i] = Math.max(lMP[i-1], prices[i] - lMin);
			lMin = Math.min(prices[i], lMin);
		}
		int[] rMP = new int[pLen];
		int rMax = prices[pLen-1];
		rMP[pLen-1]=0;
		for(int i= pLen-2; i>=0; i--){
			rMP[i] = Math.max(rMP[i+1], rMax-prices[i]);
			rMax = Math.max(prices[i], rMax);
		}
		
        
        int maxProfit = lMP[0] + rMP[0];
        
        for(int i = 1; i<pLen; i++){
        	maxProfit = Math.max(maxProfit, lMP[i] + rMP[i]);
        }
        return maxProfit;
    }

}
