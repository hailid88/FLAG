package com.matrix;

public class NQueensII {

	/**
	 * @param args
	 * 
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

Complexity O(n!).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static int sum;
	
    public int totalNQueens(int n) {
        sum = 0;
        int[] usedColumns = new int[n];
        placeQueen(usedColumns, 0);
        return sum;

    }
    public void placeQueen(int[] usedColumns, int row) {
        int n = usedColumns.length;
        
        if (row == n) {
            sum ++;
            return;
        }
        //i means the column index. 
        //usedColumns is used to record the column index for a specific row. 
        //recursive solution. 
        for (int i = 0; i < n; i++) {
            if (isValid(usedColumns, row, i)) {
                usedColumns[row] = i;
                placeQueen(usedColumns, row + 1);
            }
        }
    }
    public boolean isValid(int[] usedColumns, int row, int col) {
        for (int i = 0; i < row; i++) {
        	// in the same column. 
            if (usedColumns[i] == col) {
                return false;
            }
            
            //diagonal. 
            if ((row - i) == Math.abs(col-usedColumns[i])) {
                return false;
            }
        }
        return true;
    }

}
