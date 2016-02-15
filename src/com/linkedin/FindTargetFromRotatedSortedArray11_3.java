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
public class FindTargetFromRotatedSortedArray11_3 {

	// mutual exclusion conditions
	public int findTargetCorrect(int[] input, int target, int start, int end){
		if(input == null || input.length <= 0 || start > end)
			return -1;
		
		int mid = (start + end) / 2;
		if(input[mid] == target)
			return mid;
		
		if(input[start] < input[mid]){
			if(target < input[mid] && target >= input[start])
				// search left
				return this.findTargetCorrect(input, target, start, mid - 1);
			else
				// search right
				return this.findTargetCorrect(input, target, mid + 1, end);
		} 
		else if (input[mid] < input[start]){
			if(target > input[mid] && target <= input[end])
				// search right
				return this.findTargetCorrect(input, target, mid + 1, end);
			else
				// search left
				return this.findTargetCorrect(input, target, start, mid - 1);
		} 
		else if (input[mid] == input[start]){
			if(input[mid] != input[end])
				// search right
				return this.findTargetCorrect(input, target, mid + 1, end);
			
			else{
				int rst = this.findTargetCorrect(input, target, start, mid -1);
				if(rst > -1)
					return rst;
				return this.findTargetCorrect(input, target, mid + 1, end);
			}
		}
		return -1;
		
	}
	
	
	public static void main(String[] args){
//		int[] input = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int[] input = {3, 1, 1};
//		int[] input = {11, 12, 36, 1, 8, 10};
//		int[] input = {20, 25, 30, 40, 10};
		FindTargetFromRotatedSortedArray11_3 find = new FindTargetFromRotatedSortedArray11_3();
		int target = 3;
		int start = 0, end = input.length - 1;
//		int loc = find.findTarget(input, target, start, end);
		int loc = find.findTargetCorrect(input, target, start, end);
		if(loc >= 0)
			System.out.println(loc + ": " + input[loc]);
		else
			System.out.println("cannot find this target");
	}
}
