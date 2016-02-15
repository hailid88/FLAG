package com.array.string;

public class SortColors {

	/**
	 * @param args
	 * Given an array with n objects colored red, white or blue, sort them 
	 * so that objects of the same color are adjacent, with the colors in 
	 * the order red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red, 
	 * white, and blue respectively.
	 * 
	 * Note:
	 * You are not suppose to use the library's sort function for this problem.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,0};
		SortColors obj = new SortColors();
		obj.sortColors(A);
		
	}
	
	public void sortColors(int[] A) {
        //sort 0, 1, 2
       if(A==null) return;
		int Alen = A.length;
		if(Alen<=1) return;
		int leftPointer = 0;
		int rightPointer = Alen-1;
		
		
		//leftPointer point to the first non-zero element. 
		for(int i=0; i<Alen; i++){
			if(A[i]==0){
				leftPointer++;
				if(leftPointer>=Alen-1) return;
			}
			else{
				break;
			}
		}
		
		//then go from leftPointer, and if find 0, then switch with leftPointer. LeftPointer + 1. 
		for(int i = leftPointer+1; i< Alen; i++){
			if(A[i]==0){
				int tmp = A[leftPointer];
				A[leftPointer] = A[i];
				A[i] = tmp;
				leftPointer++;
			}
		}
		
		//rightPointer point to the last non-two element. 
		for(int i=Alen-1; i>=0; i--){
			if(A[i]==2){
				rightPointer--;
				if(rightPointer<=Math.max(0,leftPointer-1)) return;
			}
			else{
				break;
			}
		}
		
		for(int i = rightPointer-1; i>=leftPointer; i--){
			if(A[i]==2){
				int tmp = A[rightPointer];
				A[rightPointer] = A[i];
				A[i] = tmp;
				rightPointer--;
			}
		}
		
   }

}
