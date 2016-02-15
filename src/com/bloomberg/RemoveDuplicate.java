package com.bloomberg;
import java.util.*;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 3, 1, 1, 5, 7, 7};
		RemoveDuplicate obj = new RemoveDuplicate();
		int end = obj.removeDuplicate2(a);
		for(int i = 0; i<=end; i++){
			System.out.print(a[i]);
			System.out.print(", ");
		}

	}
	
	//this int is the endindex. 
	//remain unique elements. Get unique. 
	public int removeDuplicate(int[] a){
		if(a==null || a.length<=1) return 0;
		Arrays.sort(a);
		int i = 0, j=1;
		while(j<a.length){
			if(a[i]==a[j]){
				j++;
			}
			else{
				i++;
				a[i] = a[j];
				j++;
			}
		}
		return i;
	}
	
	//remain only the elements that appear once. 
	public int removeDuplicate2(int[] a){
		if(a==null || a.length<=1) return 0;
		Arrays.sort(a);
		int j=0;
		for(int i = 0; i<a.length; i++){
			if(i>0 && a[i]==a[i-1]) continue;
			if(i<a.length-1 && a[i]==a[i+1]) continue;
			a[j] = a[i];
			j++;
		}
		return j-1;
	}

}
