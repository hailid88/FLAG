package com.binarysearch;

public class SearchForARange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] searchRange(int[] A, int target) {
        if(A == null || A.length <= 0){
            int[] rst = new int[2];
            rst[0] = -1;
            rst[1] = -1;
            return rst;
        }
            
        return searchRange(A, target, 0, A.length - 1);
    }
    
    public int[] searchRange(int[] A, int target, int left, int right){
        int[] rst = new int[2];
        if(left > right){
            rst[0] = -1;
            rst[1] = -1;
            return rst;
        }
        
        int mid = (left + right) / 2;
        if(A[mid] == target){
            rst[0] = mid;
            rst[1] = mid;
            while(mid - 1 >= 0 && A[mid - 1] == target){
                mid--;
            }
            rst[0] = mid;
            mid = rst[1];
            while(mid + 1 < A.length && A[mid + 1] == target){
                mid++;
            }
            rst[1] = mid;
            return rst;
        }
        else if(A[mid] < target)
            return searchRange(A, target, mid + 1, right);
        else
            return searchRange(A, target, left, mid - 1);
    }

}
