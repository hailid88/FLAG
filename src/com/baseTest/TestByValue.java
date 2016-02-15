package com.baseTest;

import java.util.Arrays;

public class TestByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer passing = 3;
		 Integer t = 3;
		 

		 receiving(passing);
		 
		  System.out.println("The value of passing is: " + passing);
		  
		  
		  
		  int[] a = {1,2,4,6};
		  int[] b = {3,4,5,8};
		  int[] c = Arrays.copyOf(a, 8);
		  
		  //System.arraycopy(a, 0, c, 0, 4);
		  //System.arraycopy(b, 0, c, 4, 4);
		  for(int i = 0; i<c.length; i++){
			  System.out.println(c[i]);
		  }

	}
	
	public static void receiving(Integer n){
		n=n+1;
	}

}
