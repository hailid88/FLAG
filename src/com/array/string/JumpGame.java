package com.array.string;

public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,2,1,0,4};
		JumpGame obj = new JumpGame();
		System.out.println(obj.canJump(A));
	}
	
	public boolean canJump(int[] A) {
		if(A==null || A.length<=0) return true;
		int n = A.length;
		int maxCover = 0;
		
		for(int i = 0; i <= maxCover && i < n; i++){
			maxCover = Math.max(A[i]+i, maxCover);
			if(maxCover >= n - 1)
				return true;
		}
		return false;
    }

}
