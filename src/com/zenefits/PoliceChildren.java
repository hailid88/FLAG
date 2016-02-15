package com.zenefits;

import java.util.LinkedList;
import java.util.Queue;

public class PoliceChildren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,0,0}, {0,0,0}, {0,0,1}};
		int[][] result = distToPolice(matrix);
		for(int i = 0; i<result.length; i++){
			for(int j = 0; j<result[0].length; j++){
				System.out.print(result[i][j]);
				System.out.print(", ");
			}
			System.out.println();
		}

	}
	
	//this is dp solution. 
	public static int[][] distToPolice(int[][] matrix){
		if(matrix==null || matrix.length<=0 || matrix[0].length<=0) return null;
		int m = matrix.length;
		int n= matrix[0].length;
		int[][] result = new int[n][n];
		if(m!=n) throw new RuntimeException("The dimension is incorrect");
		if(matrix[0][0]==1) {
			result[0][0] = 0;
		}
		else if(matrix[0][0]==2){
			result[0][0] = -1; 
		}
		else{
			result[0][0] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i<n; i++){
			if(matrix[0][i] == 1) {
				result[0][i] = 0;
			}
			else if(matrix[0][i]==2){
				result[0][i] = -1;
			}
			else{
				if(result[0][i-1]==-1 || result[0][i-1]==Integer.MAX_VALUE)
					result[0][i] = Integer.MAX_VALUE;
				else{
					result[0][i] = result[0][i-1] + 1;
				}
			}
		}
		
		
		for(int i = 1; i<n; i++){
			if(matrix[i][0] == 1) {
				result[i][0] = 0;
			}
			else if(matrix[i][0]==2){
				result[i][0] = -1;
			}
			else{
				if(result[i-1][0]==-1 || result[i-1][0]==Integer.MAX_VALUE)
					result[i][0] = Integer.MAX_VALUE;
				else{
					result[i][0] = result[i-1][0] + 1;
				}
				
			}
		}
		
		
		for(int i = 1; i<n; i++){
			for(int j = 1; j<n; j++){
				if(matrix[i][j]==1){
					result[i][j] = 0;
				}
				else if (matrix[i][j]==2){
					result[i][j] = -1;
				}
				else{
					
					if(result[i-1][j]==-1 || result[i][j-1]==-1){
						result[i][j] = (Math.max(result[i-1][j], result[i][j-1])==Integer.MAX_VALUE )?Integer.MAX_VALUE:Math.max(result[i-1][j], result[i][j-1]) +1;
					}
					else
					{
						result[i][j] = (Math.min(result[i-1][j], result[i][j-1])==Integer.MAX_VALUE )?Integer.MAX_VALUE:Math.min(result[i-1][j], result[i][j-1]) +1;
					}
				}
			}
		}
		
		
		
		for(int i = n-2; i>=0; i--){
			if(result[n-1][i]!=0 && result[n-1][i]!=-1){
				if(result[n-1][i+1]!=Integer.MAX_VALUE && result[n-1][i+1]!=-1){
					result[n-1][i] = Math.min(result[n-1][i+1] + 1, result[n-1][i]);
				}
			}
		}
		
		
		for(int i = n-2; i>=0; i--){
			if(result[i][n-1]!=0 && result[i][n-1]!=-1){
				if(result[i+1][n-1]!=Integer.MAX_VALUE){
					result[i][n-1] = Math.min(result[i+1][n-1] + 1, result[i][n-1]);
				}
				
			}
		}
		
		
		for(int i= n-2; i>=0; i--){
			for(int j = n-2; j>=0; j--){
				
				if(result[i][j+1]!=-1 && result[i][j+1]!=Integer.MAX_VALUE){
					if(result[i+1][j] == -1 || result[i+1][j] == Integer.MAX_VALUE){
						result[i][j]= Math.min(result[i][j], result[i][j+1]+1);
					}
					else{
						result[i][j]= Math.min(result[i][j], Math.min(result[i+1][j], result[i][j+1])+1);
					}
				}
				else{
					if(result[i+1][j] != -1 && result[i+1][j] != Integer.MAX_VALUE){
						result[i][j]= Math.min(result[i][j], result[i+1][j]+1);
					}
				}
			}
			
		}
		
		
		for(int i= n-1; i>=0; i--){
			for(int j = n-1; j>=0; j--){
				if(result[i][j] == Integer.MAX_VALUE){
					result[i][j] = -1;
				}
			}
			
		}
			
		return result;
	}
	
	

}
