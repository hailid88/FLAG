package com.palantir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicBox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	BufferedReader r = null;
        try{
            r = new BufferedReader(new InputStreamReader(System.in));
            String rowCol = r.readLine();  // read first line to get # of rows and # of cols
            String[] strs = (rowCol.trim()).split(" ");
            int m = Integer.parseInt(strs[0]), n = Integer.parseInt(strs[1]);
            if(m <= 0 || n <= 0)
            	throw new RuntimeException("invalid input: the number of rows or cols should be bigger than zero");
            char[][] magicBox = new char[m][n];
            for(int i = 0; i < m; i++){
            	String line = r.readLine(); // read each line and parse the data into magicBox
            	for(int j = 0; j < n; j++){
            		magicBox[i][j] = line.charAt(j);
            	} // for : j
            } // for : i
            
            // flip the col to get the max wish
            System.out.println(maxWishes(magicBox));
        } catch(IOException e){
            e.printStackTrace();
        }
//        finally{
//        	if(r!= null)
//        		r.close();
//        }

	}
	public static int maxWishes(char[][] board){
		int M = board.length;
		if(M<1 || M>100000) return -1;
		int N = board[0].length;
		if(N<1 || N>500) return -1;
		int maxWishNum = 0;
		for(int i = 0; i<M; i++){
			char[][] tmp = board;
			boolean[] T = new boolean[N];
			int count = 0;
			for(int j =0; j<N; j++){
				if(tmp[i][j]=='T'){
					count++;
				}
			}
			if(count>N-count){
				//the number of T is larger than P
				//then flip P instead of T. 
				tmp = flip(tmp, T, false);
			}
			else{
				//then flip T since it is smaller. 
				tmp = flip(tmp, T, true);
			}
			int currNum = getWishes(tmp);
			maxWishNum = Math.max(maxWishNum, currNum);
		}
		return maxWishNum;
	}
	
	
	public static int getWishes(char[][] board){
		boolean[] wishY = new boolean[board.length];
		int wishNum=0;
		for(int i = 0; i<board.length; i++){
			char first = board[i][0];
			int j;
			for( j=1; j<board[0].length; j++){
				if(board[i][j]!=first){
					wishY[i] = false;
					break;
				}
			}
			if(j==board[0].length){
				wishY[i]=true;
				wishNum++;
			}
		}
		
		return wishNum;
	}
		
	
	public static char[][] flip(char[][] board, boolean[] T, boolean flag){
		//flip the columns. 
		for(int j= 0; j<T.length; j++){
			if(T[j]==flag){
				for(int i = 0; i<board.length; i++){
					if(board[i][j] == 'T'){
						board[i][j] = 'P';
					}
					else{
						board[i][j] = 'T';
					}
				}
			}
		}
		return board;
	}

}
