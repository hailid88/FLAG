package com.array.string;

public class FindPeakElement {

	/**
	 * @param args
	 * 
	 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -¡Þ.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {9,8,7,6,3,2,8,4};
		FindPeakElement obj = new FindPeakElement();
		System.out.println(obj.findPeakElement(num));

	}
	
	public int findPeakElement2(int[] num){
		if(num == null || num.length < 1) {
	        return -1;
	    }
	    int start = 0;
	    int end = num.length - 1;
	    int mid;
	    long left, right;

	    while(start <= end) {
	        mid = (start + end)/2;
	        left = mid == 0 ? (long)Integer.MIN_VALUE - 1 : num[mid - 1];
	        right = mid == num.length - 1 ? (long)Integer.MIN_VALUE - 1: num[mid + 1];

	        if(left < num[mid] && right < num[mid]) {
	            return mid;
	        }
	        if(left < right) {
	            start = mid + 1;
	        }
	        else {
	            end = mid - 1;
	        }
	    }
	    return -1;
	}
	
	 public int findPeakElement(int[] num) {
	        if(num==null || num.length<=0) return Integer.MIN_VALUE;
	        int n = num.length;
	        int l = Integer.MIN_VALUE;
	        int r = Integer.MIN_VALUE;
	        for(int i=0; i<n; i++){
	        	if(i>=1 && i<n-1){
	        		l = num[i-1];
	        		r = num[i+1];
	        		
	        	}
	        	if(i==0){
	        		l = Integer.MIN_VALUE;
	        		r = num[i+1]; 
	        	}
	        	if(i==n-1){
	        		r = Integer.MIN_VALUE;
	        		l = num[i-1];
	        	}
	        	if(num[i]>l && num[i]>r){
	        		return num[i];
	        	}
	        }
	        return Integer.MIN_VALUE;
    }

}
