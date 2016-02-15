package com.sort;

public class MergeSort2 {
	
	public void ms(int[] input, int start, int end, int[] helper){
		if(input == null || input.length <= 0)
			return;
		if(start < end){
			int mid = (start + end) / 2;
			ms(input, start, mid, helper);
			ms(input, mid + 1, end, helper);
			mg(input, helper, start, mid, end);
		}
	}
	
	public void mg(int[] input, int[] helper, int start, int mid, int end){
		for(int i = start; i <= end; i++)
			helper[i] = input[i];
		
		int left = start, right = mid + 1, c = start;
		while(left <= mid && right <= end){
			if(helper[left] < helper[right]){
				input[c] = helper[left];
				left++;
			}
			else{
				input[c] = helper[right];
				right++;
			}
			c++;
		}
		while(left <= mid){
			input[c] = helper[left];
			left++;
			c++;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,5,3,4};
		int start =0;
		int end = input.length-1;
		MergeSort obj = new MergeSort();
		obj.mergeSort(input, start, end);
		for(int t : input){
			System.out.println(t);
		}
	}
	
	public void mergeSort(int[] input, int start, int end){
		if(input == null || input.length<=1 || start>=end){
			return;
		}
		int mid = (start + end)/2;
		mergeSort(input, start, mid);
		mergeSort(input, mid+1, end);
		merge(input, start, end);
	}
	public void merge(int[] input, int start, int end){
		int mid = (start + end)/2;
		int[] helper = new int[input.length];
		for(int i=start; i<=end; i++){
			helper[i] = input[i];
		}
		int pointer1 = start;
		int pointer2 = mid+1;
		int i = start;
		while(pointer1<=mid && pointer2<=end){
			if(helper[pointer1]<helper[pointer2]){
				input[i] = helper[pointer1];
				pointer1++;
			}
			else{
				input[i]=helper[pointer2];
				pointer2++;
			}
			i++;
		}
		while(pointer1<=mid){
			input[i]= helper[pointer1];
			pointer1++;
			i++;
		}
	}
}
