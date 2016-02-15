package com.guidewire;

public class TestHashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Hello";
		System.out.println(a.hashCode());
		String b = "Hello";
		System.out.println(b.hashCode());
		
		System.out.println(factorial(3));

	}
	
	public static int factorial(int n){
		if(n<=0) return -1;
		if(n==1) return 1;
		return n*factorial(n-1);
	}
	
	

}
