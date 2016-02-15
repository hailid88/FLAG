package com.array.string;

import java.util.Arrays;

public class MaximumGap {

	/**
	 * @param args
	 * 
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Credits:
Special thanks to @porker2008 for adding this problem and creating all test cases.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double t = (double)7/8;
		System.out.println(t);
		System.out.println((int)t);
		//int[] num = {1,2,5,4,3};
		//MaximumGap obj = new MaximumGap();
		//int result = obj.maximumGap(num);
		//System.out.print(result);
	}
	
	
	//use bucket sort to solve this problem. 
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2)
            return 0;
        // get the max and min value of the array
        int min = num[0];
        int max = num[0];
        for (int i:num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        // the minimum possibale gap, ceiling of the integer division
        
        //without min and max value, there are num.length-2 numbers left. 
        //now use num.length-1 regions, so there must exist one empty region. 
        
        //int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
        int gap = (max - min - 1) / (num.length - 1) + 1;
        
       
        
        int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
        //pay attention that max is initialized to bucketsMin and min is initialized to bucketsMax. 
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE); //initialize the min elements with max value of the integer. 
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);//initialize the max element with min value of the integer.
        
        // put numbers into buckets
        for (int i:num) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap; //index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]); 
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // update the final max value gap
        return maxGap;
    }

}
