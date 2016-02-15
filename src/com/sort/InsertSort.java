package com.sort;

public class InsertSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,3,1,5,2};
		InsertSort obj = new InsertSort();
		int[] output = obj.insertSort(input);
		for(int i : output){
			System.out.println(i);
		}
	}
	
	
	//sort in increasing order. 
	public int[] insertSort(int[] oriArray){
		int len = oriArray.length;
		int key;
		//all the elements before key is sorted. 
		for (int i = 1; i<len; i++){
			key = oriArray[i];
			int j= i-1;
			while(j>=0 && oriArray[j]>key){
				oriArray[j+1]=oriArray[j];
				j--;
			}
			oriArray[j+1]=key;
		}
		return oriArray;
	}

}
