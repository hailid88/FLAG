package com.breathfirstsearch;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start ="a", end = "c";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		WordLadder obj = new WordLadder();
		System.out.println(obj.ladderLength(start, end, dict));
	}
	
	public Queue<String> wordQ = new LinkedList<String>();
	public Queue<Integer> distQ = new LinkedList<Integer>();
	public int ladderLength(String start, String end, Set<String> dict) {
        if(dict==null || dict.size()<=0) return 0;
        wordQ.offer(start);
        distQ.offer(1);
		if(dict.contains(start)){
			dict.remove(start);
		}
        
        while(!wordQ.isEmpty()){
        	String curW = wordQ.poll();
        	Integer curD = distQ.poll();
        	if(curW.equals(end)){
        		return curD;
        	}
        	for(int i=0; i<curW.length(); i++){
        		char[] currCharArr = curW.toCharArray();
        		for(char c ='a'; c<='z'; c++){
        			if(dict.size()<=0){
        				break;
        			}
    				currCharArr[i] = c;
    				String newW = new String(currCharArr);
        			if(dict.contains(newW)){
        				wordQ.offer(newW);
        				distQ.offer(curD+1);
        				dict.remove(newW);
        			}
            	}
        	}
        	
        }
        return 0;
		
    }

}
