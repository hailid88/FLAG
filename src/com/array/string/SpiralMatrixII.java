package com.array.string;

public class SpiralMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double test = Math.pow(2, 1);
//		System.out.println(test);
	}
	public int[][] generateMatrix(int n) {
        if(n<=0) return null;
        int[][] result = new int[n][n];
        
        int layerN = n/2;   //number of layers.
        int curr = 1;
      //top, right, bottom, left.
        for(int i =0; i<layerN; i++){
        	//top. 
        	for(int j = i; j<n-1-i; j++){
        		result[i][j] = curr;
        		curr++;
        	}
        	//right
        	for(int j = i; j<n-1-i; j++){
        		result[j][n-1-i]= curr;
        		curr++;
        	}
        	//bottom
        	for(int j = i; j<n-1-i; j++){
        		result[n-1-i][n-1-j]= curr;
        		curr++;
        	}
        	//left
        	for(int j = i; j<n-1-i; j++){
        		result[n-1-j][i]= curr;
        		curr++;
        	}
        }
        
        if(n%2==1){
        	result[layerN][layerN] = curr;
        }
        
        
        return result;
    }

}
