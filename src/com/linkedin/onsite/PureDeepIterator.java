package com.linkedin.onsite;
import java.util.*;

public class PureDeepIterator {
	private Object nextItem = null;
	private Stack<MyIter> stack = new Stack<>();
	
	public PureDeepIterator(List input){
		if(input == null)
			throw new RuntimeException("the input is null");
		stack.add(new MyIter(input));
	}
	
	public boolean hasNext(){
		if(nextItem != null)
			return true;
		while(!stack.isEmpty()){
			MyIter iter = stack.peek();
			if(iter.hasNext()){
				nextItem = iter.next();
				//if(nextItem instanceof Integer)
				if(nextItem instanceof Integer)
					return true;
				else
					stack.push( new MyIter((List)nextItem));
			}
			else
				stack.pop();
		}
		return false;
	}
	
	public int next(){
		if(hasNext()){
			int rst = (int)nextItem;
			nextItem = null;
			return rst;
		}
		throw new NoSuchElementException("No next value");
	}
	
	public static void main(String[] args){
		List l = new ArrayList(), l1 = new ArrayList(), l2 = new ArrayList();
		l.add(1);
		l1.add(2);l1.add(3);l1.add(4);
		l1.add(l2);
		l.add(l1);
		l.add(new ArrayList());
//		l.add(4);
		PureDeepIterator d = new PureDeepIterator(l);
		while(d.hasNext())
			System.out.println(d.next());
	}
}

class MyIter{
	private int index = 0;
	private List input = null;
	public MyIter(List input){
		if(input == null)
			throw new RuntimeException("input is null");
		this.input = input;
		index = 0;
	}
	
	public boolean hasNext(){
		if(index >= input.size())
			return false;
		return true;
	}
	
	public Object next(){
		if(hasNext())
			return input.get(index++);
		throw new NoSuchElementException();
	}
}



















