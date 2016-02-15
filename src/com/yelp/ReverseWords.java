package com.yelp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    	BufferedReader r = null;
        try{
            r = new BufferedReader(new InputStreamReader(System.in));
            String s = r.readLine();
            s = reverseWords_my(s);
            System.out.println("'"+s+"'");
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
        	if(r != null)
        		r.close();
        }
        
    }
	
	
	
	public static String reverseWords_my(String s) {
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
        	//go from the end of the string to front, if came across a space, end. It illustrates that there is a word. 
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
	
	public static String reverseWords(String s){
        if(s == null || s.length() <= 0)
                return s;
        StringBuilder sb = new StringBuilder();
        int right = -1;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(right == -1 && c != ' ')
                    right = i + 1;
            if(right != -1 && c == ' '){
                   sb.append(s.substring(i+1, right));
                   sb.append(' ');
                   right = -1;
            } // if
        } // for : i
        if(right != -1)
            sb.append(s.substring(0, right));
        else{
            if(sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    } // function
}
	

