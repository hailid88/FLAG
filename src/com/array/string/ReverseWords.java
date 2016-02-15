package com.array.string;

import java.io.*;
public class ReverseWords {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	BufferedReader r = null;
        try{
            r = new BufferedReader(new InputStreamReader(System.in));
            String s = r.readLine();
            s = reverseWords(s);
            System.out.println(s);
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
        	if(r != null)
        		r.close();
        }
        
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