package com.hash;
import java.util.*;

public class SubstringWithConcatenationOfAllWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> rst = new ArrayList<Integer>();
		if(S ==  null || L == null || L.length <= 0)
			return rst;
		Map<String, Integer> dict = new HashMap<String, Integer>();
		//first ask: will the same word appear more than once in L?
		
		//build the dictionary. 
		for(String str : L){
			if(dict.containsKey(str))
				dict.put(str, dict.get(str) + 1);
			else
				dict.put(str, 1);
		} 
		
		//get the length of each word in L. All the words' lengths are the same.
		int uLen = L[0].length(), tLen = S.length() - uLen;
		
		//uLen ways to start. 
		for(int i = 0; i < uLen; i++){
			Map<String, Integer> stateMap = new HashMap<String, Integer>();
			//count used to record how many words have been matched with Dic, left is used to record the start index. 
			int count = 0, left = i;
			//go every uLen steps. 
			for(int j = i; j <= tLen; j += uLen){
				String newWord = S.substring(j, j + uLen);   //get the word with uLen length.
				if(dict.containsKey(newWord)){				 //judge if it is in the dictionary.
					if(stateMap.containsKey(newWord))					//record the newWord in the stateMap. 
						stateMap.put(newWord, stateMap.get(newWord) + 1);
					else
						stateMap.put(newWord, 1);
					
					if(stateMap.get(newWord) <= dict.get(newWord))            //after recording, then compare the stateMap and dict. 
						count++;											
					else{														
						while(stateMap.get(newWord) > dict.get(newWord) && left <= tLen){
							String temp = S.substring(left, left + uLen);
							stateMap.put(temp, stateMap.get(temp) - 1);
							if(!temp.equals(newWord)){                   
								count--;			//if the temp is not equal to newWord, we are deleting one matched word. 
							}
							left += uLen;
						} // while: remove duplicates
					} // if-else: check for newword
					
					if(count == L.length){
						rst.add(left);
						String temp = S.substring(left, left + uLen);
						stateMap.put(temp, stateMap.get(temp) - 1);
						count--;
						left += uLen;
					}
				}
				else{
					// reset
					count = 0;
					stateMap.clear();
					left = j + uLen;
				} // if - else: new word
			} // for : j
		} // for : i
		
		
		return rst;
    }

}
