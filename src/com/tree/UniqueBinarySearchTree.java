package com.tree;

public class UniqueBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//from 1 to n, how many possible binary search tree are there. 
	public int numTrees(int n) {
		if(n<=0) return 0;
		int[] resl = new int[n+1];
		resl[0] = 1;
		resl[1] = 1;
		for(int j=2; j<=n; j++){
			for(int i=1; i<=j; i++){
				resl[j] += resl[i-1]*resl[j-i];
			}
		}
		return resl[n];
	}
}
