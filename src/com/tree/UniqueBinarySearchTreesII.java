package com.tree;
import java.util.*;
public class UniqueBinarySearchTreesII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> rst = new ArrayList<TreeNode>();
		if(n <= 0){
			rst.add(null);
			return rst;
		}
		if(n == 1){
			rst.add(new TreeNode(1));
			return rst;
		}
		List<TreeNode>[][] temp = new ArrayList[n+2][n+2];
		rst = generateTrees(1, n, temp);
		return rst;
	}
	
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
