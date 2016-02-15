package com.backtracking;
import java.util.*;

public class CombinationSumII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2,5,2,1,2};
		int target = 5;
		CombinationSumII obj = new CombinationSumII();
		List<List<Integer>> resl = obj.combinationSum2(num, target); 

	}
	
	
	//Method 1: use hashset to get unique combinations. 
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List resl = new ArrayList();
        List<Integer> tmp = new ArrayList<Integer>();
        int n = num.length;
        if(num==null || num.length<=0){ 
        	resl.add(tmp); 
        	return resl;
        }
        combinationSum2(num, target, 0, tmp, resl); 
        return resl;
    }
	
	HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
	public void combinationSum2(int[] num, int remain, int start, List<Integer> tmp, List resl) {
		if(remain == 0){
			List<Integer> item = new ArrayList<Integer>(tmp);
		    Collections.sort(item);
		    if(!hs.contains(item)){
		    	hs.add(item);
		    	resl.add(item);
		    }
		    return;
		}
		if(start>num.length-1 || remain<0) return;
		for(int i= start; i<=num.length-1; i++){
			tmp.add(num[i]);
			combinationSum2(num, remain - num[i], i+1, tmp, resl);
			tmp.remove(tmp.size()-1);
			
		}
	}
	
	
	
	//Method 2: remove the already visited elements to get unique combinations. 
	public List<List<Integer>> combinationSum2_rem(int[] num, int target) {
        List resl = new ArrayList();
        List<Integer> tmp = new ArrayList<Integer>();
        int n = num.length;
        if(num==null || num.length<=0){ 
        	resl.add(tmp); 
        	return resl;
        }
        Arrays.sort(num);
        combinationSum2(num, target, 0, tmp, resl); 
        return resl;
    }
	
	public void combinationSum2_rem(int[] num, int remain, int start, List<Integer> tmp, List resl) {
		if(remain == 0){
			List<Integer> item = new ArrayList<Integer>(tmp);
		    Collections.sort(item);
		    resl.add(item);
		    return;
		}
		if(start>num.length-1 || remain<0) return;
		for(int i= start; i<=num.length-1; i++){
			tmp.add(num[i]);
			combinationSum2(num, remain - num[i], i+1, tmp, resl);
			tmp.remove(tmp.size()-1);
			while(i+1<num.length&&num[i]==num[i+1]){
				i++;
			}
		}
	}

}
