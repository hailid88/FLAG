package com.stack.queue;
import java.util.Stack;

public class LargestRectangleInHistogram {

	/**
	 * @param args
	 */
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length <= 0)
			return 0;
		
		int len = height.length, maxArea = -1, h = 0, minV = 0, width;
		Stack<Integer> value = new Stack<Integer>(), widths = new Stack<Integer>();
		for(int i = 0; i <= len; i++){
			if(i >= len)
				h = -1;
			else
				h = height[i];
			if(value.empty() || h >= value.peek()){
				value.push(h);
				widths.push(1);
			}
			else if(h < value.peek()){
				minV = Integer.MAX_VALUE;
				width = 0;
				while(!value.empty() && h < value.peek()){
					minV = Math.min(value.pop(), minV);
					width += widths.pop();
					maxArea = Math.max(maxArea, minV * width);
				}
				value.push(h);
				widths.push(++width);	// plus previous width
			}
		}
		return maxArea;
	}

}
