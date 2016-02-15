package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<String> wordBreak(String s, Set<String> dict) {
        List<String> rst = new ArrayList<>();
		if(s == null || s.length() <= 0 || dict == null || dict.size() <= 0 || 
				!canBreak(s, dict))
			return rst;
		
		//dfsSearch(s, dict, rst, new StringBuilder());
		dfsSearch(s, dict, 0, "", rst);
		return rst;
	}
	
	private void dfsSearch(String s, Set<String> dict, int startPos, String item, List<String> rst){
		if(startPos == s.length()){
			rst.add(item);
			return;
		}
		for(int i = startPos; i < s.length(); i++){
			String newWord = s.substring(startPos, i + 1);
			if(dict.contains(newWord)){
				String newItem = item.length() > 0 ? item + " " + newWord : newWord;
				dfsSearch(s, dict, i + 1, newItem, rst); // update start position			
			} // if : newWord
		} // for : i
	}
	
	
	private boolean canBreak(String s, Set<String> dict) {
		if(s == null || s.length() <= 0)
			return true;
		if(dict == null || dict.size() <= 0)
			return false;
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 0; i < s.length(); i++){
			if(!dp[i]) continue;
			for(int j = i + 1; j <= s.length(); j++){
				if(dict.contains(s.substring(i, j))){
					dp[j] = true;
					if(j == s.length())
						return true;
				}
			}// for : j
		} // for : i
		return dp[s.length()];
	}

}
