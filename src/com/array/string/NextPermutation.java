package com.array.string;

import java.util.Arrays;

public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4,2,0,2,3,2,0};
		NextPermutation obj = new NextPermutation();
		obj.nextPermutation(num);
		for(int i=0; i<num.length; i++){
			System.out.println(num[i]);
		}
		int a = 1;

	}
	
	public void nextPermutation(int[] num){
		//boundary check
		if(num==null || num.length<=1) return;
		int n = num.length;
		for(int i = n-2; i>=0; i--){
			for(int j=n-1; j>i; j--){
				if(num[j]>num[i]){
					int tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
					Arrays.sort(num, i+1, n);
					return;
				}
			}
		}
		Arrays.sort(num, 0, num.length);
		return;
	}
	
	
	
	public void nextPermutation2(int[] num) {
        // boundary check
        if(num == null || num.length <= 1)
        	return;
        
        int len = num.length, pivotIndex = len - 1;
        
        // find the pivot which violates the non-decreasing order from right to left
        for(pivotIndex = len - 1; pivotIndex >= 1; pivotIndex--){
        	if(num[pivotIndex] > num[pivotIndex - 1])
        		break;
        }
        pivotIndex--;
        if(pivotIndex < 0){
        	reverse(num, 0, len - 1);
        	return;
        }
        
        // find the permutation number which is the first number bigger than pivot from right to left
        int changeIndex = len - 1, pivot = num[pivotIndex];
        while(changeIndex > pivotIndex && num[changeIndex] <= pivot)
        	changeIndex--;
        
        // swap change number and pivot number
        num[pivotIndex] = num[changeIndex];
        num[changeIndex] = pivot;
        
        // reverse the part from pivot to the end of the array
        reverse(num, pivotIndex + 1, len - 1);
    }
    
    public void reverse(int[] num, int start, int end){
    	// boundary check
    	if(num == null || start > end || end >= num.length)
    		return;
    
    	int tmp = 0;
    	while(start < end){
    		tmp = num[start];
    		num[start++] = num[end];
    		num[end--] = tmp;
    	}
    }
}
