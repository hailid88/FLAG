package com.array.string;
import java.util.*;

public class GeneratesParentheses {

	/**
	 * @param args
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
       			//add () to the right of '('
       			hs.add(curr.substring(0, j+1) + "()" + curr.substring(j+1, curr.length()));
       		}
       	}
       	hs.add("()" + curr);
       }
       newResult = new ArrayList<String>(hs);
       return newResult;
   }

}
