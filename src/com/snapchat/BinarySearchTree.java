package com.snapchat;

public class BinarySearchTree {

	public static void main(String[] args) {
	    BST bst = new BST();
	    
	    System.out.println("size=" + bst.size());
	    bst.insert(1, 2);
	    System.out.println("size=" + bst.size());
	    bst.insert(2, 3);
	    System.out.println("size=" + bst.size());
	    bst.insert(3, 4);
	    bst.insert(3, 5);
	    System.out.println("size=" + bst.size());
	    
	    System.out.println("value of key 1=" + bst.get(1));
	    System.out.println("value of key 3=" + bst.get(3));
	    System.out.println("value of key 100=" + bst.get(100));
	    
	    
	    // check edge case
	    try{
	      bst.insert(null, 4);
	    }catch(Exception e){
	      System.out.println(e.getMessage());
	    }
	    
//	    try{
//	      bst.insert(null, null);
//	    }catch(Exception e){
//	      System.out.println(e.getMessage());
//	    }
	    
	    try{
	      bst.insert(4, null);
	    }catch(Exception e){
	      System.out.println(e.getMessage());
	    }
	    
	    System.out.println("size=" + bst.size());
	    System.out.println("value of key 4=" + bst.get(4));
	    
	  }
}


class Tree{
	  Object key = null, value = null;
	  Tree left = null, right = null;
	  
	  public Tree(Object key, Object value){
	    this.key = key;
	    this.value = value;
	    this.left = this.right = null;
	  }
}

class BST{
	  Tree root = null;
	  int numNodes = 0;
	  
	  public BST(){
	    this.root = null;
	    this.numNodes = 0;
	  }
  
  
	  void balance() {
	    //
	  }
  
	  void insert(Object key, Object value){
	    if(key == null)
	    	throw new RuntimeException("Invalid input: key cannot be null");
	    boolean isAdd = true;
	    if(root == null){
	      root = new Tree(key, value);
	    }
	    else
	      isAdd = recursiveInsert(root, key, value);
	    if(isAdd){
	    	numNodes++;
	    }
	  }
	  
	  private boolean recursiveInsert(Tree node, Object key, Object value){
	    if(node == null)
	      return false;
	    
	    
	    if(((node.key).toString()).compareTo(key.toString()) < 0){
	      if(node.right == null){
	        node.right = new Tree(key, value);
	        return true;
	      }
	      else
	        return recursiveInsert(node.right, key, value);
	    }
	    else if(((node.key).toString()).compareTo(key.toString()) > 0){
	      if(node.left == null){
	        node.left = new Tree(key, value);
	        return true;
	      }   
	      else
	        return recursiveInsert(node.left, key, value);
	    }
	    else{
	      System.out.println("The input key conflicts with the existing key value");
	      return false;
	    }
	  } // function
  
	  Object get(Object key){
	    if(key == null)
	      throw new RuntimeException("invalid input, key cannot be null");
	    return recursiveGet(root, key);
	  }
  
	  private Object recursiveGet(Tree node, Object key){
	    if(node == null)
	      return null;
	    if(((node.key).toString()).compareTo(key.toString()) < 0)
	      return recursiveGet(node.right, key);
	    else if(((node.key).toString()).compareTo(key.toString()) > 0)
	      return recursiveGet(node.left, key);
	    else
	      return node.value;
	  }
	  
	  int size(){
	    return numNodes;
	  }
}
