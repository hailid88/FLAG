package com.snapchat;

public class ValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidSudoku(char[][] board) {
		//check each row
		if(board==null) return false;
		int m = board.length;
		if(m<=0) return false;
		int n = board[0].length;
		if(n<=0 || m!=n) return false;
		//check each row. 
		for(int i=0; i<m; i++){
			boolean[] unique = new boolean[m+1];
			for(int j = 0; j<m; j++){
				if(board[i][j]=='.') continue;
				int k = board[i][j] -'0';
				if(unique[k]){
					return false;
				}
				else{
					unique[k]=true;
				}
			}
		}
		
		//check each column.
		for(int j=0; j<m; j++){
			boolean[] unique = new boolean[m+1];
			for(int i = 0; i<m; i++){
				if(board[i][j]=='.') continue;
				int k = board[i][j] -'0';
				if(unique[k]){
					return false;
				}
				else{
					unique[k]=true;
				}
			}
		}
		
		//check each submatrix.
		
		for(int i=0; i<m; i+=3){ //start row
			for(int j = 0; j<m; j+=3){  //start col
				boolean[] unique = new boolean[m+1];
				for(int k = 0; k<3; k++){
					for(int h = 0; h<3; h++){
						if(board[i+k][j+h]=='.') continue;
						int p = board[i+k][j+h] -'0';
						if(unique[p]){
							return false;
						}
						else{
							unique[p]=true;
						}
					}
				}
			}
		}
		
		return true;
	}

}
