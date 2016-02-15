package com.array.string;

public class TestEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String obj1 = new String("xyz");

		String obj2 = new String("xyz");

		if(obj1 == obj2)
		   System.out.println("obj1==obj2 is TRUE");
		else
		  System.out.println("obj1==obj2 is FALSE");
		
		if(obj1.equals(obj2)){
			System.out.println("obj1 is equal to obj2");
		}
		    

	}

}
