package com.linked.list;

public class AddLists {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node input1 = new Node(2);
		input1.appendToTail(8);
		input1.appendToTail(3);
		Node input2 = new Node(5);
		input2.appendToTail(6);
		input2.appendToTail(2);
		
		Node output = addListsSimple(input1, input2);
		
		while (output!=null){
			System.out.println(output.data);
			output=output.next;
		}
		
	}
	
	//The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
	public static Node addListsSimple(Node n1, Node n2){
		
		if(n1==null){
			return n2;
		}
		if(n2==null){
			return n1;
		}
		
		
		//method 1, initalize output with value. and then use appendToTail to solve the problem. 
		Node output = new Node((n1.data + n2.data)%10);
		int quotient = (n1.data + n2.data)/10;
		n1 = n1.next;
		n2 = n2.next;
		
		while(n1!=null && n2!=null){
			//method 1:
			output.appendToTail((n1.data + n2.data +  quotient)%10) ;
			quotient = (n1.data + n2.data +  quotient)/10;
					
			n1=n1.next;
			n2=n2.next;
		}
		while(n1==null && n2!=null){
			output.appendToTail((n2.data +  quotient) %10) ;
			quotient = (n2.data +  quotient )/10;
			n2=n2.next;
		}
		while(n2==null && n1!=null){
			output.appendToTail((n1.data +  quotient)%10);
			quotient = (n1.data +  quotient )/10;
			n1=n1.next;
		}
		
		return output;
		
	}
	
	//the digits are stored in forward order. 
	//1->2->3
	//2->4
	
	public static Node addListsHard(Node n1, Node n2){
		int n1Len = n1.length();
		int n2Len = n2.length();
		
		
		//first change the linkedlist to be in the same length. 
		if(n1Len > n2Len){
			n2 = padList(n2, n1Len - n2Len);
		}
		else{
			n1 = padList(n1, n2Len - n1Len);
		}
		
		//then we are trying to add l1 and l2. 
		
		
		return n1;
	}
	
   //reverse. and then add. and then reverse. 
	
	public static Node padList(Node node, int lenDiff){
		Node l1 = new Node(0);
		for(int i = 1; i<lenDiff; i++){
			l1.appendToTail(0);
		}
		Node preAdd = l1;
		while(preAdd.next!=null){
			preAdd = preAdd.next;
		}
		preAdd.next = node;
		return l1;
	}
	
	
	
	
}
