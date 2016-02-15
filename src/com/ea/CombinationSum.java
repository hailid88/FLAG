package com.ea;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 90;
		List<Integer> solution = new ArrayList<>();
		boolean result = combinationSum(candidates, target, 0, solution);
		System.out.println(result);

	}
	
	//if can not duplicate. 
	public static boolean combinationSum(int[] candidates, int remain, int start, List<Integer> solution){
		if(remain == 0) return true;
		for(int i = start; i<candidates.length; i++){
			if(candidates[i]<=remain){
				solution.add(candidates[i]);
				boolean curr = combinationSum(candidates, remain-candidates[i], i+1, solution);
				if(curr) return true;
				solution.remove(solution.size()-1);
			}
		}
		return false;
	}

}
