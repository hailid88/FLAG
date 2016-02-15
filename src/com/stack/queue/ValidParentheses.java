package com.stack.queue;
import java.util.Stack;

public class ValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>(); 
		char[] sChar = s.toCharArray();
		for(char c:sChar){
			if(c=='(' || c == '{' || c=='['){
				stack.push(c);
			}else{
				if(!stack.isEmpty()&&is_valid(stack.peek(), c)){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.isEmpty();
		
	}
	public boolean is_valid(char a, char b){
		if((a=='(' && b==')')||(a=='{' && b=='}')||(a=='[' && b==']')){
			return true;
		}
		else{
			return false;
		}
	}

}
