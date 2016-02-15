package com.array.string;

import java.util.HashMap;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] numbers, int target) {
        int numLen=numbers.length;
        HashMap<Integer, Integer> hM=new HashMap<Integer, Integer>();
        int currentNum=0;
        int[] result=new int[2];
        for (int i=0; i<numLen; i++)
        {
            currentNum=numbers[i];
            if(!hM.containsKey(currentNum))
            {
                int diff=target-currentNum;
                hM.put(diff, i);
            }
            else
            {
                result[0]=hM.get(currentNum)+1;
                result[1]=i+1;
            }
        }
        return result;
        
    }

}
