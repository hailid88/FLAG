package com.sort;

public class MergeSort {

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
	
	//merge sort first sort half and half and then merge. 
	
	public void mergeSort(int[] input, int start, int end){
		if(input == null || input.length<=1 || start>=end) return;
		int mid = (start + end)/2;
		mergeSort(input, start, mid);
		mergeSort(input, mid+1, end);
		merge(input, start, mid, end);
	}
	public void merge(int[] input, int start, int mid, int end){
		int[] helper = new int[input.length];

		//only need to copy from the start to end. 
		for (int i = start; i<=end; i++){
			helper[i]= input[i];
		}		
		
		int pointer1 = start;
		int pointer2 = mid+1;
		
		int i=start;
		while(pointer1<=mid && pointer2<=end){
			if(helper[pointer1]<helper[pointer2]){
				input[i]=helper[pointer1];
				pointer1++;
			}
			else{
				input[i]=helper[pointer2];
				pointer2++;
			}
			i++;
		}
		
		//do remember that when pointer1 is no more than mid. 
		if(pointer1<=mid){
			for(; i<=end; i++){
				input[i] = helper[pointer1];
				pointer1++;
			}
		}
		//pointer2 do not need to worry since it already and the late half. 
	}
	

}
