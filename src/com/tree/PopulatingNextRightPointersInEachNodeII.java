package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//use Queue.
	public void connect(TreeLinkNode root) {
		if(root==null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            TreeLinkNode tmp = q.poll();
            if(tmp.left!=null) q.offer(tmp.left);
            if(tmp.right!=null) q.offer(tmp.right);
            for(int i = 1; i<n; i++){
                tmp.next = q.poll();
                tmp = tmp.next;
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
            }
        }
    }
	
	
	//a bit hard to solve this problem. 
	//use only constant space. 
	public void connect_super(TreeLinkNode root) {
        if(root == null)
			return;
		TreeLinkNode cur = root, head = null, pre = null;
		while(cur != null){
			// visit one layer and construct next pointer in next layer
			// if pre is null, meaning that this node is the first node in the next layer
			while(cur != null){
				if(cur.left != null){
					if(pre != null)
						pre.next = cur.left;
					else
						head = cur.left;
					pre = cur.left; // update pre to be its next or the first node
				}
				if(cur.right != null){
					if(pre != null)
						pre.next = cur.right;
					else
						head = cur.right;
					pre = cur.right;
				}
				cur = cur.next;
			} // while: visit and link each layer
			
			cur = head;
			head = null;
			pre = null;
		}// while: visit and link the tree
    }
	
	
	

}


