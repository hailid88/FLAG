package com.array.string;

public class Matrix90 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int N=2;
		//int[][] oriMatrix = new int[N][N];
		//System.out.println(oriMatrix.length);
	    int[][] oriMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
	    
	    
	    int[][] outputMatrix = matrix90(oriMatrix);
	
	    int i;
	    int j;
		for (i = 0; i<outputMatrix.length; i++){
			for (j=0; j<outputMatrix[0].length; j++){
				System.out.println(outputMatrix[i][j]);
			}
		}

	}
	
	
	public static int[][] matrix90(int[][] oriMatrix){
		int N = oriMatrix.length;
		////this method use extra O(n*n) space. 
		int[][] outputMatrix = new int[N][N];
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j<N; j++){
				////clockwise 90
				outputMatrix[j][N-1-i] = oriMatrix[i][j];
				////clockwise 180
				//outputMatrix[j][N-1-i] = oriMatrix[N-1-j][i];
				////clockwise 270
				//outputMatrix[j][N-1-i] = oriMatrix[N-1-i][N-1-j];
			}			
		}
		return outputMatrix;
	}
	
	
	
	//this method use extra O(1) space. 
	public static int[][] matrix90_1(int[][] oriMatrix){
		int N = oriMatrix.length;
		for (int layer = 0; layer < N/2; layer++)
		{
			int first = layer;
			int last = N-1 - layer;
			for (int j = first; j<last; j++){
				int steps  = j - first;
				//remember the top;
				int temp = oriMatrix[first][first + steps];
				//left --> top
				oriMatrix[first][first + steps] = oriMatrix[last-steps][first];
				
				//bottom --> left;
				oriMatrix[last-steps][first] = oriMatrix[last][last - steps];
				
				//right --> bottom 
				oriMatrix[last][last - steps] = oriMatrix[first + steps][last];
				
			    //top --> right
				oriMatrix[first + steps][last] = temp;
			}		
		}
		return oriMatrix;
	}
}
