package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//very classical bfs. 
public class BinaryTreeLevelOrder {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right= new TreeNode(3);
		root.right.right = new TreeNode(4);
		BinaryTreeLevelOrder object = new BinaryTreeLevelOrder();
		List<List<Integer>> output = object.levelOrder(root);
		for(List<Integer> ls:output){
			for(Integer item:ls){
				System.out.print(item);
				System.out.print(" ");
			}
			System.out.println();
		}

	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List output = new ArrayList();
        if(root==null) return output;
    
        Queue<TreeNode> parent = new LinkedList<TreeNode>();
        parent.add(root);
                
        while(!parent.isEmpty()){
            List input = new ArrayList<Integer>();
            int n = parent.size();
            for(int i = 0; i<n; i++){
            	TreeNode temp = parent.poll();
            	input.add(temp.val);
            	if(temp.left!=null){
            		parent.add(temp.left);
            	}
            	if(temp.right!=null){
            		parent.add(temp.right);
            	}
            }
            output.add(input);
        }
       
        return output;  
    }

}
