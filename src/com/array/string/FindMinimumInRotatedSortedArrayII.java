package com.array.string;

public class FindMinimumInRotatedSortedArrayII {

	/**
	 * @param args
	 * There exists duplications. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findMin(int[] num) {
		
		if(num==null || num.length<=0) return Integer.MAX_VALUE;
		int n= num.length;
		if(num.length==1) return num[0];
		int result = findMin(num, 0, n-1);
		return result;
        
    }
	
	public int findMin(int[] num, int l, int r){
		
		int mid = (l+r)/2;
		if(l+1<r){
			if(num[mid]>num[r]){
				return findMin(num, mid+1, r);
			}
			else{
				
				if(num[mid]==num[r]){
					return findMin(num, l, r-1);     //33313;
				}
				else{
					return findMin(num, l, mid);
				}
			}
		}
		return Math.min(num[l], num[r]);
	}
	
//	public int findMin(int[] num) {
//        if(num == null || num.length <= 0)
//    		return -1;
//    	return findMin(num, 0, num.length - 1);
//    } // function
//    
//    
//    private int findMin(int[] A, int left, int right){
//    	if(left > right)
//    		return Integer.MAX_VALUE;
//    	int mid = (left + right) / 2;
//    	if(A[mid] > A[left])
//    		return Math.min(A[left], findMin(A, mid + 1, right));
//    	else if(A[mid] < A[left])
//    		return Math.min(A[mid], findMin(A, left, mid - 1));
//    	else{
//    		if(A[right] != A[left])
//    			return Math.min(A[mid], findMin(A, mid + 1, right));
//    		else
//    			return Math.min(A[mid], Math.min(findMin(A, mid + 1, right), findMin(A, left, mid - 1)));
//    	} // if - else
//    }

}
