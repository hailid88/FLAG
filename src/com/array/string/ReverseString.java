package com.array.string;

public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString revS = new ReverseString();
		//String output = revS.reverStr("I have  36 books, 40 pens2, and 1 notebook.");
		String input = "36 test abc, mys55pace";
		input = "I have  36 books, 40 pe32ns2, and 1 notebook.";
		String output = revS.reverStr(input);
		System.out.println("\"" + input + "\"");
		System.out.println("\"" + output + "\"");
		
		String words = "the sky is blue";
		System.out.println("\"" + revS.reverseWords(words)+ "\"");

	}
	
	public String reverseWords(String s){
		if(s==null || s.length()==0) return "";
		String[] words = s.split("\\s+");
		StringBuffer output = new StringBuffer();
		if (words.length==0) return "";
		for (int i =words.length -1; i>=0; i--){
		   output.append(words[i]);
		   if(i>0) output.append(" ");   //avoid adding space at the end. 
		}
		return output.toString();
	}
	
	
	
	 //"I have  36 books, 40 pens2, and 1 notebook."
	// "I evah  36 skoob, 40 2snep, dna 1 koobeton."
	public String reverStr(String input){
		int len = input.length();
		int startIndx = 0;
		int numNum = 0;
		
		StringBuffer output = new StringBuffer();
		int i = 0;
		for (i=0; i<len; i++){
			if((input.charAt(i)>='a' && input.charAt(i)<='z') || (input.charAt(i)>='A' && input.charAt(i)<='Z') 
					|| (input.charAt(i)>='0' && input.charAt(i)<='9')){
				if(input.charAt(i)>='0' && input.charAt(i)<='9'){
					numNum++;
				}
				
			}
			else{
				if(i-startIndx == numNum){
					output.append(input.substring(startIndx, i));
				}
				else{
					output.append(reverseSub(input.substring(startIndx, i)));
				}
				output.append(input.charAt(i));
				startIndx = i + 1;
				numNum=0;
			}
		}
		
		
		if(i-startIndx == numNum){
			output.append(input.substring(startIndx, i));
		}
		else{
			output.append(reverseSub(input.substring(startIndx, i)));
		}
		
		
		return output.toString();
		
	}
	
	
	public String reverseSub(String substr){
		if(substr.length()==1){
			return substr;
		}
		else{
//			StringBuffer intem = new StringBuffer();
//			intem.append(substr);
//			return(intem.reverse().toString());
			char[] strChar = substr.toCharArray();
			StringBuffer result=new StringBuffer();
			for(int i=strChar.length-1; i>=0; i--){
				result.append(strChar[i]);
			}
			return result.toString();
		}
	}

}
