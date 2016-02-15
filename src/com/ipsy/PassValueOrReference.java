package com.ipsy;

public class PassValueOrReference {

	//this class is used to test if java is pass by value or pass by reference. 
	//As the materials show it is pass by value. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Haili h1 = new Haili(23, "DHL");
		Haili h2 = new Haili(26, "DXY");
		swap(h1, h2);
		//this tells it is pass by value. 
		System.out.println(h1.name);
		System.out.println(h2.name);
	}
	
	
	public static  void swap(Haili h1, Haili h2){
		Haili temp = h1;
		h1 = h2;
		h2 = temp;
	}
	
	
	

}


class Haili{
	int age;
	String name;
	public Haili(int age, String name){
		this.age = age;
		this.name = name;
	}
}