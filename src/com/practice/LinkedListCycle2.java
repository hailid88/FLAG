package com.practice;
import com.linked.list.Node;



/*
 *URL: http://oj.leetcode.com/problems/linked-list-cycle-ii/
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
 */

public class LinkedListCycle2 {
	public Node detectCycle(Node head) {
        Node p = head;
        Node q = head;
        while(q != null){
            p = p.next;
            q = q.next;
            if(q == null)
                return null;
            q = q.next;
            if(p == q)
                break;
        }
        if(q == null)
            return null;
        p = head;
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
