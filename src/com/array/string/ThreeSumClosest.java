package com.array.string;

import java.util.Arrays;

public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int threeSumClosest(int[] num, int target){
		Arrays.sort(num);
		int len= num.length;
		int j;
		int k;
		int result=0;
		int min=Integer.MAX_VALUE;
		for(int i = 0; i<len-2; i++){
			j = i+1;
			k = len-1; 
			while(j < k){
				int sum = num[i]+num[j]+num[k];
				int diff = Math.abs(sum - target);
				if(diff<min){
					min = diff;
					result = sum;
				}
				
				if(sum<target){
					j++;
				}else{
					k--;
				}
			}
		}
		return result;
	}

}
