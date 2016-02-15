package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> grayCode(int n) {
        
        List<Integer> intLs = new ArrayList<Integer>();
        
       // if(n<1) return intLs;
        
        intLs.add(0);
        
        for(int i = 0; i<n; i++){
            
            int len = intLs.size();
            int addpart = 1<<i;
            
            for(int j = len-1; j>=0; j--){
                intLs.add(intLs.get(j) + addpart);
            }
            
        }
        
        return intLs;
        
    } 

}
