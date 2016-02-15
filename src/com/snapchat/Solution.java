package com.snapchat;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("Haili", "Dong", "27");
		Person p2 = new Person("Bingsheng", "Wang", "4");
		Solution obj = new Solution();
		int result = obj.compareTo(p1, p2);
		System.out.println(result);

	}
	
	public int compareTo(Person p1, Person p2)
    {
        int i = p1.firstName.compareTo(p2.firstName);
        int j = p1.firstName.charAt(0) - p2.firstName.charAt(0);
        //if (i != 0) return i;

        i = p1.lastName.compareTo(p2.lastName);
        //if (i != 0) return i;
        int k= Integer.valueOf(p1.age).compareTo(Integer.valueOf(p2.age));
        return k;
    }
}


class Person {
	public String firstName;
	public String lastName;
	public String age;
	
	public Person(String fN, String lN, String age){
		this.firstName=fN;
		this.lastName=lN;
		this.age=age;
	}
}