package com.base;
import java.util.*;

public class NGram {
	
	public static void main(String[] args){
		String s = "abcababa";
		String m = "ab";
		int n = 3;
		NGram obj = new NGram();
		String resl = obj.sample(s, m, n);
		System.out.println(resl);
	}
	
	public String sample(String s, String m, int n){
		int len = s.length();
		if(n<=0 || n>len) return "";
		Map<String, ArrayList<String>> hm = new HashMap<>();
		for(int i = 0; i<len-n+1; i++){
			//System.out.println(s.substring(i, i+n-1));  //len-n        len-1
			if(!hm.containsKey(s.substring(i, i+n-1))){//n-1
				ArrayList<String> item = new ArrayList<String>();
				hm.put(s.substring(i, i+n-1), item);
			}
			hm.get(s.subSequence(i, i+n-1)).add(s.substring(i+n-1, i+n));
		}
		
		if(hm.containsKey(m)){
			int num = hm.get(m).size();			
			Random r = new Random();
			int pivot = r.nextInt(num);
			System.out.println(pivot);
			return hm.get(m).get(pivot);
		}
		
		return null;
	}

}
