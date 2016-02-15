package com.array.string;

public class FindMinimumInRotatedSortedArray {

	/**
	 * @param args
	 * There is no duplication. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findMin(int[] num) {
	        //use binary search. 
		 if(num==null || num.length<=0) return Integer.MAX_VALUE;
		 int n= num.length;
		 
		 int result = findMin(num, 0, n-1);
		 return result;
	}
	 
	 public int findMin(int[] num, int l, int r){
		 int mid = (l+r)/2;
		 
		 while(l+1 < r){ //at least three. 
			 if(num[mid]<num[r]){
				 return findMin(num, l, mid);
			 }
			 else{
				return findMin(num, mid, r);
			 }
		 }
		 return Math.min(num[l], num[r]); 
	 }

}
