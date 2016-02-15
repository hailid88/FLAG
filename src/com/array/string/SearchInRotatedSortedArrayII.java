package com.array.string;

public class SearchInRotatedSortedArrayII {

	/**
	 * @param args
	 * Follow up for "Search in Rotated Sorted Array":
		What if duplicates are allowed?

		Would this affect the run-time complexity? How and why?

		Write a function to determine if a given target is in the array.
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean search(int[] A, int target) {
		return search(A, 0, A.length-1, target);
	}
	
	public boolean search(int[] A, int start, int end, int target){
		if(start>end) return false;
		int mid = (start + end)/2;
		if(A[mid] == target) return true;
		if(A[start]==target || A[end]== target) return true;
		if(A[mid]>A[start]){  //the left side is in increasing order. 
			if(A[mid]>target && A[start]<target){
				return search(A, start+1, mid-1, target);
			}
			else{
				return search(A, mid+1, end-1, target);
			}
		}
		else if(A[mid]<A[start]){ //the right side is in increasing order. 
			if(A[mid]<target && A[end]>target){
				return search(A, mid+1, end-1, target);
			}
			else{
				return search(A, start+1, mid-1, target);
			}
		}
		else{ //the mid and the start is the same. 
			return search(A, start+1, end, target); 
		}
	}
	

}
