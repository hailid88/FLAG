package com.array.string;
import java.util.*;

public class SubsetsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,2,3};
		
		SubsetsII obj =  new SubsetsII();
		List<List<Integer>> output = obj.subsetsWithDup(num);
		
		int a = 1;

	}
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
        List result = new ArrayList();
        List<Integer> curr = new ArrayList<Integer>();
        result.add(curr);
		if(num==null || num.length<=0) return result; 
        HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
        hs.add(curr);
        int n= num.length;
        List<Integer> curSet = null;
        for(int i=0; i<n; i++){
        	int preLen = result.size();
        	for(int j=0; j<preLen; j++){
        		curr = new ArrayList<Integer>();
        		curSet = (List<Integer>) result.get(j);
        		curr.addAll(curSet);
        		curr.add(num[i]);
        		Collections.sort(curr);
        		if(!hs.contains(curr)){
        			hs.add(curr);
        			result.add(curr);
        		}
        	}
        }
        return result;
        
        
    }

}
