package com.linkedin;

import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * The key to solve this problem is 
 * using a double linked list 
 * which enables us to quickly move nodes.
 * 
 * A hashmap is used to maintain the <key, value> pair, and it takes
 * O(1) to check whether the key exists or not
 */
public class LRUCache {

	private HashMap<Integer, DoubleLinkedListNode> map 
		= new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head = null;
	private DoubleLinkedListNode end = null;
	private int capacity;
	private int len;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
	}
	
	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);	// remove the node
			setHead(latest);	// set the node at head
			return latest.val;	// return the value
		} else {
			return -1;
		}
	}
	
	// remove the node from list
	public void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.next;
	
		if (pre != null) {
			pre.next = post;
		} else {
			head = post;
		}
	
		if (post != null) {
			post.pre = pre;
		} else {
			end = pre;
		}
	}
	
	// set the node to be head node
	public void setHead(DoubleLinkedListNode node) {
		node.next = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}
	
		head = node;
		if (end == null) {
			end = node;
		}
	}
	
	// set the key value
	public void set(int key, int value) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			DoubleLinkedListNode newNode = 
				new DoubleLinkedListNode(key, value);
			if (len < capacity) {
				setHead(newNode);
				map.put(key, newNode);
				len++;
			} else {
				// remove the end node
				map.remove(end.key);
				end = end.pre;
				if (end != null) {
					end.next = null;
				}
	
				// set the new node to be head node
				setHead(newNode);
				map.put(key, newNode);
			}
		}
	}
}

class DoubleLinkedListNode {
	public int val;
	public int key;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode next;
	
	public DoubleLinkedListNode(int key, int value) {
		val = value;
		this.key = key;
	}
}
