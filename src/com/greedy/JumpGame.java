package com.greedy;

public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canJump(int[] A) {
		if(A==null || A.length<=0) return true;
		int maxCover = A[0];
		int n = A.length;
		for(int i = 0; i<=maxCover; i++){
			if(i+A[i]>maxCover){
				maxCover = i+A[i];
			}
			if(maxCover>=n-1){ return true;}
		}
		return false;
	}

}
