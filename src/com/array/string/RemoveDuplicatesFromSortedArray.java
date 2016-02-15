package com.array.string;

public class RemoveDuplicatesFromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] A){
		if(A.length<=1) return A.length;
        int i = 0;
        int j;
        for(j=1; j<A.length; j++){
            if(A[i]!=A[j]){
                i++;
                A[i]=A[j];
            }
        }
        return i+1;
	}

}
