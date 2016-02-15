package com.array.string;

public class JumpGameII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int jump(int[] A){
		if(A==null||A.length<=0) return 0;
		int n = A.length;
		int maxCover = A[0];
		int start = 0;
		int end = 0;
		int jumps = 0;
		while(end<n-1){
			jumps++;
			for(int i = start; i<=end; i++){
				maxCover = Math.max(maxCover, i+A[i]);
				if(maxCover>=n-1){
					return jumps;
				}
			}
			if(maxCover<=end) return -1;
			start = end+1;
			end = maxCover;
		}
		return jumps;
	}

}
