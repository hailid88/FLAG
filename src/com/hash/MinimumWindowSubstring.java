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
可以利用两个指针扫描（两个指针分别为start，i），以S = “e b a d b a c c b”（忽略空格），T = “abc”为例：

0 1 2 3 4 5 6 7 8

初始化 start = i = 0
1）i 逐渐往后扫描S直到窗口S[start…i]包含所有T的字符，此时i = 6（字符c的位置）
2）缩减窗口：此时我们注意到窗口并不是最小的，需要调整 start 来缩减窗口。

缩减规则为：如果S[start]不在T中 或者 S[start]在T中但是删除后窗口依然可以包含T中的所有字符，那么start = start+1， 
直到不满足上述两个缩减规则。缩减后i即为窗口的起始位置，此例中从e开始窗口中要依次删掉e、b、a、d，start最后等于4 ，那么得到一个窗口大小为6-4+1 = 3
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
