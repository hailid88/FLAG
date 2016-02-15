package com.matrix;
import java.util.*;


public class NQueens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens obj = new NQueens();
		int[] input = {2,1,0};
		
		

	}

	
public List<String[]> solveNQueens(int n) {
    	
    	List<String[]> result = new ArrayList<String[]>();
        
    	int[] usedColumns = new int[n];
        
    	placeQueen(usedColumns, 0, result);
        
        return result;

    }
    public void placeQueen(int[] usedColumns, int row, List<String[]> result) {
        
    	int n = usedColumns.length;
        
        if (row == n) {
            String[] tmpResult = colToString(usedColumns);
            result.add(tmpResult);
            return;
        }
        //i means the column index. 
        //usedColumns is used to record the column index for a specific row. 
        //recursive solution. 
        for (int i = 0; i < n; i++) {
            if (isValid(usedColumns, row, i)) {
                usedColumns[row] = i;
                placeQueen(usedColumns, row + 1, result);
            }
        }
    }
    
    public String[] colToString(int[] usedColumns){
    	int n = usedColumns.length;
    	String[] resl = new String[n];    	
    	for(int i = 0; i<n; i++){
    		StringBuffer tmp = new StringBuffer();
    		int col = usedColumns[i];
    		for(int j = 0; j<n; j++){
    			if(j==col){
    				tmp.append("Q");
    			}
    			else{
    				tmp.append(".");
    			}
    		}
    		resl[i] = tmp.toString();
    	}
    	return resl;
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
