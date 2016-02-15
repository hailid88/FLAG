package com.datastructure;
import java.util.Iterator;

public class NewIterator implements Iterator{
	Iterator myIt = null;
	Integer next5 = null;
	public NewIterator(Iterator it){
		this.myIt = it;
		this.next5 = null;
	}
	@Override
	public boolean hasNext(){
		if(next5!=null) return true;
		while(myIt.hasNext()){
			Integer tmp = (int)myIt.next();
			if(tmp%5==0){
				next5 = tmp;
				return true;
			}
		}
		return false;
	}
	
	@Override 
	public Integer next(){
		if(hasNext()){
			Integer tmp = next5;
			next5=null;
			return tmp;
		}
		else{
			throw new RuntimeException("");
		}
	}
	
	@Override
	public void remove(){
		
	}
}
