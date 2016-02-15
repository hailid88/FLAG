package com.bloomberg;

public class SecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,5,5, 7, 7,3};
		
		SecondLargest obj = new SecondLargest();
		int resl = obj.secondL(arr);
		System.out.println(resl);
	}
	
	public int secondL(int[] arr){
		if(arr==null || arr.length<2) return Integer.MIN_VALUE;
		int n = arr.length;
		int first=0;
		int second=0;
		if(arr[0]>arr[1]){
			first = arr[0];
			second = arr[1];
		}
		else{
			first = arr[1];
			second = arr[0];
		}
		
		for(int i = 2; i<n; i++){
			if(arr[i]>first){
				second = first;
				first = arr[i];
			}
			else{
				if(arr[i]>second && arr[i]!=first){
					second = arr[i];
				}
			}
		}
		return second;
	}

}
