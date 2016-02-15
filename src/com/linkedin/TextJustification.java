package com.linkedin;
import java.util.*;
/**
 * 
 * Get the number of words that can be placed in one row
 * Identify the number of spaces that should be placed in each row
 * 
 * Get extra number of spaces needed for each row
 *
 * Specially handle the last line, also handle the line with only one word
 */
public class TextJustification {

	public static List<String> fullJustify(String[] words, int L) {
		List<String> res = new ArrayList<String>();
	    if(words==null || words.length==0)
	        return res;
	    int count = 0, last = 0, spaceNum = 0, extraNum = 0;
	    int j = 0, k = 0, lenWord = 0, spaceBetweenWord = 0;
	    StringBuilder str = null, spaceWord = null;
	    
	    for(int i = 0; i < words.length; i++){
	        //count: the length of last iteration
	    	// check wheather it is ok to put anotehr word
	    	// if Not, add this line into the result
	    	lenWord = words[i].length();
	    	if(count + lenWord + (i - last) > L){
	            spaceNum = 0;
	            extraNum = 0;
	            
	            spaceBetweenWord = i - 1 - last;
	            if( spaceBetweenWord > 0){
	            	spaceNum = (L - count) / spaceBetweenWord;
	            	
	            	// if not a multiple, get extra number of spaces
	            	extraNum = (L - count) % spaceBetweenWord;
	            }
	            
	            // build the new line
	            spaceWord = new StringBuilder();
	            for(k = 0; k < spaceNum; k++)
	            	spaceWord.append(" ");
	            str = new StringBuilder();
	            for(j = last; j < i; j++){
	                str.append(words[j]);
	                
	                if( j < i - 1){ // no space after the last word
	                	str.append(spaceWord);
	                    
	                    if(extraNum > 0)
	                        str.append(" ");
	                    
	                    extraNum--;
	                }
	            } // for : j
	            
	            // this is to handle the case that only one word can be placed in this line
	            for(j = str.length(); j < L; j++)
	                str.append(" ");
	                
	            res.add(str.toString());
	            count = 0;
	            last = i; // move the the next word
	        }
//	        count += words[i].length();
	    	count += lenWord;
	    }
	    
	    //since the last line must be less than the length of L
	    str = new StringBuilder();
	    for(int i = last; i < words.length; i++){
	        str.append(words[i]);
	        if(str.length() < L)
	            str.append(" ");
	    }
	    
	    // append spaces
	    for(int i = str.length(); i < L;i++)
	        str.append(" ");
	    
	    res.add(str.toString());
	    return res;
	}
	
	public static void main(String[] args){
		String[] s = {"This", "is", "an", "example", "of", "text", "justification", "justi ation."};
		int l = 16;
		List<String> rst = fullJustify(s, l);
		for(String ss : rst){
			System.out.println("[" + ss + "]");
		}
	}
}
