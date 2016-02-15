package com.tree;

import java.util.*;
import com.tree.TreeNode;


/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */

/*
 * The key to iterative postorder traversal is the following:

The order of : left child -> right child -> parent node.
Find the relation between the previously visited node and the current node
Use a stack to track nodes
*/

/*
 * First I give out the recursive solution, then do iteratively. 
 * 
 * Printing the contents of the tree in a Postorder way.
 * The recursive solution of the binary tree can be found in http://www.javabeat.net/binary-search-tree-traversal-java/
 *
public void printPostorder() {
  printPostOrderRec(root);
  System.out.println("");
}

private void printPostOrderRec(Node currRoot) {
  if (currRoot == null) {
    return;
  }
  printPostOrderRec(currRoot.left);
  printPostOrderRec(currRoot.right);
  System.out.print(currRoot.value + ", ");

}
 * 
 * 
 */


public class BinaryTreePostorderTraversal {
//	public ArrayList<Integer> postorderTraversal(TreeNode root) {
//        TreeNode last = null;
//        TreeNode node = null;
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        if(root != null)
//            stack.push(root);
//        while(!stack.isEmpty()){
//            node = stack.peek();
//            if(last == null || last.left == node || last.right == node){
//                if(node.left != null)
//                    stack.push(node.left);
//                else if(node.right != null)
//                    stack.push(node.right);
//            } else if(node.left == last){
//                if(node.right != null)
//                    stack.push(node.right);
//            } else{
//                node = stack.pop();
//                list.add(node.val);
//            }
//            last = node;
//        }
//        return list;
//    }
	
	
	//very very nice. 
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
		if(root == null)
			return rst;
		Stack<TreeNode> traverse = new Stack<>(), output = new Stack<>();
		traverse.add(root);
		
		while(!traverse.isEmpty()){
			TreeNode peek = traverse.pop();
			if(peek.left != null)
				traverse.push(peek.left);
			if(peek.right != null)
				traverse.push(peek.right);
			output.push(peek);
		} // while
		
		while(!output.isEmpty())
			rst.add((output.pop()).val);
		return rst;
	}
	
	
	
	//recursive solution. Very simple. 
	private void postorderTraversalR(TreeNode root, List<Integer> rst){
		if(root == null)
			return;
		postorderTraversalR(root.left, rst);
		postorderTraversalR(root.right, rst);
		rst.add(root.val);
	}
}
