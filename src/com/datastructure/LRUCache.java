package com.datastructure;
import java.util.*;

/**
 * Design and implement a data structure for 
 * Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key 
if the key exists in the cache, otherwise return -1.

set(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.
 * 
 * 
 * Solution:
 * 	1. The key is to create a hashmap and a doublelinkedlist to fastly remove or add cache
 *  2. Remove the cache from the end, if the capacity is reached
 *  3. add the cache at the head
 *  4. when use the get function, move the <key, value> pair to the head of the list
 *  5. one function is used to set head
 *  6. another function is used to remove a node
 *  7. Note for the condition when head or end is empty
 */

public class LRUCache {
	  int size = 0;
	  int capacity = 0;
	  DoublyLinkedList head = null, end = null;
	  Map<Integer, DoublyLinkedList> map = new HashMap<Integer, DoublyLinkedList>();
	  
	  public LRUCache(int capacity) {
	  	if(capacity <= 0) return;
	    this.capacity = capacity;
	    this.size = 0;
	    this.head = this.end = null;
	  }
	  
	  public int get(int key) {
	  	DoublyLinkedList node = map.get(key);
	  	if(node == null)
	  		return -1;
	  	removeNode(node);
	  	setHead(node);
	  	return node.value;
	  }
	  
	 
	  public void set(int key, int value) {
	  	DoublyLinkedList node = map.get(key);
	  	
	  	if(node == null){
	  		size++;
	  		if(size > capacity){
	  		    size--;
	  			map.remove(end.key);
	  			removeNode(end);
	  		}
	  		node = new DoublyLinkedList(key, value);
	  	}
	  	else{
	  		removeNode(node);  //first remove the link. 
	  		node.value = value;
	  	}
	  	setHead(node);
	  	map.put(key, node);
	  }
	  
	  private void removeNode(DoublyLinkedList node){
	  	DoublyLinkedList pre = node.pre, next = node.next;
	  	if(pre == null)
	  		head = next;
	  	else
	  		pre.next = next;
	  		
	  	if(next == null)
	  		end = pre;
	  	else
	  		next.pre = pre; 		
	  }
	  
	  private void setHead(DoublyLinkedList node){
	  	node.next = head;
	  	node.pre = null;
	  	if(head != null)
	  		head.pre = node;
	  	head = node;
	  	if(end == null)
	  		end = node;
	  }
	}

	class DoublyLinkedList{
		DoublyLinkedList pre = null, next = null;
		int key = 0, value = 0;
		
		public DoublyLinkedList(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
