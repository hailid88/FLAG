package com.array.string;

public class StrStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 
Implement strStr().

Returns the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.
	 */
	
	//use the substring function. 
	public int strStr(String haystack, String needle){
		int len1 = haystack.length();
        int len2 = needle.length();
        if(len2>len1) return -1;
        for(int i = 0; i<=len1-len2; i++){
            if(haystack.substring(i, i+len2).equals(needle)){ return i;}
        }
        return -1;
	}
	
	//use charArray. 
	public int strStr2(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if(nLen>hLen){return -1;}
        if(nLen==0 || hLen==0) return 0;
        
        for(int i=0; i<hLen; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
              if(hLen - i < nLen){
                  return -1;
              }else{
                  int j=1;
                  for(; j<nLen; j++){
                      if(needle.charAt(j)!= haystack.charAt(i+j)){
                          break;
                      } 
                  }
                  if(j == nLen){
                      return i;
                  }
              }  
            }
        }
        return -1;
    }
	

}
