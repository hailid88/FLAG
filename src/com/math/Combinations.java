package com.math;

import java.util.*;

public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> combine(int n, int k) {
        List finalResult = new ArrayList(); 
        if(k>n){return finalResult;}
        if(n==1 && k==0) return finalResult;
        if(k==1){
            for(int i = 1; i<=n; i++){
                List list = new ArrayList();
                list.add(i);
                finalResult.add(list);
            }
            return finalResult;
        }
        
        
        List<List<Integer>> result = combine(n-1, k);
        List<List<Integer>> result2 = combine(n-1, k-1);
        
        for(List<Integer> l:result2){
            l.add(n);
            finalResult.add(l);
        }
        
        finalResult.addAll(result);
        // for(List<Integer> l: result){
        //     finalResult.add(l);
        // }
        return finalResult;
        
    }

}
