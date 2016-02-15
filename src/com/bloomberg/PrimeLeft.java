package com.bloomberg;


//this question is asked to have the prime number on the left and the even number on the right. 
//So here the best strategy is to use two pointers. 
public class PrimeLeft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,3,5,1,6,7,8};
		PrimeLeft obj = new PrimeLeft();
		obj.primeLeft(input);
		for(int item:input){
			System.out.print(item);
			System.out.print(" ");
		}

	}
	
	public void primeLeft(int[] input){
		int left = 0;
		int right = input.length-1;
		while(left<right){
			while(left<right && ((input[right]&1)!=1)){
				right--;
			}
			while(left<right && ((input[left]&1)==1)){
				left++;
			}
			if(left<right){
				int tmp = input[right];
				input[right] = input[left];
				input[left] = tmp;
			}
			
		}
	}

}
