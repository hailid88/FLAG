package com.dynamicprogramming;

public class UniqueBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numTrees(int n){
		//p record the number of Trees by 0, ..., n
		int[] p = new int[n+1];
		p[0] = 1;
		p[1] = 1;
		
		for(int j=2; j<=n; j++){
			for(int i=1; i<=j; i++){
				p[j] += p[i-1]*p[j-i];
			}
		}
		
		return p[n];
		
		
		
	}

}
