package com.bloomberg;

/*
 * nput array of number {1,2,3,4,5,6} return number of array {2
*3*4*5*6, 1*3*4*5*6,1*2*4*5*6,1*2*3*5*6,1*2*3*4*6,1*2*3*4*5 }, 
 */

public class ExceptOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,5,6};
		ExceptOne obj = new ExceptOne();
		int[] resl = obj.exceptOneNoDiv(input);
		for(int item:resl){
			System.out.println(item);
		}

	}
	
	//by using division. 
	public int[] exceptOne(int[] input){
		int n = input.length;
		int allProd = 1;
		for(int i = 0; i<n; i++){
			allProd = allProd*input[i];
		}
		int[] result = new int[n];
		for(int i= 0; i<n; i++){
			result[i] = allProd/input[i];
		}
		return result;
	}
	
	//without using division
	public int[] exceptOneNoDiv(int[] input){
		int n = input.length;
	    //need to have an extra array. 
		int[] arrAsc = new int[n];
		int[] arrDsc = new int[n];
		
		arrAsc[0] = 1;
		arrDsc[0] = 1;
		for(int i = 0; i<n-1; i++){
			arrAsc[i+1] = arrAsc[i]*input[i]; 
			arrDsc[i+1] = arrDsc[i]*input[n-i-1];
		}
		
		int[] result = new int[n];
		for(int i=0; i<n; i++){
			result[i] = arrAsc[i]*arrDsc[n-i-1];
		}
		return result;
	}

}
