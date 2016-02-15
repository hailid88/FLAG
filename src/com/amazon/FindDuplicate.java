package com.amazon;

public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,2,0,6,7,3,4};
		FindDuplicate obj = new FindDuplicate();
		boolean result = obj.isDuplicate(arr);
		System.out.println(result);
		for(int i = 0; i<arr.length; i++){
			System.out.print(arr[i]);
			System.out.print(", ");
		}

	}
	
	//the number is from 0 to n-1, which are put in the array of size n. Find if there are duplicate elements. 
	public boolean isDuplicate(int[] arr){
		int n = arr.length;
		for(int i = 0; i<n; i++){
			while(arr[i]!=i && arr[arr[i]]!=arr[i]){
				int temp = arr[i];
				arr[i]=arr[temp];
				arr[temp] = temp;
			}
			if(arr[i]!=i && arr[arr[i]]==arr[i]){
				return true;
			}
		}
		return false;
	}
}
