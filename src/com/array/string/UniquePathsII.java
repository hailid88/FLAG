package com.array.string;

public class UniquePathsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null || obstacleGrid.length<=0 || obstacleGrid[0].length<=0){
        	return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] p = new int[m][n];
        
        if(obstacleGrid[0][0]==0){
            p[0][0] =1;
        }
        else{
            p[0][0] = 0;
            return 0;
        }
        
        for(int i=1; i<m; i++){
        	if(obstacleGrid[i-1][0]==1){
        		p[i-1][0]=0;
        	}
        	if(obstacleGrid[i][0]==1){
        	    p[i][0] = 0;
        	}
        	else{
        	    p[i][0] = p[i-1][0];
        	}
        }
        
        for(int j=1; j<n; j++){
        	if(obstacleGrid[0][j-1]==1){
        		p[0][j-1]=0;
        	}
        	if(obstacleGrid[0][j]==1){
        	    p[0][j] = 0;
        	}
        	else{
        	    p[0][j] = p[0][j-1];
        	}
        	
        }
        
        for(int i=1; i<m; i++){
        	for(int j = 1; j<n; j++){
        		if(obstacleGrid[i][j] == 1){
        			p[i][j] = 0;
        		}
        		else{
        			p[i][j] = p[i-1][j] + p[i][j-1];
        		}
        	}
        }
        return p[m-1][n-1];
    }

}
