package com.stack.queue;
import com.linked.list.Node;

public class Stack {
	Node top = new Node();
	Object pop(){
		if(top!=null){
			Object item = top.data;
			top = top.next;
	        return item;
		}
		return null;
	}
	
	void push(int item){
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	
	Object peek(){
		return top.data;
	}

}
