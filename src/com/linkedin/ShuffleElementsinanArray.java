package com.linkedin;

import java.util.Random;

public class ShuffleElementsinanArray {
	public static int[] RandomizeArray(int[] array){
		Random rgen = new Random();  // Random number generator			
		int randomPosition = 0, temp = 0;
		for (int i=0; i<array.length; i++) {
		    randomPosition = rgen.nextInt(array.length);
//		    System.out.print(randomPosition + ", ");
		    temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	
	public static void main(String[] args){
		int[] a = {1, 3, 4, 5};
		RandomizeArray(a);
	}
}
