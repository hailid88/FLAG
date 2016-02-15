package com.array.string;
import java.util.*;

public class LargestRectangleInHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
		//int[] height = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] height = {2,1,5,6,2,3};
		int output = obj.largestRectangleArea(height);
		System.out.println(output);

	}

	
	
	//using stack to solve this problem. 
	public int largestRectangeArea_stack(int[] height){
		if(height==null || height.length==0) return 0;
		int n = height.length, maxArea = -1, h = 0, minV =Integer.MAX_VALUE, width=0;
		Stack<Integer> value = new Stack<Integer>(), widths = new Stack<Integer>();
		for(int i = 0; i<=n; i++){
			if(i>=n){
				h=-1;
			}
			else{
				h = height[i];
			}
			
			if(value.empty() || h>=value.peek()){
				value.push(h);
				widths.push(1);
			}
			else if(h<value.peek()){
				minV = Integer.MAX_VALUE;
				width = 0;
				while(!value.empty() && h<value.peek()){
					minV= Math.min(value.pop(), minV);
					width = width + widths.pop();
					maxArea = Math.max(maxArea, minV*width);
				}
				value.push(h);
				widths.push(++width);
			}
		}
		return maxArea;
	}
	
	
	
	
	
	
	//recursive solution. 
	public int largestRectangleArea(int[] height) {
        if(height == null || height.length==0) return 0;
        return largestRA(height, 0, height.length-1);
	}
    public int largestRA(int[] height, int start, int end){
        if(start>end) return 0;
        int minVal = height[start];
        int minIndx = start;
        
        for(int i=start+1; i<=end; i++){
            if(height[i]<minVal){
                minVal = height[i];
                minIndx = i;
            }
        }
        int minArea = minVal*(end-start+1);
        int leftMax = largestRA(height, start, minIndx-1);
        int rightMax = largestRA(height, minIndx+1, end);
        
        return Math.max(minArea, Math.max(leftMax, rightMax));
    }

}
