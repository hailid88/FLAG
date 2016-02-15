package com.baseTest;

public class ClassExtension {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] obj = new Shape[2];
		//Shape obj3 = new Shape();
		Circle obj2 = new Circle();
		

	}

}

abstract class Shape{
	public void printMe(){
		System.out.println("This is Shape");
	}
	public abstract double computeArea();
}

class Circle extends Shape{
	private double rad = 5;
	@Override
	public void printMe(){
		System.out.println("This is Circle");
	}
	public double computeArea(){
		return rad*rad*3.14;
	}
}