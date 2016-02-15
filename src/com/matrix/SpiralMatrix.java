package com.matrix;
import java.util.*;

public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{3}, {2}};
		SpiralMatrix obj = new SpiralMatrix();
		List<Integer> resl = obj.spiralOrder(matrix);
		for(Integer item:resl){
			System.out.println(item);
		}

	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
        if(matrix==null || matrix.length<=0 || matrix[0].length<=0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int layer = Math.min(m, n)/2;
        
        for(int i=0; i<layer; i++){
        	
        	//first go top. 
        	int first = i, last = n-1-i;
        	for(int j = first; j<last; j++){
        		res.add(matrix[first][j]);
        	}
        	
        	//second right side
        	first = i; last = m-1-i;
        	for(int j = first; j<last; j++){
        		res.add(matrix[j][n-1-i]);
        	}
        	
        	//third bottom line, row is m-1-i;
        	first = n-1-i; last = i;
        	for(int j = first; j>last; j--){
        		res.add(matrix[m-1-i][j]); 
        	}
        	
        	//fourth left side, col is i;
        	first = m-1-i; last = i; 
        	for(int j = first; j>last; j--){
        		res.add(matrix[j][i]);
        	}
        }
        
        
        if(m>n){
        	
        }
        
        if(Math.min(m, n)%2==1){
        	if(m>n){
            	int first = layer, last = m-1-layer;
            	for(int j = first; j<=last; j++){
            		res.add(matrix[j][layer]);
            	}
            }
        	else{
        		int first = layer, last = n-1-layer;
        		for(int j = first; j<=last; j++){
        			res.add(matrix[layer][j]);
        		}
        	}
        }
        return res;
    }

}
