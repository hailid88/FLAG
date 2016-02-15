package com.tree;
import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * @param args
	 * 
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//pay attention. 
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List rst = new ArrayList();
		if(root == null)
			return rst;
		
		Stack<TreeNode> currentLayer = new Stack<>();
		currentLayer.push(root);
		boolean leftToRight = true;
		int layer = 0;
		
		while(!currentLayer.isEmpty()){
			List<Integer> solution = new ArrayList<>();
			Stack<TreeNode> nextLayer = new Stack<>();
			while(!currentLayer.isEmpty()){
				TreeNode node = currentLayer.pop();
				solution.add(node.val);
				if(leftToRight){
					if(node.left != null)
						nextLayer.push(node.left);
					if(node.right != null)
						nextLayer.push(node.right);
				}
				else{
					if(node.right != null)
						nextLayer.push(node.right);
					if(node.left != null)
						nextLayer.push(node.left);
				}
			}
			currentLayer = nextLayer;
			leftToRight = !leftToRight;
			rst.add(solution);
		} // while
		
		return rst;
    }

}



//test case
/*
       1
   2       3
 4   5   6   7
1 2 3 4 5 6 7 8

1
32
4567

queue
1
32
6745 //not correct. 

stack
1
23    3 2   first left then right
7654  4567  first right then left
12345678    first left then right   

 
*/