package com.hash;
import java.util.Map;
import java.util.HashMap;

public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * 
������������ָ��ɨ�裨����ָ��ֱ�Ϊstart��i������S = ��e b a d b a c c b�������Կո񣩣�T = ��abc��Ϊ����

0 1 2 3 4 5 6 7 8

��ʼ�� start = i = 0
1��i ������ɨ��Sֱ������S[start��i]��������T���ַ�����ʱi = 6���ַ�c��λ�ã�
2���������ڣ���ʱ����ע�⵽���ڲ�������С�ģ���Ҫ���� start ���������ڡ�

��������Ϊ�����S[start]����T�� ���� S[start]��T�е���ɾ���󴰿���Ȼ���԰���T�е������ַ�����ôstart = start+1�� 
ֱ������������������������������i��Ϊ���ڵ���ʼλ�ã������д�e��ʼ������Ҫ����ɾ��e��b��a��d��start������4 ����ô�õ�һ�����ڴ�СΪ6-4+1 = 3
	 */
	
	public String minWindow(String S, String T) {
        if(S == null || T == null)
			return null;
		Map<Character, Integer> dict = new HashMap<>(), rm = new HashMap<>(); 
		//rm map is used to hash the words that appeared in S and also in the dict. 
		char[] arr = T.toCharArray();
		for(char c : arr){
			if(dict.containsKey(c))
				dict.put(c,  dict.get(c) + 1);
			else
				dict.put(c, 1);
		}
		
		int start = 0, count = 0, minLen = Integer.MAX_VALUE;
		String minWin = "";
		arr = S.toCharArray();
		for(int i = 0; i < arr.length; i++){
			char c = arr[i];
			if(dict.containsKey(c)){
				if(rm.containsKey(c)){
					rm.put(c, rm.get(c) + 1);
					if(rm.get(c) <= dict.get(c))
						count++;
				}
				else{
					rm.put(c, 1);
					count++;
				}
				if(count == T.length()){
					char sc = arr[start];
					while(!rm.containsKey(sc) || rm.get(sc) > dict.get(sc)){
						if(rm.containsKey(sc))
							rm.put(sc, rm.get(sc) - 1);
						sc = arr[++start];
					} // move start in the forward direction
					if(minLen > i - start + 1){
						minLen = i - start + 1;
						minWin = S.substring(start, i + 1); 
					} // update min window
				} // if: match
			} // if : c is in the dictionary
		} // for : i, the end position
		return minWin;
    }

}
