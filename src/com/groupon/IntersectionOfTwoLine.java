package com.groupon;

public class IntersectionOfTwoLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Point getIntersect(Point[] points){
		if(points.length!=4){
			System.out.println("Error input!");
			return null;
		}
		Point A = points[0];
		Point B = points[1];
		//based on the point A and Point B to calculate the line. 
		return null;
	}

}

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}