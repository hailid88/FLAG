package com.stack.queue;
import java.util.Stack;

public class SimplifyPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/abc/...";
		SimplifyPath obj = new SimplifyPath();
		System.out.println(obj.simplifyPath(path));

	}
	
	/*
	 * 
Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
	 * 
	 */
	
	public String simplifyPath(String path) {
        if(path==null || path.length()<=0) return path;
        int n = path.length();
        
        Stack<String> s = new Stack<>();
        int start = 0, end = 0, i = 0;
        while(i<n){
        	if(path.charAt(i)=='/'){
        		start = ++i;
        		continue;
        	}
        	else{
        		while(i<n&&path.charAt(i)!='/'){
        			i++;
        		}
        		end = i;
        		String newStr = path.substring(start, end);
        		if(newStr == null || newStr.length()<=0){
        			continue;
        		}
        		if(newStr.equals("..")){
        			if(!s.isEmpty()){
        				s.pop();
        			}
        		}
        		else if(newStr.equals("."))
        			continue;
    			else
    				s.push(newStr);
        		
        	}
        }
        if(s.empty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!s.empty()){
        	sb.insert(0, "/");
        	sb.insert(1, s.pop());
        }
        return sb.toString();
    }

}
