package com.breathfirstsearch;
import java.util.*;

public class WordLadderII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List rst = new ArrayList();
        if(start == null || end == null || dict.size()==0) return rst; 
		
        Set<String> curLayer = new HashSet<>(), preLayer = null;
        Map<String, ArrayList<String>> mapStr = new HashMap<>();
        ArrayList<String> preWords = null;
        ArrayList<String> path = new ArrayList<>();
        path.add(end);
 
        curLayer.add(start);
        
        while(!curLayer.isEmpty()){
        	preLayer = curLayer;
        	curLayer = new HashSet<String>();
        	
        	for(String word : preLayer){
        	    // remove the word from dictionary
        		if(dict.contains(word))
        			dict.remove(word);
        	}
        	
        	for(String word : preLayer){
        		if(word.equals(end)){
        			getPath(rst, start, end, mapStr, path);
        			return rst;
        		}
        		int len = word.length();
        		for(int i = 0; i < len; i++){
        			char[] currCharArr = word.toCharArray();
        			for(char c = 'a'; c <= 'z'; c++){
        				currCharArr[i] = c;
        				
        				String newWord = new String(currCharArr);
        				if(dict.contains(newWord)){
        					curLayer.add(newWord);
        					preWords = mapStr.get(newWord);
        					if(preWords == null){
        						preWords = new ArrayList<String>();
        						mapStr.put(newWord, preWords);
        					}
        					preWords.add(word);
        				} // if : check dict contains new word or not
        			} // for : c, replace old word with a new char
        		} // for : i check for each char in the old word
        	} // for: word check each word in previous layer
        } // while : traverse layer by layer
        return rst;
    }
	
	public static void getPath(List<List<String>> rst, String start, String end, Map<String, ArrayList<String>> mapStr, ArrayList<String> path){
		if(start == end){
			//first reverse the path and save it to rst. 
			Collections.reverse(path);
			List<String> newPath = new ArrayList<String>(path);
			rst.add(newPath);
			//reverse it back for further use. 
			Collections.reverse(path);
		}
		else{
			ArrayList<String> preWords = mapStr.get(end);
			if(preWords == null)
				return;
			for(String pre : preWords){
				path.add(pre);
				getPath(rst, start, pre, mapStr, path);
				path.remove(path.size() - 1);
			}
		}
	}

}
