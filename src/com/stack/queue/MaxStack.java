package com.stack.queue;
import java.util.Stack;

public class MaxStack {
	Stack<Integer> s = new Stack<>(), maxStack = new Stack<>();
	
	public void push(Integer x){
		s.push(x);
		if(maxStack.isEmpty()||maxStack.peek()<=x){
			maxStack.push(x);
		}
	}
	
	public void pop() {
		Integer temp = s.pop();
		if(temp==maxStack.peek()){
			maxStack.pop();
		}
	}
	
	public Integer getMax(){
		return maxStack.peek();
	}

}
