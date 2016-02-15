package com.linkedin;

public class Search2DMatrix {

	// search by pruning redundant information
	public boolean searchMatrixSimpleMoreComplex(int[][] matrix, int target) {
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return false;
        
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1; // search from the top right
        while(row < rows && col >= 0){
            if(matrix[row][col] == target){ 
                return true;
            } else if(matrix[row][col] > target)   // if it is bigger, then move left
                col--;
            else
                row++;  // if it is smaller, move down
        }
        
        return false;
    }
	
	
	// binary search, first search from rows, then search from cols
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
			return false;
		
		int rows = matrix.length, cols = matrix[0].length;
		int start = 0, end = rows - 1, mid = 0, col = 0;
		
		if(matrix[0][0] > target || matrix[rows - 1][cols - 1] < target)
			return false;
		
		// search in the rows
		while(start <= end){
			mid = (start + end) / 2;
			if(matrix[mid][col] == target)
				return true;
			else if(matrix[mid][col] > target){
				if(mid - 1 >= 0)
					end = mid - 1;
				else
					break;
			}  
			else if(matrix[mid][col] < target){
				if(mid + 1 <= rows - 1)
					start = mid + 1;
				else
					break;
			}
		} // while
		
		
		// search in the columns
		start = 0;
		end = cols - 1;
		while(start <= end){
			col = (start + end) / 2;
			if(matrix[mid][col] == target)
				return true;
			else if(matrix[mid][col] > target)
				end = col - 1;
			else
				start = col + 1;
		}
		
		return false;
	}
	
	public static void main(String[] args){
		int[][] matrix = { {1, 3, 5, 7},  {10, 11, 16, 20}, {23, 30, 34, 50} };
		
		Search2DMatrix searcher = new Search2DMatrix();
		int target = 8;
		System.out.println(searcher.searchMatrix(matrix, target) + ", " + 
				searcher.searchMatrixSimpleMoreComplex(matrix, target));
	}
}
