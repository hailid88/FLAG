package com.snapchat;

public class SodukuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void solveSudoku(char[][] board){
		if(board==null || board.length!=9 || board[0].length!=9) return;
		solve(board, 0, 0);
	}
	
	public boolean solve(char[][] board, int i, int j){
		if(j>=9) return solve(board, i+1, 0);
		if(i==9) return true;
		if(board[i][j]=='.'){
			for(char c='1'; c<='9'; c++){
				board[i][j] = c;
				if(isValid(board, i, j)){
					if(solve(board, i, j+1)){
						return true;
					}
				}
				board[i][j]= '.'; //reset back to '.', since previous does not work. 
			}
		}
		else{
			return solve(board, i, j+1);
		}
		return false;
	}
	
	public boolean isValid(char[][] board, int i, int j){
		//row.
		for(int k = 0; k<9; k++){
			if(k!=j && board[i][k] == board[i][j]){
				return false;
			}
		}
		
		//column
		for(int k = 0; k<9; k++){
			if(k!=i && board[k][j] == board[i][j]){
				return false;
			}
		}
		
		//submatrix
		// i/3
		// j/3
		for(int k = i/3*3; k<i/3*3+3; k++){
			for(int h = j/3*3; h<j/3*3+3; h++){
				if((k!=i || h!=j) && (board[k][h]==board[i][j])){
					return false;
				}
			}
		}
		
		return true;
	}

}
