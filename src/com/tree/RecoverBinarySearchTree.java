package com.tree;

public class RecoverBinarySearchTree {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	TreeNode n1 = null, n2 = null, pre = null;
	public void recoverTree(TreeNode root) {
        inorderT(root);
        if(n1!=null && n2!=null){
        	int tmp = n1.val;
        	n1.val = n2.val;
        	n2.val = tmp;
        }
    }
	
	private void inorderT(TreeNode root){
		if(root == null) return;
		inorderT(root.left);
		
		if(pre!=null){
			if(pre.val>root.val){
				if(n1==null){
					n1 = pre;
				}
				n2 = root;
			}
		}
		pre = root;
		inorderT(root.right);
	}

}
