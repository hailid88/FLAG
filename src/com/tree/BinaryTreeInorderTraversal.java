package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//very classical dfs. dfs should use stack while bfs should use queue. 
public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderTree = new ArrayList<Integer>();
        if(root == null) return inorderTree;
        
        Stack<TreeNode> stackTree = new Stack<TreeNode>();
        
        stackTree.push(root);
        while(!stackTree.empty()){
            while(root.left != null){
                root = root.left;
                stackTree.push(root);
            }
            while(!stackTree.empty()){
                root = stackTree.pop();
                inorderTree.add(root.val);
                if(root.right != null){
                    root = root.right;
                    stackTree.push(root);
                    break;
                }
            }
        }
        return inorderTree;
    }
	
	
	
	public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> inorderTree = new ArrayList<Integer>();
        if(root == null) return inorderTree;
        
        Stack<TreeNode> stackTree = new Stack<TreeNode>();
        
        boolean flag = true;
        while(flag){
            if(root!=null){
            	stackTree.push(root);
                root = root.left;
            }
            else{
            	if(!stackTree.isEmpty()){
            		root = stackTree.pop();
            		inorderTree.add(root.val);
		    		root = root.right;
            	}
            	else{
            		flag = false;
            	}
               
               
               
            }
        }
        return inorderTree;
    }
	
	public List<Integer> inoderRec(TreeNode root){
		List<Integer> resl = new ArrayList<>();
		if(root == null) return resl;
		List<Integer> left = inoderRec(root.left);
		resl.addAll(left);
		resl.add(root.val);
		List<Integer> right = inoderRec(root.right);
		resl.addAll(right);
		
		return resl;
		
//	    if(root == null) return null;
//	    if(root.left==null && root.right==null ){
//	        List<Integer> list = new ArrayList<Integer>();
//	        list.add(root.val);
//	        return list;
//	    }
//	    List<Integer> list = new ArrayList<Integer>();
//	    List<Integer> left = inoderRec(root.left);
//	    list.addAll(left);
//	    list.add(root.val);
//	    List<Integer> right = inoderRec(root.right);
//	    list.addAll(right);
//	    return list;
	}
	
	public void inorderRec(TreeNode root, ArrayList<Integer> resl){
		if(root == null) return;
		inorderRec(root.left, resl);
		resl.add(root.val);
		inorderRec(root.right, resl);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(18);
		root.right = new TreeNode(21);
		root.right.right = new TreeNode(22);
		root.right.right.right = new TreeNode(23);
		root.right.right.right.right = new TreeNode(24);
		
		BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
		
		
		//List<Integer> a = b.inoderRec(root);
		List<Integer> a = b.inorderTraversal2(root);
		//ArrayList<Integer> a = new ArrayList<>();
		//b.inorderRec(root, a);
		for (Integer i : a)
			System.out.println(i);
		
		String aa = "Test";
		System.out.println(aa.length());
		
	}

}
