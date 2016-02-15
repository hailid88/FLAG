package com.dynamicprogramming;

public class WildcardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isMatch(String s, String p) {
		if(s == null || p == null)
			return p == null && s == null;
			
		int i = 0, j = 0, lastStar = -1, mark = 0;
		while(i < s.length()){
			if(j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
				i++;
				j++;
			}
			else if(j < p.length() && p.charAt(j) == '*'){ // record the star status
				lastStar = j++;
				mark = i;
			}
			else{
				if(lastStar == -1)
					return false;
				i = mark+1;
				mark = i;
				j = lastStar + 1;
			}
		} // while : i, j
		
		while(j < p.length() && p.charAt(j) == '*')
			j++;
		
		return j == p.length();
    }

}
