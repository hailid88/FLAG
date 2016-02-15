package com.linkedin;

/**
 * we can see that one half of the array must be ordered
	normally (in increasing order). 
	We can therefore look at the 
	normally ordered half to determine 
	whether we should search the left or right half.
	
	The tricky condition is if the left and the middle are identical
	
	In this case, we can check if the rightmost element is different.
	If it is, we can search just the right side. 
	Otherwise, we have no choice but to search both halves.
 * 
 *
 */
public class MinimumInRotatedSortedArray {

	public int findMin(int[] num) {
        if(num == null || num.length <= 0)
        	return -1;
        return findMin(num, 0, num.length - 1);
    }
	
	public int findMin(int[] num, int start, int end){
		if(start > end)
			return Integer.MAX_VALUE;
		
		int mid = (start + end) / 2;
		if(mid == start && mid == end)
			return num[mid];
		
		if(num[mid] > num[start]){
			return Math.min(num[start], this.findMin(num, mid + 1, end));
		} else if (num[mid] < num[end]){
			return Math.min(num[mid], this.findMin(num, start, mid - 1));
		} else if(num[mid] == num[start]){
			if(num[mid] != num[end])
				return Math.min(num[mid], this.findMin(num, mid + 1, end));
			else{
				return Math.min(this.findMin(num, start, mid - 1), this.findMin(num, mid + 1, end));
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args){
		MinimumInRotatedSortedArray find = new MinimumInRotatedSortedArray();
//		int[] num = {3, 4, 5, 6, 7, 8};
//		int[] num = {7, 8, 3, 4, 5, 6, 7};
		int[] num = {};
		System.out.println(find.findMin(num));
	}
	
}
