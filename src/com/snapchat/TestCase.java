package com.snapchat;

public class TestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache obj = new LRUCache(1);
		obj.set(2, 1);
		System.out.println(obj.get(2));
		

	}

}
