package com.array.string;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		LongestCommonPrefix object = new LongestCommonPrefix();
		String[] strs = {"ccc", "cbc"};
		String output = object.longestCommonPrefix(strs);
		System.out.println(output);
		
	}
	
	public String longestCommonPrefix(String[] strs) {
		 if(strs.length==0 || strs[0].length()==0) return "";
	        int i;
	        for(i=0; i<strs[0].length(); i++){
	            for(int j =1; j<strs.length; j++){
	                if(strs[j].length()-1 < i || strs[j].charAt(i)!=strs[0].charAt(i)){
	                    return strs[0].substring(0, i);
	                }
	            }
	        }
	        return strs[0];
    }
}
