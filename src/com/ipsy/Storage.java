package com.ipsy;

import java.util.HashMap;

public class Storage {
	HashMap<Point, Integer> hm = new HashMap<>();
	void add (Point p) {
		if(hm.containsKey(p)){
			hm.put(p, hm.get(p)+1);
		}
		else{
			hm.put(p, 1);
		}
	}
	int count(Point p) {
		if(hm.containsKey(p)){
			return hm.get(p);
		}
		else{
			return 0;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Storage s = new Storage();
		s.add(new Point(1, 2));
		s.add(new Point(2, 1));
		s.add(new Point(1, 2));
		System.out.println(s.count(new Point(1, 2)));
		System.out.println(s.count(new Point(2, 1)));
	}

}


class Point {
	int x, y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}	

//	public int hashCode() {
//	 	return x * 1000 + y;
//	}
//
//	public boolean equals(Object o) {
//		//
//		Point other = (Point)o;
//		return other.x == x && other.y == y;
//	}
}