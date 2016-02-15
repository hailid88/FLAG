package com.tree.graphs;

public class IsBinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean checkBST(BinaryTreeNode root, int minVal, int maxVal){
		if(root == null){
			return true;
		}
		
		if(root.value <= minVal || root.value > maxVal){
			return false;
		}
		
		if(!checkBST(root.leftNode, minVal, root.value) || !checkBST(root.rightNode, root.value, maxVal))
		{
			return false;
		}
		
		return true;

				
				
//		if(root.leftNode.value > root.value || root.rightNode.value <= root.value){
//			return false;
//		}
//		
//		minVal = Math.min(root.leftNode.value, minVal);
//		maxVal = Math.max(root.rightNode.value, maxVal);
//		
//		isBinarySearch(root.leftNode, minVal, root.value);
//		isBinarySearch(root.rightNode, root.value, maxVal);
//		
//		return true;
		
	}

}
