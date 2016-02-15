package com.liveramp;

public class Test {

	/**
	 * @param args
	 */
	static int i = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		i = 3;
		System.out.println(changeItem());
		System.out.println(i);
	}
	public static int changeItem(){
		i = 8;
		return i;
	}
	

}
