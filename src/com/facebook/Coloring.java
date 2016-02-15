package com.facebook;

public class Coloring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,1,1,1,1,1},{1,1,1,0,0,1},{1,0,0,1,1,0}};
		Coloring obj = new Coloring();
		obj.dfs(matrix, 2, 1);
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j]);
				System.out.print(", ");
			}
			System.out.println();
		}
	}
	
	public void dfs(int[][] matrix, int x, int y){
		if(matrix==null ||matrix.length<=0 ||matrix[0].length<=0) return;
		if(x<0||x>=matrix.length||y<0||y>=matrix[0].length) return;
		if(matrix[x][y]==1) return;
		matrix[x][y] =1;
		dfs(matrix, x-1, y);
		dfs(matrix, x+1, y);
		dfs(matrix, x, y-1);
		dfs(matrix, x, y+1);
	}

}
