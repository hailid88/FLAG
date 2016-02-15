package com.linkedin.onsite;
import java.util.*;

public class DeepIterator {
	Object nextItem = null;
	Stack<Iterator<?>> stack = new Stack<>();
	
	public DeepIterator(List input){
		if(input == null)
			throw new RuntimeException("the input is null");
		stack.add(input.iterator());
	}
	
	public boolean hasNext(){
		if(nextItem != null)
			return true;
		while(!stack.isEmpty()){
			Iterator<?> iter = stack.peek();
			if(iter.hasNext()){
				nextItem = iter.next();
				if(nextItem instanceof Integer)
					return true;
				else
					stack.push( ((Collection<?>)nextItem).iterator() );
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
		DeepIterator d = new DeepIterator(l);
		while(d.hasNext())
			System.out.println(d.next());
	}
}



















