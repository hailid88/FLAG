package com.practice;

import java.util.*;

/*
 * To test if HashMap can be overwrite. 
 */

public class HashMapTest {
	public static void main(String[] args){
		HashMap<Integer, Integer> hM=new HashMap<Integer, Integer>();
		hM.put(1,2);//
		hM.put(2,3);
		hM.put(1, 3);
		/*int keyValue=1;
		if(hM.containsKey(keyValue))
		{
			hM.put(keyValue, hM.get(keyValue)+1);
		}*/
		System.out.println(hM.get(1));
		int  x;
		int  y;
		 
		// Increment operators
		x = 1;
		y = ++x;    // x is now 2, y is also 2
		System.out.println("y=++x, the value of y is " + y);
		System.out.println("The value of x is " + x);
		y = x++;    // x is now 3, y is 2
		System.out.println("y=x++, the value of y is "+ y); 
		// Decrement operators
		x = 3;
		y = x--;    // x is now 2, y is 3
		y = --x;    // x is now 1, y is also 1
	}
}
