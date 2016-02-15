package com.microsoft;

public class ArrayFromPostOrderBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {5,7,6,12,11,10,8};
		int[] a = {1,6,2,4};
		ArrayFromPostOrderBinarySearchTree obj = new ArrayFromPostOrderBinarySearchTree();
		System.out.println(obj.isPostorderResult(a));
	}
	
	public boolean isPostorderResult(int[] a){
		if(a==null || a.length<=0) return false;
		int n = a.length;
		return helper(a, 0, n-1);
	}
	
	
	public boolean helper(int[] a, int s, int e){
		if(s>=e) return true;
		int root = a[e];
		int i = e-1;
		while(i>=s && a[i]>a[e]) i--;
		if(!helper(a, i+1, e-1)) return false;
		
		//if(i==s-1) return true;
		int k = i;
		while(i>=s && a[i]<a[e]) i--;
		if(i!=s-1) return false;
		return helper(a, s, k);
	}

}
