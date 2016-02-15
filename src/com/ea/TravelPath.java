package com.ea;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TravelPath{

	public static void main(String[] args) {
		TravelPath obj = new TravelPath();
		try{
			obj.printResult(args[0]);
		}
		catch(Exception e){
			System.out.println(e);
		}
		//System.out.println("test");
	}
	
	//main entry. 
	public void printResult(String filename) throws Exception{
		int[][] matrix = create2DIntMatrixFromFile(filename);
		
		int[][] pathSum = maxSum(matrix);
		int[][] path = getPath(pathSum, matrix);
		if(path==null){
			System.out.println("No path exist from the top left to the right bottom.");
			return;
		}
		int pathNode = path.length;
		int rowIndex = 0;
		int colIndex = 0;
		int curr = matrix[0][0];
		
		System.out.println("The path is:");
		System.out.print(curr);
		System.out.print("->");
		for(int i = 1; i<pathNode-1; i++){
			rowIndex = path[i][0];
			colIndex = path[i][1];
			curr = matrix[rowIndex][colIndex];
			System.out.print(curr);
			System.out.print("->");
		}
		rowIndex = path[pathNode-1][0];
		colIndex = path[pathNode-1][1];
		curr = matrix[rowIndex][colIndex];
		System.out.print(curr);
		System.out.println();
		System.out.println("The value Sum is:");
		int sum = valueSum(matrix, path);
		System.out.println(sum);
	}
	
	
	//dp problem, to find the maximum path sum for each element in the matrix. 
	public int[][] maxSum(int[][] matrix){
		int valueSum = 0;
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		
		int[][] pathSum = new int[rowNum+1][colNum+1];
		if(matrix[0][0]<0) return null; //since from the every first we cannot find a path. 
		
		for(int i = 0; i<rowNum; i++){
			for(int j =0; j<colNum; j++){
				if(matrix[i][j]>=0){
					if(pathSum[i][j+1]==Integer.MIN_VALUE && pathSum[i+1][j]==Integer.MIN_VALUE) {
						pathSum[i+1][j+1] = Integer.MIN_VALUE;
					}
					else{
						pathSum[i+1][j+1]= Math.max(pathSum[i][j+1], pathSum[i+1][j]) + matrix[i][j];
					}
				}
				else{
					pathSum[i+1][j+1] = Integer.MIN_VALUE;
				}
			}
		}
		return pathSum;
	}
	
	//return the path (row index, column index) of the matrix from the pathSum. 
	//Go backwards to check the path. 
	public int[][] getPath(int[][] pathSum, int[][] matrix){
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		//record the index. 
		int[][] path = new int[rowNum+colNum-1][2];
		int i = rowNum; 
		int j = colNum;
		while(i>=1&&j>=1){
			path[i+j-2][0] = i-1;
			path[i+j-2][1] = j-1;
			if(pathSum[i][j]-matrix[i-1][j-1] == pathSum[i-1][j]){
				i--;
			}
			else if(pathSum[i][j]-matrix[i-1][j-1] == pathSum[i][j-1]){
				j--;
			}
			else{
				return null;
			}
		}
		return path;
	}
	
	public int valueSum(int[][] matrix, int[][] path){
		int pathNode = path.length;
		int rowIndex = 0;
		int colIndex = 0;
		int curr = matrix[0][0];
		int regionNegSum = surNeg(matrix, 0, 0);
		int valueSum = curr+regionNegSum;
		for(int i = 1; i<pathNode; i++){
			rowIndex = path[i][0];
			colIndex = path[i][1];
			curr = matrix[rowIndex][colIndex];
			regionNegSum = surNeg(matrix, rowIndex, colIndex);
			valueSum = valueSum + curr + regionNegSum;
		}
		return valueSum;
	}
	
	public int surNeg(int[][] matrix, int rowIndex, int colIndex){
		int negTotal = 0;
		if(rowIndex>0){
			if(matrix[rowIndex-1][colIndex]<0){
				negTotal+=matrix[rowIndex-1][colIndex];
			}
		}
		if(rowIndex<matrix.length-1){
			if(matrix[rowIndex+1][colIndex]<0){
				negTotal+=matrix[rowIndex+1][colIndex];
			}
		}
		if(colIndex>0){
			if(matrix[rowIndex][colIndex-1]<0){
				negTotal+=matrix[rowIndex][colIndex-1];
			}
		}
		if(colIndex<matrix[0].length-1){
			if(matrix[rowIndex][colIndex+1]<0){
				negTotal+=matrix[rowIndex][colIndex+1];
			}
		}
		return negTotal;
	}
	
	public static int[][] create2DIntMatrixFromFile(String filename) throws Exception {
		
		File inFile = new File(filename);
		Scanner in = new Scanner(inFile);

		int intLength = 0;
		String[] items = in.nextLine().trim().split("\t");
		intLength = items.length;
		in.close();

		
		in = new Scanner(inFile);

		ArrayList<Integer[]> lst = new ArrayList<>();
		int lineCount = 0;
		while (in.hasNextLine()) {
			Integer[] matrixCols = new Integer[intLength];
			String[] currentLine = in.nextLine().trim().split("\t"); 
		    for (int i = 0; i < currentLine.length; i++) {
		    	matrixCols[i] = Integer.parseInt(currentLine[i]);    
            }
		    lst.add(matrixCols);
		    lineCount++;
		 }                                 
		 
		int[][] finalMatrix = new int[lineCount][intLength];
		for(int i=0; i<lineCount; i++){
			for(int j = 0; j<intLength; j++){
				finalMatrix[i][j] = lst.get(i)[j];
			}
		}
		return finalMatrix;
	}
}
