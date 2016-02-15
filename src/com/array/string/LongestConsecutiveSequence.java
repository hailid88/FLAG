package com.array.string;
import java.util.*;

public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		int[] num = {100, 4, 200, 1, 3, 2, 5, 0};
		
		int result = obj.longestConsecutive(num);
		System.out.println(result);
		result = obj.longestConsecutive2(num);
		System.out.println(result);
		
		int[] num2 = new int[8000];
		for(int i = 0; i<8000; i++){
			num2[i] = 8000-i;
		}
		
		result = obj.longestConsecutive(num2);
		System.out.println(result);
//		result = obj.longestConsecutive2(num2);
//		System.out.println(result);

	}
	
	public int longestConsecutive(int[] num) {
        if(num == null || num.length <= 0)
			return 0;
		Map<Integer, Integer> lm = new HashMap<Integer, Integer>();
		int n = num.length;
		for(int i = 0; i < n; i++)
			lm.put(num[i], i);  //pay attention use index as value. 
		
		int[] len = new int[n];
		int maxLen = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			len[i] = dfsSearch(num[i], lm, len);
			//System.out.println(len[i]);
			maxLen = Math.max(len[i], maxLen);
		}
		return maxLen;
	}
	
	private int dfsSearch(int num, Map<Integer, Integer> lm, int[] len){
		if(!lm.containsKey(num))
			return 0;
		int i = lm.get(num);
		if(len[i] > 0)
			return len[i];
		len[i] = dfsSearch(num - 1, lm, len) + 1;
		return len[i];
	}
	
	
	public int longestConsecutive2(int[] num) {
        if(num == null || num.length <= 0)
			return 0;
		Map<Integer, Integer> lm = new HashMap<Integer, Integer>();
		int n = num.length;
		for(int i = 0; i < n; i++)
			lm.put(num[i], 0);
		
		//int[] len = new int[n];
		int maxLen = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			int val = dfsSearch2(num[i], lm);
			maxLen = Math.max(val, maxLen);
		}
		return maxLen;
	}
	
	private int dfsSearch2(int num, Map<Integer, Integer> lm){
		if(!lm.containsKey(num))
			return 0;
		if(lm.get(num) > 0)
			return lm.get(num);
		int value = dfsSearch2(num - 1, lm) + 1;
		lm.put(num, value);
		return value;
	}

}
