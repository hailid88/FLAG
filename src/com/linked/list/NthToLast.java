package com.linked.list;

//this class is used to 
public class NthToLast {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node nthToLast(Node node, int n){
		if(node==null || n < 1){
			return null;
		}
		
		Node p1 = node;
		Node p2 = node;
		
		for(int i = 0; i<n-1; i++){
			if(p2==null){
				return null;
			}
			p2=p2.next;
		}
		while(p2.next!=null){
			p2=p2.next;
			p1=p1.next;
		}
		return p1;
	}

}
