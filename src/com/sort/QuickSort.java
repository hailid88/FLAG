package com.sort;

//quick sort has two pointers. 
//first get the pivot number. and then move the number that is less than pivot to left, larger than pivot to right. 
//in-place reorder. 
public class QuickSort {
	public void quickSort(int[] input, int start, int end){
		if(input == null || input.length <= 0 || start<0 || end>=input.length || start>=end )
			return;		
		int index = this.partition(input, start, end);
		if(start < index-1) //strict smaller. 
			this.quickSort(input, start, index-1);
		if(end > index) //strict larger
			this.quickSort(input, index, end);    
	}
	
	
	
	
	
	public int partition(int[] input, int start, int end){
		if(input == null || input.length <= 0)
			return 0;
		
		int pivot = input[(start + end)/ 2];

		while(start <= end){ //pay attention, that it should have the equal. 
			while(start <= end && input[start] < pivot)      //3 5 2 1 6 7   pivot 5   start = 0, end = 5. 
				start++;                                     //3 1 2 5 6 7
			while(start <= end && input[end] > pivot)        //2 1 3 4 5 6  
				end--;
	
			if(start <= end){
				if(start<end && input[start]!=input[end]){
					int tmp = input[start];
					input[start] = input[end];
					input[end] = tmp;
				}
				//else is the start = end, we do not need to change these two numbers. 
				start++;
				end--;
			}
		} // while
		
		return start;
	}
	
	public static void main(String[] args){
		int[] input = {6, 4, 5, 4, 3, 2, 1, 4, 2, 3};
		//int[] input = {3, 1, 2, 4, 8, 5, 10};		
		int start = 0, end = input.length - 1;
		
		QuickSort quickSort = new QuickSort();
		//quickSort.quickSort(input, start, end);
		quickSort.quickSort(input, start, end);
		
		for(int i = 0; i < input.length; i++)
			System.out.print(input[i] + ",");
	}

}
