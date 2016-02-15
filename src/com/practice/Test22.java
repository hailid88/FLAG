package com.practice;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter something here : ");
		
		
		 
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String s = bufferRead.readLine();
	 
		    System.out.println(s);
		    
		    bufferRead.close();
		    
		    int len = s.length();
		    
//		    for(int i = 0; i< len; i++){
//		    	System.out.println((int)s.charAt(i));
//		    }
		    int hh = 12;
		    String test = ""+hh+"";
		    System.out.println(String.valueOf(hh));
		    System.out.println(test.length());
		    
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		


	}
	
	
	

}
