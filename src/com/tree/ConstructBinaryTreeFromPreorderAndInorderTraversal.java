package com.tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        // boundary check
    	if(preorder == null || inorder == null)
    		return null;
    	
    	// length check
    	int lenP = preorder.length, lenI = inorder.length;	
    	if(lenP != lenI)
    		return null;
    	
    	// build tree
    	return buildTree(preorder, inorder, 0, lenP - 1, 0, lenI - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
    	// boundary check
    	if(preStart > preEnd || inStart > inEnd)
    		return null;
    
    	// build root: first element in preorder
    	TreeNode root = new TreeNode(preorder[preStart]);
    	
    	// find root in the inorder
    	int leftEnd = inStart;
    	while(leftEnd <= inEnd){
    		if(inorder[leftEnd] == root.val)
    			break;
    		leftEnd++;
    	}
    	leftEnd--;
    	preStart++;
    
    	// build left and right children
    	root.left = buildTree(preorder, inorder, preStart, preStart + leftEnd - inStart, inStart, leftEnd);
    	int rightStart = leftEnd + 2;
    	root.right = buildTree(preorder, inorder, preEnd - (inEnd - rightStart), preEnd, rightStart, inEnd);
    	return root;
    }

}
