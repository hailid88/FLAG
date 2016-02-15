package com.practice;

/**
 * http://oj.leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * @author Clarence
 *
 */

public class AddTwoNumbers {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
	 
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, intermediate = null;//new ListNode(0);//new ListNode();
        ListNode curNode = null;
        int sumValue = 0, remainder = 0;
        int multiple = 0, preMultiple = 0;
        
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        sumValue = l1.val + l2.val;
        multiple = sumValue / 10;
        remainder = sumValue % 10; 
        result = new ListNode(remainder);
        intermediate = result;
        while(true)
        {
            if(l1.next == null)
            {
                if(l2.next == null)
                    break;    
                l2 = l2.next;
                sumValue = l2.val + multiple;
            }
            else if(l2.next == null)
            {
                if(l1.next == null)
                    break;
                l1 = l1.next;
                sumValue = l1.val + multiple;
            }
            else{
                l1 = l1.next;
            	l2 = l2.next;
                sumValue = l1.val + l2.val + multiple;    
            }
            
            multiple = sumValue / 10;
            remainder = sumValue % 10;
            intermediate.next = new ListNode(remainder);
            intermediate = intermediate.next;
        }// while
        if(multiple > 0)
            intermediate.next = new ListNode(multiple);
        
        return result;
    } // function
}
