package com.array.string;

import java.util.*;

public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> subsets(int[] S){
		if(S == null) return null;
		List result = new ArrayList();
		if(S.length<=0) return result;
		int len = S.length;
		List<Integer> cur = new ArrayList<Integer>(), curSet = null;
		result.add(cur);
		for(int i = 0; i<len; i++){
			int preLen = result.size();
			for(int j = 0; j<preLen; j++){
				curSet = (List<Integer>)result.get(j);
				cur = new ArrayList<Integer>();
				cur.addAll(curSet);
				cur.add(S[i]);
				Collections.sort(cur);
				result.add(cur);
			}
		}
		return result;
	}

}
