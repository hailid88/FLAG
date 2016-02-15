package com.stack.queue;
import com.linked.list.Node;

public class Queue {
	Node first, last;
	
	public void enQueue(int item){
		Node t = new Node(item);
		if(first==null){
			last = t;
			first = last;
		}
		else{
		last.next=t;}
	}
	
	public void enQueue(Node item){
		if(first==null){
			last = item;
			first = last;
		}
		else{
			last.next=item;
		}
	}
	
	
	Object deQueue(){
		if(first!=null){
			Object result = first.data;
			first = first.next;
			return result;
			}
		else{
			return null;
		}
	}
}
