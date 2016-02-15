package com.backtracking;
import java.util.*;

public class GenerateParentheses {

	/**
	 * @param args
	 *
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<String> generateParenthesis(int n) {
		
        List<String> newResult = new ArrayList<String>();
        if(n<1) return newResult;
        newResult.add("()");
        if(n==1) return newResult;
        List<String> preResult = generateParenthesis(n-1);
        Set<String> hs = new HashSet<String>();
        for(int i=0; i<preResult.size(); i++){
        	String curr = preResult.get(i);
        	for(int j =0; j<curr.length(); j++){
        		if(curr.charAt(j)=='('){
        			hs.add(curr.substring(0, j+1) + "()" + curr.substring(j+1, curr.length()));
        		}
        	}
        	hs.add("()" + curr);
        }
        newResult = new ArrayList<String>(hs);
        return newResult;
    }

}
