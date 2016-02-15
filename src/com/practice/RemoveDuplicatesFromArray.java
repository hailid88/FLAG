package com.practice;

public class RemoveDuplicatesFromArray {
	
	public int removeDuplicates(int[] A) {
		int len = 0;
		int iLen = A.length;
		int j = 0;
		for(int i = 0; i < iLen; i++){
			if(j == 0 || A[j-1] != A[i]){
				A[j++] = A[i];
				len++;
			}
		}
		if(len < iLen)
			A[len] = '\0';
		return len;
    }

	public static void main(String[] args) {
		RemoveDuplicatesFromArray rdfa = new RemoveDuplicatesFromArray();
		int[] A = new int[3];
		A[0] = 1;
		A[1] = 1;
		A[2] = 2;
		System.out.println(rdfa.removeDuplicates(A));
	}

}
