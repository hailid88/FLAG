package com.bloomberg;

public class Multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1={2,2,9};
		int[] num2={2,1};
		Multiplication obj = new Multiplication();
		int[] result = obj.multiply(num1, num2);
		for(int i = result.length-1; i>=0; i--){
			System.out.println(result[i]);
		}

	}
	
	public int[] multiply(int[] num1, int[] num2){
		int l1 = num1.length;
		int l2 = num2.length;
		int[] result = new int[l1+l2];
		int carry = 0;
		
		for(int i = 0; i<l1; i++){
			for(int j = 0; j<l2; j++){
				result[i+j] = result[i+j] + num1[i]*num2[j];
				result[i+j+1] += result[i+j]/10;
				result[i+j] = result[i+j]%10;
			}
		}
		
		return result;
	}

}
