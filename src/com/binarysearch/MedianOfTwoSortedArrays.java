package com.binarysearch;

public class MedianOfTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public double findMedianSortedArrays(int[] A, int[] B){
		int lenA = A.length;
		int lenB = B.length;
		int mid = (lenA+lenB)/2;
		if((lenA+lenB)%2==0){
			return (getKth(A, 0, lenA-1, B, 0, lenB-1, mid) + getKth(A, 0, lenA-1, B, 0, lenB-1, mid+1))/2;
		}
		else{
			return getKth(A, 0, lenA-1, B, 0, lenB-1, mid+1);
		}
	}
	
	public double getKth(int[] A, int startA, int endA, int[] B, int startB, int endB, int k){
		int curLenA = endA-startA+1;
		int curLenB = endB-startB+1;
		
		if(curLenA<=0){
			return B[startB+k-1];
		}
		if(curLenB<=0){
			return A[startA+k-1];
		}
		if(k<=1) return Math.min(A[startA], B[startB]);
		int midA = (startA+endA)/2;
		int midB = (startB+endB)/2;
		
		int halfLenA = midA-startA+1;
		int halfLenB = midB-startB+1;
		if(halfLenA+halfLenB>k){
			if(A[midA]>B[midB]){
				return getKth(A, startA, midA-1, B, startB, endB, k);
			}
			else{
				return getKth(A, startA, endA, B, startB, midB-1, k);
			}
		}
		else{
			if(A[midA]>B[midB]){
				return getKth(A, startA, midA, B, midB+1, endB, k-halfLenB);
			}
			else{
				return getKth(A, midA+1, endA, B, startB, endB, k-halfLenA);
			}
		}
	}

}
