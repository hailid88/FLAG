package com.microsoft;

import java.util.Stack;

public class MinStack {
	Stack<Integer> s  = new Stack<>();
	Stack<Integer> min = new Stack<>();
	
	public int getMin(){
		return min.peek();
	}
	
	public void push(int item){
		s.push(item);
		if(min.isEmpty() || item<=min.peek()){
			min.push(item);
		}
	}
	public Integer pop(){
		Integer tmp = s.pop();
		if(tmp.equals(min.peek())){
			min.pop();
		}
		return tmp;
	}
}
