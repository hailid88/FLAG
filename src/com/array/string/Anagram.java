package com.array.string;
import java.util.*;

//write a method to decide if two strings are anagrams or not. 

public class Anagram {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean output = anagram("abas", "baa");
		boolean output2= anagramHashMap("abas", "baas");
		System.out.println(output);
		System.out.println(output2);

	}
	public static boolean anagram(String s, String t){
		char[] sChar = s.toCharArray();        //Convert to array of chars 
		Arrays.sort(sChar);          //Sort
		char[] tChar = t.toCharArray();
		Arrays.sort(tChar);
		return Arrays.equals(tChar, sChar);
	}
	
	public static boolean anagramHashMap(String s, String t){
		//other than to sort the anagram, we use hashset to solve the problem. 
		//first replace the space with empty. 
		s.replaceAll("\\s+","");
		t.replaceAll("\\s+", "");
		if(s.length()!=t.length()) return false;
		char[] schar = s.toCharArray();
		char[] tchar = t.toCharArray();
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i = 0; i<s.length(); i++){
			if(hm.containsKey(schar[i])){
				hm.put(schar[i], hm.get(schar[i])+1);
			}
			else{
				hm.put(schar[i], 1);
			}
		}
		
		for(int j=0; j<t.length(); j++){
			if(hm.containsKey(tchar[j])){
				if(hm.get(tchar[j])-1 < 0){
					return false;}
				else{
					hm.put(tchar[j], hm.get(tchar[j])-1);}
			}
			else{
				return false;
			}
		}
		
		return true;
		
	}
}
