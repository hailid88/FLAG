package com.array.string;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci obj = new Fibonacci();
		int result = obj.fibonacci(5);
		System.out.println(result);
		for(int i = 1; i<=9; i++){
			for(int j = 1; j<=9; j++){
				System.out.print(String.format("%6d", j*i));
			}
			System.out.println();
		}
		

	}
	
	public int fibonacci3(int n){
		if(n<0) return -1;
		if(n==0) return 0;
		if(n==1) return 1;
		int f1 = 1;
		int f2 = 1;
		int f3 = 2;
		for(int i = 3; i<=n; i++){
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3; 
		}
		return f2;
	}
	
	public int fibonacci(int n){
		if(n<0) return -1;
		if(n==0) return 0;
		if(n==1)  return 1;
		//we should use array to save the result.
		int[] resultArr = new int[n+1];
		resultArr[0] = 0;
		resultArr[1] = 1;
	
		for(int i = 2; i<=n; i++){
			resultArr[i] = resultArr[i-1] + resultArr[i-2]; 
		}
		return resultArr[n];
	}
	
	

}
