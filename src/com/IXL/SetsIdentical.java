package com.IXL;

import java.util.Arrays;
import java.util.HashSet;

public class SetsIdentical {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//test cases. 
		
		boolean res1 = allStringSetsIdentical(new String[][] {{"a","b"},{"b","b","a"},{"b","a"}});

		boolean res2 = allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}});

	}
	
	public static boolean allStringSetsIdentical(String[][] sets){
		//boundary check. 
		if(sets==null || sets.length<=0 || sets[0].length<=0) return true;
		
		//the number of sets.
		int m = sets.length;
		
		//the number of strings in the first set. 
		int n = sets[0].length;
		
		//define a Hashset. 
		Arrays.sort(sets[0]);
		HashSet<String> hs = new HashSet<String>(Arrays.asList(sets[0]));
		
		int uniqueNum = hs.size();
		
		for(int i =1; i<m; i++){
			if(sets[i].length<uniqueNum){
				return false;
			}
			n = sets[i].length;
			Arrays.sort(sets[i]);
			HashSet<String> tmp = new HashSet<String>(Arrays.asList(sets[i]));
			if(!hs.equals(tmp)){
				return false;
			}
		}
		
		
		return true;
	}

}
