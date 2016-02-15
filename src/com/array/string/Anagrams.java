package com.array.string;
import java.util.*;

public class Anagrams {
	
	
	public static void main(String[] args){
		Anagrams obj = new Anagrams();
		String[] strs = {"abc", "cba", "bac", "bbc", "cbb", "bcb", "def"};
		List result = obj.anagrams(strs);
		int a = 1;
		
		int x = -123;
		String test = String.valueOf(x);
		int back = Integer.valueOf(test);
		System.out.println(test);
		System.out.println(back);
		
		
		
	}
	public List<List<String>> anagrams(String[] strs) {
		
		List result = new ArrayList();
		Map<String, ArrayList<String>> hm = new HashMap<>();
		
		for(String str:strs){
			int[] codes = new int[256];
			char[] charArr = str.toCharArray();
			for(int i=0; i<str.length(); i++){
				codes[charArr[i]]++;
			}
			if(hm.containsKey(getKey(codes))){
				hm.get(getKey(codes)).add(str);
			}
			else{
				ArrayList<String> items = new ArrayList<String>();
				items.add(str);
				hm.put(getKey(codes), items);
			}
		}
		
		Set<String> keys = hm.keySet();
		
		for(String key:keys){
			if(hm.get(key).size()>1){
				result.add(hm.get(key));
			}
		}
		
		return result;
	}
	public String getKey(int[] codes){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<codes.length; i++){
			sb.append(codes[i]);
		}
		return sb.toString();
	}

}
