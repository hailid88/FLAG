package com.array.string;
import java.util.*;

public class TextJustification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"Listen","to","many,","speak","to","a","few."};
		int L = 6;
		TextJustification obj = new TextJustification();
		List<String> resl = obj.fullJustify(words, L);
		for(int i = 0; i<resl.size(); i++){
			System.out.println("'" + resl.get(i) + "'");
		}

	}
	public List<String> fullJustify(String[] words, int L) {
		List<String> rst = new ArrayList<String>();
		if(words==null || words.length<=0) return rst;
		int start =0;
		int end = start;
		while(end<words.length){
			int currLen = 0;
			currLen = currLen + words[end].length();
			StringBuffer sb = new StringBuffer();
			sb.append(words[start]);
			end = start +1;
			while(currLen<L && end<words.length){
				currLen = 1 + currLen + words[end].length();
				end++;
			}
			end--;
			if(currLen>L){
				currLen = currLen - words[end].length()-1;
				end--;
			}
			int extraSpace = L-currLen;
			if(start == end || (end == words.length-1)){
				for(int i = start+1; i<=end; i++){
					sb.append(" ");
					sb.append(words[i]);
				}
				for (int j = 0; j < extraSpace; j++){
					   sb.append(" ");
				}
			}
			else{
				for(int i = start+1; i<=end; i++){
					for (int j = 0; j < 1+extraSpace/(end-start); j++){
						   sb.append(" ");
					}
					if(i<start+1+extraSpace%(end-start)){
						sb.append(" ");
					}
					sb.append(words[i]);
				}
			}
			
			rst.add(sb.toString());
			start = end+1;
			end = start;
		}
		return rst;
	}
}
