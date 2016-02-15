package com.array.string;

public class GasStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int totalSum = 0;
        int currentSum = 0;
        int startIndex =0;
        for (int i =0; i<N; i++){
            totalSum += gas[i]-cost[i];
            currentSum += gas[i]-cost[i];
            if(currentSum < 0){
                startIndex = i+1;
                currentSum =0;
            }
        }
        if(totalSum>=0){
            return startIndex;
        }
        else{
            return -1;
        }
   }
}
