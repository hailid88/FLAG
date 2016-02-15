package com.stack.queue;

import java.util.Stack;

public class StackToQueue {

	/**
	 * @param args
	 */
	//this is used to change the stack to queue. 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Stack<Integer> a = new Stack<Integer>();
	private Stack<Integer> b = new Stack<Integer>();
	
	public void enqueue(int newValue){
		if(a==null){
			a = new Stack<Integer>();
		}
		a.push(newValue);
	}
	
	public Integer dequeue(){
		while(a!=null && !a.empty())
			b.push(a.pop());
		if(b!=null && !b.empty()){
			return b.pop();
		}
		return null;
	}
}
