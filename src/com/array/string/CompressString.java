package com.array.string;

public class CompressString {

	/**
	 * @param args
	 * Given a string, eg aabbcdddd represents it as a2b2c1d4 if this is shorter than the original 
	 * one. 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compressBad("aabbcdddd");     
		compressBetter("abcdddddddd");
         
	}
	
	public static void compressBetter(String input){
		int oriLen = input.length();
		StringBuffer output = new StringBuffer();
		char[] oriChar= input.toCharArray();
		int start =0; 
		for (int i =0; i<oriLen; i++){
			if(oriChar[i]!=oriChar[start]){
				output.append(oriChar[start]);
				output.append(i-start);
				start = i;
			}
			if(oriChar[i]==oriChar[start] && i==oriLen-1)
			{
				output.append(oriChar[start]);
				output.append(i-start+1);
			}
		}
	   if(output.length()>input.length())
	   {
		   System.out.println(input);
	   }
	   else
	   {
		   System.out.println(output);
	   }
	}
	
	
	public static void compressBad(String original){
		int oriLen = original.length();
		char[] uniqueChar = new char[oriLen];
		int[] charLen = new int[oriLen];
		char[] oriChar= original.toCharArray();
		int start =0; int tail =0; int j=0;
		for (int i =0; i<oriLen; i++){
			if(oriChar[i]!=oriChar[start]){
				charLen[j] = i - start; 
				uniqueChar[j]= oriChar[start];
				start = i;
				j++;
			}
			if(oriChar[i]==oriChar[start] && i==oriLen-1)
			{
				charLen[j] = i - start + 1;
				uniqueChar[j]= oriChar[start];
				j++;
			}
		}
	    uniqueChar[j]='0';
	    for(int i = 0; i < uniqueChar.length; i++){
			if(uniqueChar[i]=='0') break;
			System.out.print(uniqueChar[i]);
			System.out.print(charLen[i]);
		}
	    System.out.println();
		
	}

}
