package com.array.string;

public class SearchA2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length<=0 || matrix[0].length<=0) return false;
		int m = matrix.length;
		int n = matrix[0].length;
		
		return searchMatrix(matrix, m, n, 0, m*n-1, target); 

    }
	public boolean searchMatrix(int[][] matrix, int m, int n, int start, int end, int target){
		if(start>end) return false;
		int mid = (start + end)/2;
		int row = mid/n; 
		int col = mid - row*n;
		if(matrix[row][col] == target){
			return true;
		}
		else if(matrix[row][col] > target){
			return searchMatrix(matrix, m, n, start, mid-1, target);
		}
		else{
			return searchMatrix(matrix, m, n, mid+1, end, target);
		}
	}

}
