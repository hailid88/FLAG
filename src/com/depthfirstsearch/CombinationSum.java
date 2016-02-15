package com.depthfirstsearch;
import java.util.*;

public class CombinationSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * 
Analysis:

Because the problem is to get all the possible results, not the best or the number of result, 
thus we don't need to consider DP(dynamic programming), DFS is enough to handle it.

The idea is to scan from the first to the last element from the ordered array. 
check every possible combination of these numbers(multiple times for a single element).
	 * 
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List rst = new ArrayList();
	    if(candidates == null || candidates.length<=0) return rst;
	    combinationSum(candidates, target, 0, 0, rst, new ArrayList<Integer>());
	    return rst;
	}
	
	public void combinationSum(int[] candidates, int remain, int start, List<List<Integer>> rst, List<Integer> solution){
		if(remain<0) return;
		if(remain==0){
			List<Integer> temp = new ArrayList<>(solution);
			rst.add(temp);
		}
		for(int i = start; i<candidates.length; i++){
			solution.add(candidates[i]);
			remain -=candidates[i];
			combinationSum(candidates, remain, i, rst, solution);
			solution.remove(solution.size()-1);
			remain +=candidates[i];
		}
	}
	
	public void combinationSum(int[] candidates, int target, int start, int curSum, List<List<Integer>> rst, List<Integer> solution){
		if(curSum>target) return;
		if(curSum == target){
			List<Integer> temp = new ArrayList<Integer>(solution);
			Collections.sort(temp);
			rst.add(temp);
			return;
		}
		for(int i=start; i<candidates.length; i++){
			solution.add(candidates[i]);
			curSum = curSum + candidates[i];
			combinationSum(candidates, target, i, curSum, rst, solution);
			solution.remove(solution.size()-1);
			curSum = curSum - candidates[i];
		}
	}
	
	
	
	

}
