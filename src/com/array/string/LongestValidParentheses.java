package com.array.string;
import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ")()())()()(";
		LongestValidParentheses obj = new LongestValidParentheses();
		System.out.println(obj.longestValidParentheses(s));

	}
	
	public int longestValidParentheses(String s){
		if(s == null || s.length() <= 0)
			return 0;
		int maxLen = 0, last = -1, n = s.length();
		Stack<Integer> pos = new Stack<Integer>();
		for(int i = 0; i < n; i++){
			if(s.charAt(i) == '(')
				pos.push(i);
			else{
				if(pos.isEmpty())
					last = i;
				else 
				    pos.pop();
				maxLen = pos.isEmpty() ? Math.max(maxLen, i - last) : Math.max(maxLen, i - pos.peek());
			} // if - else
		} // for : i
		return maxLen;
	}

}
