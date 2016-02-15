package com.practice;
import com.linked.list.Node;

public class LinkedListCycle {
	public boolean hasCycle(Node head) {
        if(head == null)
            return false;
        Node p = head;
        Node q = head;
        while(q != null){
            p = p.next;
            q = q.next;
            if(q == null)
                return false;
            q = q.next;
            if(p == q)
                return true;
        }
        return false;
    }
}
