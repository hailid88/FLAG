package com.tellapart;

public class Dilate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[5][5];
		grid[3][1] =1;
		grid[2][3] =1;
		for(int i = 0; i<5; i++){
			for(int j = 0; j<5; j++){
				System.out.print(grid[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		Dilate obj = new Dilate();
		obj.dilate(grid, 2);
		for(int i = 0; i<5; i++){
			for(int j = 0; j<5; j++){
				System.out.print(grid[i][j] + ", ");
			}
			System.out.println();
		}
		

	}
	
	public void dilate(int[][] grid, int k){
		if(grid==null||grid.length<=0||grid[0].length<=0||k<=0) return;
		int m = grid.length;
		int n = grid[0].length;
		//first record the positions are "1".
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(grid[i][j]==1){
					int minP = Math.max(i-k, 0);
					int maxP = Math.min(i+k, m);
					int minQ = Math.max(i-k, 0);
					int maxQ = Math.min(i+k, n);
					for(int p = minP; p<maxP; p++){
						for(int q = minQ; q<maxQ; q++){
							if((Math.abs(p-i) + Math.abs(q-j)<=k) && grid[p][q]!=1){
								grid[p][q] = 2;
							}
						}
					}
				}
			}
		}
		
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(grid[i][j]==2)
					grid[i][j] = 1;
			}
		}

	}

}
