package com.breathfirstsearch;
import java.util.Queue;
import java.util.LinkedList;

public class SurroundedRegions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		
		SurroundedRegions obj = new SurroundedRegions();
		obj.solve(board);
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(", ");
			}
			System.out.println();
		}

	}
	private Queue<Integer> rowQueue = new LinkedList<Integer>();
    private Queue<Integer> colQueue = new LinkedList<Integer>();
    
	public void solve(char[][] board) {
        if (board  ==  null || board.length <= 0 || board[0].length <= 0)
           return;
        
       // initialization
       int rowNum = board.length;
       int colNum = board[0].length;
       
       //the very outside circle is now go through, and with 'O' are already enqueued. 
       
       //up row
       for(int j=0; j<colNum; j++){
    	   if(board[0][j] == 'O'){
    		   bfs(board, 0, j);
    	   }
       }
       
       //bottom row
       for(int j=0; j<colNum; j++){
    	   if(board[rowNum-1][j]=='O'){
    		   bfs(board, rowNum-1, j);
    	   }
       }
       
       //left column 
       for(int i=1; i<rowNum-1; i++){
    	   if(board[i][0]=='O'){
    		   bfs(board, i, 0);
    	   }
       }
       
     //right column 
       for(int i=1; i<rowNum-1; i++){
    	   if(board[i][colNum-1]=='O'){
    		   bfs(board, i, colNum-1);
    	   }
       }
       
       
       
       //reset. 
       for(int i = 0; i<rowNum; i++){
    	   for(int j = 0; j<colNum; j++){
    		   if(board[i][j]=='O'){
    			   board[i][j] ='X';
    		   }
    		   if(board[i][j]=='P'){
    			   board[i][j] = 'O';
    		   }
    	   }
       }
    }
	
	public void fill(char[][] board, int i, int j){
		int row = board.length;
		int col = board[0].length;
		if(i<0 || i>=row || j<0 || j>=col || board[i][j]!='O'){
			return; 
		}
		else{
			rowQueue.add(i);
			colQueue.add(j);
			board[i][j] ='P';
		}
	}
	public void bfs(char[][] board, int i, int j){
		fill(board, i, j);
		while(!rowQueue.isEmpty()){
			int x = rowQueue.poll();
			int y = colQueue.poll();
			fill(board, x-1, y);
			fill(board, x+1, y);
			fill(board, x, y-1);
			fill(board, x, y+1);
		}
		
	}
	
	public void dfs(char[][] board, int i, int j){
		int row = board.length;
		int col = board[0].length;
		if(i<0 || i>=row || j<0 || j>=col || board[i][j]!='O') return;
		board[i][j]='P';
		dfs(board, i-1, j);
		dfs(board, i+1, j);
		dfs(board, i, j-1);
		dfs(board, i, j+1);
	}

}
