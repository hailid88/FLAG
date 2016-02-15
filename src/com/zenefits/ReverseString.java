package com.zenefits;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String reverseStr(String s){
		//if s is null or empty. 
        if(s==null)
        	return "";
        
        //first use trim to delete the space at the front and the end of the string. 
        s = s.trim();
        
        StringBuffer sb = new StringBuffer();
        
        int sLen=s.length();
        
        //go from the end of the string since we need to reverse the words. 
        int last = sLen -1;
        int i=last;
        
        while(i>=0){
        	//go from the end of the string to front, if came across a space, end. It illustrate that there is a word. 
        	while(i>=0&&s.charAt(i)!=' '){
        		i--;
        	}
        	// i is pointing to ' ', so from i+1. 
        	String temp = s.substring(i+1,last+1);
        	
        	sb.append(temp);
        	
        	//delete all the duplicate space. 
        	while(i>=0&&s.charAt(i)==' '){
        		i--;
        	}
        	last = i;
        	if (last>=0)
        	{
        	    sb.append(" ");
        	}
        }
        
        return sb.toString();
    }
}
