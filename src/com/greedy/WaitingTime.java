package com.greedy;

import java.util.Arrays;

public class WaitingTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] processTime = {5,10,8,7};
		WaitingTime obj = new WaitingTime();
		int result = obj.leastWaitingTime(processTime);
		System.out.println(result);

	}
	
	public int leastWaitingTime(int[] processTime){
		int n = processTime.length;
		Arrays.sort(processTime);
		int totalWaiting = 0;
		for(int i = 0; i<n-1; i++){
			totalWaiting+=processTime[i]*(n-1-i);
		}
		return totalWaiting;
	}

}
