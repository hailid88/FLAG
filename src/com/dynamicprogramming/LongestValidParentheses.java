package com.dynamicprogramming;
import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 0)
			return 0;
		int maxLen = 0, last = -1, curr=0, n = s.length();
		Stack<Integer> pos = new Stack<>();
		for(int i = 0; i < n; i++){
			if(s.charAt(i) == '(')
				pos.push(i);
			else{
				if(pos.isEmpty())
					last = i;
				else 
				    curr = pos.pop();
				maxLen = pos.isEmpty() ? Math.max(maxLen, i-last) : Math.max(maxLen, i - curr+1);
			} // if - else
		} // for : i
		return maxLen;
    }
    
    
    public int longestValidParentheses2(String s){
    	int count=0;
        int max=0;
        boolean[] visited=new boolean[s.length()]; // use boolean array to mark the valid parentheses

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                int j=i-1;
                while(j>=0){
                    if(s.charAt(j)=='(' && visited[j]==false){
                        visited[j]=true;
                        visited[i]=true;
                        break;
                    }
                    j--;
                }
            }
        }

        // look for the longest valid parentheses length
        for(boolean v:visited){
            if(v==true){
                count++;
            }else{
                if(count>max) max=count;
                count=0;
            }
        }

        if(count>max) max=count;

        return max;

    }

}
