package com.array.string;
import java.util.*;

public class PowerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Set<Integer> mySet = new HashSet<Integer>();
		 mySet.add(1);
		 mySet.add(2);
		 mySet.add(3);
		 for (Set<Integer> s : PowerSet.powerSet(mySet)) {
		     System.out.println(s);
		 }

	}
	
	public static Set<Set<Integer>> powerSet2(Set<Integer> originalSet) {
	    Set<Set<Integer>> sets = new HashSet<>();
	    if (originalSet.isEmpty()) {
	    	sets.add(new HashSet<Integer>());
	    	return sets;
	    }
	    List<Integer> list = new ArrayList<>(originalSet);
	    Integer head = list.get(0);
	    Set<Integer> rest = new HashSet<>(list.subList(1, list.size())); 
	    for (Set<Integer> set : powerSet2(rest)) {
	    	Set<Integer> newSet = new HashSet<>();
	    	newSet.add(head);
	    	newSet.addAll(set);
	    	sets.add(newSet);
	    	sets.add(set);
	    }		
	    return sets;
	} 
	
	public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
	    Set<Set<T>> sets = new HashSet<Set<T>>();
	    if (originalSet.isEmpty()) {
	    	sets.add(new HashSet<T>());
	    	return sets;
	    }
	    List<T> list = new ArrayList<T>(originalSet);
	    T head = list.get(0);
	    Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
	    for (Set<T> set : powerSet(rest)) {
	    	Set<T> newSet = new HashSet<T>();
	    	newSet.add(head);
	    	newSet.addAll(set);
	    	sets.add(newSet);
	    	sets.add(set);
	    }		
	    return sets;
	} 

}
