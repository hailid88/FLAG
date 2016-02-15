package com.ea;

public class IncreaseMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,3,5,7,9}, {2,4,6,8,10}, {4,5,7,9,11}};
		int m = matrix.length;  //row
		int n = matrix[0].length; //column
		IncreaseMatrix obj = new IncreaseMatrix();
		int target = 1;
		System.out.println(obj.findTarget(matrix, 0, m-1, 0, n-1, target));
		System.out.println(obj.findTarget(matrix, target));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.pow(2, 31)-1);
		int x = -3;
		System.out.println(Integer.toBinaryString(x));
	}
	
	//recursive way. 
	public boolean findTarget(int[][] matrix, int startRow, int endRow, int startCol, int endCol, int target){
		if(startRow>=matrix.length || endCol<0) return false;
		
		if(matrix[startRow][endCol]==target) return true;
		else if(matrix[startRow][endCol]>target){
			return findTarget(matrix, startRow, endRow, startCol, endCol-1, target);
		}
		else{
			return findTarget(matrix, startRow+1, endRow, startCol, endCol, target);
		}
	}
	
	//iterative way. 
	public boolean findTarget(int[][] matrix, int target){
		int m = matrix.length;  //row
		int n = matrix[0].length; //column
		int i = 0;
		int j = n-1;
		while(i<m && j>=0){
			if(matrix[i][j]==target) return true;
			else if(matrix[i][j]>target){
				j--;
			}
			else{
				i++;
			}
		}
		return false;
	}

}
