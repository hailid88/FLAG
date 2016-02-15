package com.array.string;

import java.util.ArrayList;

public class SetZeros {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		boolean[] row = new boolean[2];
		ArrayList<String>[] a = new ArrayList[10];
		a[0] = new ArrayList<String>();
		System.out.println(row[0]);

	}
	public int[][] setZeros(int[][] input){
		int N1 = input.length;
		int N2 = input[0].length;
		boolean[] row = new boolean[N1];
		boolean[] column = new boolean[N2];
		
		
		for (int i=0; i<input.length; i++){
			int j;
			for (j=0; j<input[0].length; j++){
				if(input[i][j]==0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for(int i = 0; i< input.length; i++){
			int j;
			for (j=0; j<input[0].length; j++){
				if(row[i]||column[j])
				{
					input[i][j]=0;
				}
				
			}
		}
		
		return input;
		
		
	}

}
