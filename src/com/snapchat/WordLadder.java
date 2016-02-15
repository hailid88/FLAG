package com.snapchat;
import java.util.*;

public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		WordLadder obj = new WordLadder();
		int result = obj.ladderLength(start, end, dict);
		System.out.println(result);
	}
	
	Queue<String> wordQ = new LinkedList<>();
	Queue<Integer> stepQ = new LinkedList<>();
	
	
	public int ladderLength(String start, String end, Set<String> dict) {
		if(dict==null || dict.size()<=0) return 0;
		wordQ.offer(start);
		stepQ.offer(1);
		
		if(dict.contains(start)){
			dict.remove(start);
		}
		
		while(!wordQ.isEmpty()){
			String curW = wordQ.poll();
			Integer curD = stepQ.poll();
			if(curW.equals(end)){
				return curD;
			}
			for(int i = 0; i<curW.length(); i++){
				char[] currCharArr = curW.toCharArray();
				for(char c= 'a'; c<='z'; c++){
					if(currCharArr[i] == c){continue;}
					currCharArr[i] = c;
					String newW = new String(currCharArr);   //pay attention here. 
					if(newW.equals(end)){
						return curD+1;
					}
					if(dict.contains(newW)){
						dict.remove(newW);
						wordQ.offer(newW);
						stepQ.offer(curD+1);
					}
				}
			}
		}

		return 0;
	}

}
