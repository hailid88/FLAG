package com.tree;

import java.util.Stack;

public class BinarySearchTreeTwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(12);
		int target = 21;
		boolean resl = twoSum(root, target);
		System.out.println(resl);

	}
	
	public static boolean twoSum(TreeNode root, int target){
		//no element
		if(root == null) return false;
		//only two elements
		if(root.left==null && root.right == null) return false;
		boolean inorder = false;
		boolean reverseInorder = false;
		TreeNode ioCurr = root;
		Stack<TreeNode> ioStack = new Stack<>();
		Stack<TreeNode> rioStack = new Stack<>();
		TreeNode rioCurr = root;
		int ioCurVal = 0;
		int rioCurVal = 0;
		while(true){
			while(!inorder){
				if(ioCurr!=null){
					ioStack.push(ioCurr);
					ioCurr = ioCurr.left;
				}
				else{
					TreeNode temp1 = ioStack.pop();
					ioCurVal = temp1.val;
					ioCurr = temp1.right;
					inorder = true;
				}
			}
			while(!reverseInorder){
				if(rioCurr!=null){
					rioStack.push(rioCurr);
					rioCurr = rioCurr.right;
				}
				else{
					TreeNode temp2 = rioStack.pop();
					rioCurVal = temp2.val;
					rioCurr = temp2.left;
					reverseInorder = true;
				}
			}
			
			if(ioCurVal + rioCurVal == target){
				return true;
			}
			else if(ioCurVal + rioCurVal > target){
				reverseInorder = false;
			}
			else{
				inorder = false;
			}
			
			if (ioCurVal >= rioCurVal)
	            return false;
		}
		
	}

}
