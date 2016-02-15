package com.array.string;
import java.util.*;
public class LetterCombinationsOfAPhoneNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> letterCombinations(String digits) {
		char[] dChar = digits.toCharArray();
		String[] dS = new String[dChar.length];
		for(int i = 0; i<dChar.length; i++){
			int digit = Character.getNumericValue(dChar[i]);
			dS[i]= n2s(digit);
		}
	    List<String> result = new ArrayList<String>();
	    result.add("");
	    
	    for (int i = 0; i<dS.length; i++){
	    	String s = dS[i];
	    	List<String> tmp = new ArrayList<String>();
	    	for(int j=0; j<result.size(); j++){
	    		for(int k=0; k<s.length(); k++){
	    			tmp.add(result.get(j) + s.substring(k, k+1));
	    		}
	    	}
	    	result = tmp;
	    	
	    }
	    return result;
	        
    }
	
	public String n2s(int num){
		
		switch(num){
//			case 0: return ""; 
//			case 1: return ""; 
			case 2: return "abc"; 
			case 3: return "def"; 
			case 4: return "ghi"; 
			case 5: return "jkl"; 
			case 6: return "mno"; 
			case 7: return "pqrs";
			case 8: return "tuv"; 
			case 9: return "wxyz";
			default: return "";
		}
		
	}

}
