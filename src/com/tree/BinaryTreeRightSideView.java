package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		List<Integer> resl = rightSideView(root);
		for(Integer item:resl){
			System.out.println(item);
		}

	}
	
	public static List<Integer> rightSideView(TreeNode root){
		List<Integer> resl = new ArrayList<>();
        if(root == null) return resl;
        Queue<TreeNode> preLayer = new LinkedList<>();
        
        preLayer.offer(root);
        resl.add(preLayer.peek().val);
        while(!preLayer.isEmpty()){
        	int n = preLayer.size();
            for(int i = 0; i<n; i++){
                TreeNode temp = preLayer.poll();
                if(temp.right!=null){
                    preLayer.offer(temp.right);
                }
                if(temp.left!=null){
                    preLayer.offer(temp.left);
                }
            }
            if(!preLayer.isEmpty()){
                resl.add(preLayer.peek().val);
            }
        }
        
        return resl;
	}

}
