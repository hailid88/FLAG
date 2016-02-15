package com.math;
import java.util.ArrayList;

public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public String getPermutation(int n, int k) {
		if(n <= 0 || k <= 0)
			return "";
        int permCount = 1;       //n!
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){  
            nums.add(i + 1);		  // nums contains 1,2,3,4,...,n
            permCount *= (i + 1);     // compute the n factorial  
        }  
          
        k=k-1;        // since index is from 0 to n-1, we minus k  
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){  
            permCount = permCount / (n - i);  // get the divisor  
            int idx = k / permCount;    // get the index of the number 该位应该选择的下标  
            sb.append(nums.get(idx));
            nums.remove(idx);
            k %= permCount;
        }  
        return sb.toString();
       
    }

}
