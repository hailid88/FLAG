package com.tree;
import java.util.Stack;


//great example. 
public class BSTIterator {
	
	public Stack<TreeNode> s = new Stack<TreeNode>();
	
	public BSTIterator(TreeNode root) {
        this.refreshStack(root);
    }
	
	private void refreshStack(TreeNode iter){
		while(iter!=null){
        	s.push(iter);
        	iter = iter.left;
        }
	}

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!s.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode root = s.pop();
        if(root!=null){
        	this.refreshStack(root.right);
        	return root.val;
        }
        throw new RuntimeException("Not exist");
         
    }


}
