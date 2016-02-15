package com.groupon;

import java.util.HashSet;

public class LRS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ori = "AAAGGGCTAGGCTCAA";
		String result = findLargestRepeatingPattern2(ori);
		System.out.println(result);
	}
	
	
	
	//String ori = "AAAGGGCTAGGCTCAA";
	//result will be GGCT. 
	//overlapping. 
	public static String findLargestRepeatingPattern(String ori){
	    int n = ori.length();
	    int i = 1;
	    String longest = "";
	    for(; i<n-1; i++){
	        HashSet<String> hs = new HashSet<>();
	        int j = 0;
	        for(; i+j<=n; j++){
	            if(!hs.add(ori.substring(j, j+i))){
	            	longest = ori.substring(j, j+i);
	            //if could not be added to the hashset means that the element is only in the hashset. 
	                break; //will break the j loop. //current max is i;
	            }
	        }
	        //if the element number in hashset is equal to the number of the element in length i. Then all of them are 
	        //unique, we have already find the longest repeating pattern. 
	        if(hs.size()==n-i+1){
	            return longest;
	        }
	    }
	    return longest;
	}
	
	//nooverlapping. 
	public static String findLargestRepeatingPattern2(String ori){
	    int n = ori.length();
	    int i = 1;
	    String longest = "";
	    for(; i<n-1; i++){
	        HashSet<String> hs = new HashSet<>();
	        int j = 0;
	        for(; i+j<=n; j=j+i){
	            if(!hs.add(ori.substring(j, j+i))){
	            	longest = ori.substring(j, j+i);
	            //if could not be added to the hashset means that the element is only in the hashset. 
	                break; //will break the j loop. //current max is i;
	            }
	        }
	        //if the element number in hashset is equal to the number of the element in length i. Then all of them are 
	        //unique, we have already find the longest repeating pattern. 
//	        if(hs.size()==n-i+1){
//	            return longest;
//	        }
	    }
	    return longest;
	}


}
