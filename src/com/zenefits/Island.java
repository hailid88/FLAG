package com.zenefits;
import java.util.*;

public class Island {
	
	/*
	 * // 给定二维数组，表示一片海洋，1代表有岛，0代表没岛。返回相连岛屿的大小。

// Input:
//[["1", "0", "0", "1"],
// ["1", "0", "0", "1"],
// ["1", "1", "0", "0"]]
// Output:
// [4, 2]

// Input:
//[["1", "1", "1", "0"],
// ["1", "0", "1", "0"],
// ["1", "1", "1", "0"]]
// Output:
// [8]
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,0,0,1},{1,0,0,1},{1,1,0,0}};
		List<Integer> resls = islandArea(matrix);
		for(Integer resl:resls){
			System.out.println(resl);
		}

	}
	
	
	public static List<Integer> islandArea(int[][] matrix){
		List<Integer> resl = new ArrayList<Integer>();
		for(int i = 0; i<matrix.length; i++){
			for(int j= 0; j<matrix[0].length; j++){
				if(matrix[i][j]==1){
					resl.add(dfs(matrix, i, j));
				}
			}
		}
		return resl;
	}
	
	public static int dfs(int[][] matrix, int i, int j){
		matrix[i][j] = 2;
		int left=0, right=0, up=0, down=0;
		if(i-1>=0 && matrix[i-1][j]==1) {
			up = dfs(matrix, i-1, j);
		}
		
		if(i+1<matrix.length && matrix[i+1][j]==1){
			down = dfs(matrix, i+1, j);
		}
		if(j+1<matrix[0].length && matrix[i][j+1]==1){
			right = dfs(matrix, i, j+1);
		}
		if(j-1>=0 && matrix[i][j-1]==1){
			left = dfs(matrix, i, j-1);
		}
		return up+down+right+left+1;
	}
	
	

}
