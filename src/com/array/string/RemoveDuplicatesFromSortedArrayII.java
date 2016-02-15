package com.array.string;

public class RemoveDuplicatesFromSortedArrayII {

	/**
	 * @param args
	 * 
	 * Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array A = [1,1,1,2,2,3],
	
	Your function should return length = 5, and A is now [1,1,2,2,3].
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,1};
		System.out.println(removeDuplicates(A));

	}
	public static int removeDuplicates(int[] A) {
        if(A == null || A.length <= 0)
			return 0;
		if(A.length <= 2) return A.length;
		
		int j = 1;
		for(int i = 2; i < A.length; i++){
			if(A[i] != A[j] || A[i] != A[j - 1])
				A[++j] = A[i];
		}
		return j+1;
    }

}
