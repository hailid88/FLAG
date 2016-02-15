package com.breathfirstsearch;

public class Sqrt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sqrt(int x) {
		if(x <= 0)
			return 0;
		if(x <= 1)
			return 1;
		int left = 2, right = x / 2, mid = 0, iProd = 0;
		
		
		double prod = 0;
		
		while(left <= right){
			mid = (left + right) / 2;
			prod = (double)mid * (double)mid;
			if(prod >= Integer.MAX_VALUE)
				right = mid - 1;
			else{
				iProd = (int) prod;
				if(iProd == x)
					return mid;
				else if(iProd < x)
					left = mid + 1;
				else
					right = mid -1;
			}
		}
		
		return right;
    }

}
