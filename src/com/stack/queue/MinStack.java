package com.stack.queue;
import java.util.Stack;

public class MinStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack obj = new MinStack();
		obj.push(3);
		obj.pop();
		System.out.println(obj.getMin());

	}
	Stack<Integer> stack = new Stack<Integer>(), minStack = new Stack<Integer>();
	public void push(int x) {
    	stack.push(x);
    	if(minStack.empty() || x <= minStack.peek())
    		minStack.push(x);
    }

    public void pop() {
    	int x = stack.pop();
    	if(x == minStack.peek())
    		minStack.pop();
    }

    public int top() {
    	return stack.peek();
    }

    public int getMin() {
    	return minStack.peek();
    }

}
