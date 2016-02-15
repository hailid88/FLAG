package com.baseTest;

public class StaticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticTest obj = new StaticTest();
		StaticTest obj2 = new StaticTest();
		obj.x = 2;
		obj2.x = 5;
		System.out.println(obj.x);
		System.out.println(obj2.x);

	}
	
	static int x = 3;

}
