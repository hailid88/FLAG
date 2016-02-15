package com.linked.list;

public class Node {
	public Node next = null;
	public int data;
	public Node(int d){
		this.data = d;
	}
	
	public Node(){
		
	}
	
	public int getData(){
		return data;
	}
	
	public void appendToTail(int d){
		Node end = new Node(d);
		Node now = this;
		while(now.next!=null){
			now = now.next;
		}
		now.next = end;
	}

	public int length(){
		Node n = this;
		int linkLen = 0;
		while(n!=null){
			linkLen++;
			n=n.next;
		}
		return linkLen;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		
		while(n!=null){
			System.out.println(n.data);
			n = n.next;
		}

	}

}
