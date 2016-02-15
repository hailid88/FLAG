package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintInLayer {

	public void printInLayer(TreeNode root){
		if(root == null)
			return;
		
		ArrayList<TreeNode> parents = new ArrayList<TreeNode>();
	    ArrayList<TreeNode> children = null;
		parents.add(root);
		
		while(!parents.isEmpty()){
			children = new ArrayList<TreeNode>();
			for(TreeNode parent : parents){
				if(parent != null)
					System.out.print(parent.val + ",");
				if(parent.left != null)
					children.add(parent.left);
				if(parent.right != null)
					children.add(parent.right);
			}
			System.out.println();
			parents = children;
		}
		
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(20);
		root.right = new TreeNode(21);
		root.right.right = new TreeNode(18);
		root.right.right.right = new TreeNode(19);
		root.right.right.right.right = new TreeNode(16);
		
		PrintInLayer printInLayer = new PrintInLayer();
		printInLayer.printInLayer(root);
	}

}
