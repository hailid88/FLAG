package com.tree;

public class FirstCommonAncestor {
	
	public WrapperResult getFCA(TreeNode root, TreeNode n1, TreeNode n2){
		if(root == null) return new WrapperResult(root, 0);
		
		if(root == n1 && root == n2)		
			return new WrapperResult(root, 2);

		int curNodeValue = 0;
		if(root == n1 || root == n2)		// error occurs since left and right has not compared
			curNodeValue =  1;
		
		WrapperResult leftResl = this.getFCA(root.left, n1, n2);
		if(leftResl.findNum == 2)
			return leftResl;
		
		WrapperResult rightResl = this.getFCA(root.right, n1, n2);
		if(rightResl.findNum == 2)
			return rightResl;
		
		return new WrapperResult(root, leftResl.findNum + rightResl.findNum + curNodeValue);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		FirstCommonAncestor firstCA = new FirstCommonAncestor();
		TreeNode n1 = root.right.right;
		TreeNode n2 = root.right.left;
		WrapperResult obj= firstCA.getFCA(root, n1, n2);
		if(obj.findNum==2){
			System.out.println(obj.fca.val);
			System.out.println(obj.findNum);
		}
		else{
			System.out.println("No common ancestor");
		}
		
	}
}


class WrapperResult{
	TreeNode fca;
	int findNum;
	public WrapperResult(TreeNode n, int num){
		this.fca=n;
		this.findNum = num;
	}
}

