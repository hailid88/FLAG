package com.array.string;

import java.io.BufferedReader;
import java.io.FileReader;

//Write a function that sums up integers from a text file, one int per line. 
public class SumFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = (int)(-Math.pow(2, 31));
		System.out.println(t);
		System.out.println(Integer.toBinaryString(t));
		int i = 3;
		System.out.println(--i);
		System.out.println(i--);
		char num1 = '9';
		System.out.println(num1);
		char num2 = (char)21;
		System.out.println(num2);
		System.out.println(num1==num2);
	}
	
	public static void sumFile(String name){
		try{
			int total = 0;
			BufferedReader in = new BufferedReader(new FileReader(name));
			for(String s = in.readLine(); s!=null; s=in.readLine()){
				total+=Integer.parseInt(s);
			}
			System.out.print(total);
			in.close();
		}
		catch(Exception xc){
			xc.printStackTrace();
		}
	}

}
