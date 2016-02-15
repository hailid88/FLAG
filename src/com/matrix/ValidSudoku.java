package com.matrix;

public class ValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isValidSudoku(char[][] board) {
        int rowNum = board.length;
        int colNum;
        if(rowNum>0){
            colNum = board[0].length;
        }
        else{
            return true;
        }
        if(rowNum!=9 || colNum!=9){
            return false;
        }
        
        //row
        for(int i = 0; i<9; i++){
            boolean[] countNum = new boolean[9];
            for(int j = 0; j<9; j++){
                if(board[i][j]!='.'){
                    int num = board[i][j] - '0';
                    if(num < 1 || num > 9){
                        return false;
                    }
                    else{
                       if(countNum[num-1])
                       {
                           return false;
                       }
                       else {countNum[num-1] = true;}
                    }
                }
            }
        }
        
        //col
         for(int i = 0; i<9; i++){
            boolean[] countNum = new boolean[9];
            for(int j = 0; j<9; j++){
                if(board[j][i]!='.'){
                    int num = board[j][i] -'0';
                     if(num < 1 || num > 9){
                        return false;
                    }
                    else{
                        if(countNum[num-1])
                       {
                           return false;
                       }
                       else {countNum[num-1] = true;}
                    }
                }
            }
        }
        
        
        //submatrix
        for(int i =0; i<9; i+=3){
            for(int j= 0; j<9; j+=3){
                boolean[] countNum = new boolean[9];
                for(int l=i; l<i+3 && l<9; l++){
                    for(int k=j; k<j+3 && k<9; k++){
                        if(board[l][k]!='.')
                        {
                            int num = board[l][k] - '0';
                            if(num < 1 || num > 9){
                                return false;
                            }
                            else{
                                if(countNum[num-1]){
                                    return false;
                                }else{
                                    countNum[num-1] = true;
                                }
                                
                            }
                        }
                    }
                }
            }
        }

         return true;
    }

}
