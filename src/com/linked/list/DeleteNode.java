package com.linked.list;

public class DeleteNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(2);
		boolean haveDel = deleteNode(n);
		System.out.println(haveDel);

	}
	
	public static boolean deleteNode(Node input){
		if(input == null || input.next == null){
			return false;
		}
		input.data = input.next.data;
		input.next = input.next.next;
		return true;
	}

}
