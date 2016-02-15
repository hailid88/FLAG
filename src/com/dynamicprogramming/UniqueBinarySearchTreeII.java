package com.dynamicprogramming;
import java.util.*;


public class UniqueBinarySearchTreeII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> result = new ArrayList<TreeNode>();
        if(n==0) {
        	result.add(null);
        	return result;
        }
        if(n==1){
        	TreeNode newNode = new TreeNode(1);
        	result.add(newNode);
        	return result;
        }
        
        List<TreeNode>[][] temp = new ArrayList[n+2][n+2];
        
        List<TreeNode> result1= generateTrees(1, n);
        List<TreeNode> result2 = generateTrees(1, n, temp);
        return result1;
        //return result2;
        
    }
	
	
	//this is the recursive solution, we can have dynamic programming solution. 
	public List<TreeNode> generateTrees(int l, int r) {
		List<TreeNode> result = new ArrayList<TreeNode>();
        if(l>r){
    		result.add(null);
        }
        if(l==r){
        	TreeNode newNode = new TreeNode(l);
        	result.add(newNode);
        	return result;
        }
        
		for(int i=l; i<=r; i++){
			List<TreeNode> lefts = generateTrees(l, i-1);
			List<TreeNode> rights = generateTrees(i+1, r);
			for(TreeNode left:lefts){
				for(TreeNode right:rights){
					TreeNode root = new TreeNode(i);
					root.left=left;
					root.right=right;
					result.add(root);
				}
			}
		}
		return result;
    }
	
	
	
	//dynamic programming solution. 
	public List<TreeNode> generateTrees(int left, int right, List<TreeNode>[][] temp){
		if(temp[left][right] != null)
			return temp[left][right];
		List<TreeNode> rst = new ArrayList<TreeNode>();
		if(left > right)
			rst.add(null);
		if(left == right){
			rst.add(new TreeNode(left));
		}
		else{
			for(int i = left; i <= right; i++){
				List<TreeNode> leftNodes = generateTrees(left, i - 1, temp);
				List<TreeNode> rightNodes = generateTrees(i + 1, right, temp);
				for(TreeNode leftNode : leftNodes){
					for(TreeNode rightNode : rightNodes){
						TreeNode root = new TreeNode(i);
						root.left = leftNode;
						root.right = rightNode;
						rst.add(root);
					}
				}
			}
		}
		temp[left][right] = rst;
		return rst;
	}

}
