package com.snapchat;
import java.util.*;

public class LRUCache {

	/**
	 * @param args
	 */
	
/*
Design and implement a data structure for Least Recently Used (LRU) cache. It 
should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists 
in the cache, otherwise return -1.

set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used 
item before inserting a new item.
*/
	
	int capacity=0;
	int size=0;
	DoublyLinkedList head = null, tail = null;
	Map<Integer, DoublyLinkedList> hm = new HashMap<>();
	public LRUCache(int c){
		if(c<0){
			throw new RuntimeException("Invalid Input: capacity must be larger than 0");
		}
		this.capacity=c;
	}
	public int get(int key){
		if(hm.containsKey(key)){
			DoublyLinkedList node = hm.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		else{
			return -1;
		}
	}
	
	
	public void set(int key, int value){
		DoublyLinkedList node = null;
		if(hm.containsKey(key)){
			node = hm.get(key);
			remove(node);
			node.value = value;
		}
		else{
			node = new DoublyLinkedList(key, value);
			size++;
			if(size > capacity){
	  		    size--;
	  			hm.remove(tail.key);
	  			remove(tail);
	  		}
			
		}
		setHead(node);
		hm.put(key, node);
	}
	
	public void remove(DoublyLinkedList node){
		DoublyLinkedList next = node.next;
		DoublyLinkedList pre = node.pre;
		
		if(pre==null){
			head = next;
		}
		else{
			pre.next = next;
		}
		
		if(next==null){
			tail = pre;
		}
		else{
			next.pre = node.pre;
		}
	}
	
	public void setHead(DoublyLinkedList node){
		if(head ==null){
			head=node;
			tail=node;
		}
		else{
			node.next = head;
			head.pre = node;
			node.pre = null;
			head = node;
		}
	}

}

class DoublyLinkedList{
	int key;
	int value;
	DoublyLinkedList next=null, pre=null;
	public DoublyLinkedList(int k, int v){
		this.key = k;
		this.value = v;
		//this.pre=this.next=null;
	}
}
