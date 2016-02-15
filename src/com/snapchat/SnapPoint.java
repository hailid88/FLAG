package com.snapchat;
import java.util.*;

public class SnapPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void getReach(Point p, int k, Set<Point> sp){
		 int x = p.x;
	     int y = p.y;

	     ArrayList<Point> neighbors = new ArrayList<Point>();
	    
	     Point p1 = new Point(x+1, y);
	     if(isSnapPoint(p1, k)){
	    	 neighbors.add(p1);
	     }
	     Point p2 = new Point(x-1, y);
	     if(isSnapPoint(p2, k)){
	    	 neighbors.add(p2);
	     }
	     Point p3 = new Point(x, y+1);
	     if(isSnapPoint(p3, k)){
	    	 neighbors.add(p3);
	     }
	     Point p4 = new Point(x, y-1);
	     if(isSnapPoint(p4, k)){
	    	 neighbors.add(p4);
	     }
	     if(neighbors.size()==0) return;
	     
	     for(Point curP: neighbors){
	           if(sp.add(curP)){
	        	   getReach(curP, k, sp);
	           }
	    }

	}
	
	public boolean isSnapPoint(Point p, int k){
	    if(p==null) return false;
	    if(k<0) return false;
	    int x = Math.abs(p.x);
	    int y = Math.abs(p.y);
	    
	    return getSum(x)+getSum(y) <=k;
	}
	
	public int getSum(int x){
	    int sum = 0;
	    while(x>0){
	      sum+=x%10;
	      x=x/10;
	    }
	    return sum;
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
