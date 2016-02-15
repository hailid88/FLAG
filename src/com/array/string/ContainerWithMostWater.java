package com.array.string;

public class ContainerWithMostWater {

	/**
	 * @param args
	 * 
Given n non-negative integers a1, a2, ..., an, where each represents a point at 
coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line 
i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a 
container, such that the container contains the most water.

Note: You may not slant the container.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxArea(int[] height) {
    	if(height==null || height.length<=1) return 0;
    	int n = height.length;
    	
    	int l = 0;
    	int r = n-1;
        int maxArea = 0;
        
        while(l<r){
        	maxArea = Math.max(Math.min(height[l], height[r])*(r-l), maxArea);
        	if(height[l] < height[r]){
        		l++;
        		while(l<r && height[l]<height[l-1]){
        	        l++;
        	    }
        	}
        	else{
        		r--;
        		while(l<r && height[r]<height[r+1]){
        		    r--;
        		}
        	}
        }
        return maxArea;
    }

}
