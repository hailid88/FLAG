package com.dynamicprogramming;

public class DungeonGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] A = new int[row][col];
    
        // 1. when the knight reached the bottom right corner
        //initialization. 
        A[row-1][col-1] = (dungeon[row-1][col-1] > 0) ? 1 : (1 - dungeon[row-1][col-1]);
    
        // 2. in the last column, bottom-up;
        for(int i = row - 2; i >= 0; --i) {
            int aboveValue = A[i+1][col-1] - dungeon[i][col-1];
            A[i][col-1]  = aboveValue > 0 ? aboveValue : 1;
        }
    
        // 3. in the last row, from right to left
        for(int j = col - 2; j >= 0; --j) {
            int leftValue = A[row-1][j+1] - dungeon[row-1][j];
            A[row-1][j]  = leftValue > 0 ? leftValue : 1;
        }
    
     // 4. in other areas, from bottom-right to upper-left
        for(int i = row - 2; i >=0; i--) {
            for(int j = col - 2; j >= 0; j--) {
                int rightValue = (A[i][j+1]-dungeon[i][j] > 0) ? A[i][j+1]-dungeon[i][j] : 1;
                int belowValue = (A[i+1][j]-dungeon[i][j] > 0) ? A[i+1][j]-dungeon[i][j] : 1;
                A[i][j] = Math.min(rightValue, belowValue);
            }
        }
        return A[0][0];

    }

}
