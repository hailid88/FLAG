package com.tree;

import java.util.Stack;

public class TheSameTree {
	
	public boolean isSameTreeR(TreeNode p, TreeNode q){
		if(p==null && q==null) return true;
		if(p==null ^ q==null) return false;
		if(p.val!=q.val) return false;
		return isSameTreeR(p.left, q.left)&&isSameTreeR(p.right, q.right);
	}
	
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null ^ q == null)
			return false;
		
        Stack<TreeNode> stackPTree =  new Stack<TreeNode>();
        Stack<TreeNode> stackQTree =  new Stack<TreeNode>();
        stackPTree.push(p);
        stackQTree.push(q);
        
        TreeNode pNode = p;
        TreeNode qNode = q;
        if(pNode.val != qNode.val)
    		return false;
        
        boolean done = false;
        boolean isP = false, isQ = false;
        while(!done){
        	if(pNode.left != null){
        		pNode = pNode.left;
        		stackPTree.push(pNode);
        		isP = true;
        	}
        	if(qNode.left != null){
        		qNode = qNode.left;
        		stackQTree.push(qNode);
        		isQ = true;
        	}
        	if(pNode.val != qNode.val || (isP ^ isQ))
        		return false;
        	if(isP && isQ){
        		isP = false;
        		isQ = false;
        		continue;
        	}
        	
        	pNode = stackPTree.pop();
        	qNode = stackQTree.pop();
        	if(pNode.right != null){
	        	pNode = pNode.right;
	    		stackPTree.push(pNode);
	    		isP = true;
        	}
        	if(qNode.right != null){
	    		qNode = qNode.right;
	    		stackQTree.push(qNode);
	    		isQ = true;
        	}
        	if(pNode.val != qNode.val || (isP && !isQ || isQ && !isP))
        		return false;
        	if(isP && isQ){
        		isP = false;
        		isQ = false;
        		continue;
        	}
        	
        	if(stackPTree.empty() || stackQTree.empty())
        		done = true;
        } // while
        
		return true;
    }
	
	public static void main(String[] args){
		TheSameTree theSameTree = new TheSameTree();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(20);
		root.right = new TreeNode(21);
		root.right.right = new TreeNode(21);
		root.right.right.right = new TreeNode(21);
		root.right.right.right.right = new TreeNode(21);
		
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(9);
		root2.left.left = new TreeNode(20);
		root2.right = new TreeNode(22);
		root2.right.right = new TreeNode(21);
		root2.right.right.right = new TreeNode(21);
		root2.right.right.right.right = new TreeNode(21);
		System.out.println(theSameTree.isSameTree(root2, root));
		
		int[] a = new int[10];
		System.out.println(a.length);
	}
}
