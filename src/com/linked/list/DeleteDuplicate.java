package com.linked.list;
import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.LinkedList;
import java.util.HashSet;

public class DeleteDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "Hello";
//		String j = s;
//		s= "Hello world";
//		System.out.println(s);
//		System.out.println(j);
		Node n = new Node(1);
//		n.appendToTail(2);
//		n.appendToTail(3);
		n.appendToTail(1);
//		n.appendToTail(2);
//		n.appendToTail(2);
//		n.appendToTail(2);
		Node output = deleteDuplicates(n);
		while(output!=null){
			System.out.println(output.data);
			output = output.next;
		}
	}
	
	public static Node deleteDup(Node n){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		//the things in HashMap must be an Object. like int should be Integer, boolean should be Boolean
		Node previous = null;
		Node f = n;
		while(n!=null){
			if(map.containsKey(n.data)){
				previous.next = n.next;
			}
			else{
				map.put(n.data, true);
				previous = n;
			}
			n= n.next;
		}
		return f;
	}
	
	public static Node deleteDup_set(Node n){
		HashSet<Integer> set = new HashSet<Integer>();
		Node head = n;
		//if(head==null){return null;}
		//set.add(head.data);
		while(n!=null){
			if(!set.add(n.data) && n.next!=null){
				n.data = n.next.data;
			}
			else{
				n.next=n.next.next;
			}
			n=n.next;
		}
		
		return head;
	}
	
	
	public static Node deleteDuplicates(Node head) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node current = head;
        while(current!=null){
            if(set.add(current.data)){
                current=current.next;
            }
            else{
                if(current.next!=null){
                    current.data = current.next.data;
                    current.next = current.next.next;
                    current = current.next;
                }
                else{
                    current = null;
                    return head;
                }
                
            }
        }
        return head;
    }
	
	public static Node deleteDup2(Node n){
		Node current = n;
		if(current==null || current.next==null){
			return current;
		}
		Node runner = n;
		while(current!=null){
//			while (runner!=null && runner.next!=null){
//				if(runner.next.data == current.data){
//					runner.next = runner.next.next;
//				}
//				runner = runner.next;
//			}
			runner = current.next;
			while (runner!=null){
				if(runner.data == current.data){
					if(runner.next!=null){
					runner.data = runner.next.data;
					runner.next = runner.next.next;
					//runner = runner.next;
					}
					else{
						current.data = current.next.data;
						current.next = current.next.next;
						runner = runner.next;
					}
				}
				else{
				runner = runner.next;}
			}
			current = current.next;
			//runner = current;
		}
		
		return n;
	}
}
