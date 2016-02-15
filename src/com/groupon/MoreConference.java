package com.groupon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class MoreConference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Conference> conferences = new ArrayList<>();
		Conference conference1 = new Conference(1,3);
		Conference conference2 = new Conference(2,4);
		Conference conference3 = new Conference(3,5);
		Conference conference4 = new Conference(4,5);
		conferences.add(conference1);
		conferences.add(conference2);
		conferences.add(conference3);
		conferences.add(conference4);
		int result = getMoreConference(conferences);
		System.out.println(result);

	}
	
	public static int getMoreConference(ArrayList<Conference> conferences){
		int n = conferences.size();
		if(n<=1) return n;
		Collections.sort(conferences, new Comparator<Conference>(){
			public int compare(Conference obj1, Conference obj2){
				if(obj1.endTime<obj2.endTime){
					return -1;
				}
				else if(obj1.endTime>obj2.endTime){
					return 1;
				}
				else{
					return 0;
				}
			}
		});
		
		
		ListIterator it = conferences.listIterator();
		Conference prev = (Conference)it.next();
//		System.out.print("curr is " + prev.startTime);
//		System.out.print(" end is: " + prev.endTime);
//		System.out.println();
		int count = 1;
		while(it.hasNext()){
			Conference curr = (Conference)it.next();
			if(curr.startTime<prev.endTime){
				
				it.remove();
			}
			else{
//				System.out.print("curr is " + curr.startTime);
//				System.out.print(" end is: " + curr.endTime);
//				System.out.println();
				count++;
				prev = curr;
			}
		}
		
		
		
		return count;
	}

}


class Conference{
	int startTime;
	int endTime;
	public Conference(int startTime, int endTime){
		this.startTime= startTime;
		this.endTime = endTime;
	}
}
