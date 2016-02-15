package com.dynamicprogramming;

public class ClimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int climbStairs(int n){
		if(n<=1) return n;
		int f0=1;
		int f1=1;
		int f2=f1+f1;
		for(int i = 2; i<=n; i++){
			f2=f0+f1;
			f0=f1;
			f1=f2;
		}
		return f2;
	}

}
