package com.matrix;
import java.util.*;

public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maximalRectangle(char[][] matrix){
		if(matrix == null || matrix.length<=0 || matrix[0].length<=0) return 0;
		int r = matrix.length;
		int c = matrix[0].length;
		int[][] rect = new int[r][c];
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(i==0){
					rect[i][j] = matrix[i][j]=='1'?1:0;
				}else{
					rect[i][j] = matrix[i][j]=='1'?rect[i-1][j]+1:0;
				}
			}
		}
		
		int maxArea = 0;
		for(int i = 0; i<r; i++){
			int tem = getLargestRectangle(rect[i]);
			maxArea = tem>maxArea?tem:maxArea;
		}
		return maxArea;
		
	}
	
	public int getLargestRectangle(int[] heights){
		if(heights==null || heights.length<=0) return 0;
		//values is used to save the area value for the corresponding widths. 
		Stack<Integer> values = new Stack<Integer>();
		Stack<Integer> widths = new Stack<Integer>();
		int n = heights.length;
		int curH = 0;
		int maxArea = 0;
		int minV = 0;
		int width = 0;
		for(int i = 0; i<=n; i++){
			if(i<=n-1){
				curH = heights[i];
			}
			else{
				//i == n-1 the last element, we need to pop all the elements in the stack.
				curH = -1;
			}
			//pay attention for the equal, it also need to be added. 
			if(values.isEmpty() || curH>=values.peek()){
				values.push(curH);
				widths.push(1);
			}
			else if(!values.isEmpty() && curH<values.peek()){
				minV = Integer.MAX_VALUE;
				width = 0;
				while(!values.isEmpty() && curH<values.peek()){
					minV = Math.min(minV, values.pop());
					width = width + widths.pop();
					maxArea = Math.max(maxArea, minV*width);
				}
				values.push(curH);
				widths.push(width+1);
				
			}
			
			
		}
		return maxArea;
	}
	
	
	//written by others. 
	private int getLargestRectangle2(int[] height){  
	    
	    int[] copy = new int[height.length + 1];  
	  //copyOf(byte[] original, int newLength) 
	    copy = Arrays.copyOf(height, height.length + 1);    
      //Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length.
	    Stack<Integer> stack = new Stack<Integer>();  
	    int maxArea = 0;  
	    int i = 0;  
	    while(i < copy.length){  
	        if(stack.isEmpty() || copy[stack.peek()] < copy[i]){  
	            stack.push(i++);  
	        }else{  
	            int num = stack.pop();  
	            maxArea = Math.max(maxArea,copy[num] * (stack.isEmpty() ? i : i - stack.peek() - 1));  
	        }  
	    }  
	    return maxArea;  
	   }  

}
