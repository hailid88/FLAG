package com.array.string;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
	 */
	public boolean exist(char[][] board, String word) {
        // boundary check
    	if(board== null){
    		if(word == null)
    			return true;
    		return false;
    	}
    	if(word == null)
    		return false;
    	int rows = board.length, len = word.length();
    	if(len <= 0)
    		return false;
    	if(rows <= 0)
    		return false;
    	int cols = board[0].length;
    	if(cols <= 0)
    		return false;
    	
    	// recursively check
    	int rowIdx = 0, colIdx = 0, wordIdx = 0;
    	boolean isExist  = false;
    	boolean[][] visitMatrix;
    	for(rowIdx = 0; rowIdx < rows; rowIdx++){
    		for(colIdx = 0; colIdx < cols; colIdx++){
    			if(board[rowIdx][colIdx] == word.charAt(wordIdx)){
    				visitMatrix = new boolean[rows][cols];
    				visitMatrix[rowIdx][colIdx] = true;
    				isExist = rCheck(board, word, len, rows, cols, rowIdx, colIdx, wordIdx + 1, visitMatrix, -1);
    				if(isExist)
    					return true;
    			} // if
    		} // for
    	} // for
    	return false;
    }
    
    public boolean rCheck(char[][] board, String word, int len, int rows, int cols, 
    		int rowIdx, int colIdx, int wordIdx, boolean[][] visitMatrix, int dir){
    	if(wordIdx >= len)
    		return true;
    	
    	boolean isExist = false;
    	int currRowIdx=1;
    	int currColIdx=1;
    	for (int i = 1; i<=4; i++){
    		switch(i){
    		case 1: currRowIdx = rowIdx + 1; currColIdx = colIdx; break;
    		case 2: currRowIdx = rowIdx - 1; currColIdx = colIdx; break;
    		case 3: currRowIdx = rowIdx; currColIdx = colIdx+1; break;
    		case 4: currRowIdx = rowIdx; currColIdx = colIdx-1; break;
    		}
    		
    		if(currRowIdx < rows && currRowIdx>=0 && currColIdx < cols &&  currColIdx>=0 && !visitMatrix[currRowIdx][currColIdx]){
        		if(board[currRowIdx][currColIdx] == word.charAt(wordIdx)){
    				visitMatrix[currRowIdx][currColIdx] = true;
    				isExist = rCheck(board, word, len, rows, cols, currRowIdx, currColIdx, wordIdx+1, visitMatrix, 1);
    				if(isExist)
    	    			return true;
    	    		else
    	    			visitMatrix[currRowIdx][currColIdx] = false;		// reset
        		}
        	}
    		
    	}
        return false;
    }
    
    
    

}
