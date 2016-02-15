package com.array.string;
import java.util.Arrays;


public class ReplaceFun {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String a= "123";
		//System.out.println(a.length());
		char[] output = replaceFun("aba s");
		System.out.println(output);
		

	}
	public static char[] replaceFun(String s){
		
		char[] sChar = s.toCharArray();        //Convert to array of chars 
		int slength = sChar.length;
		int spaceNum =0;
		for (int i = 0; i<slength; i++){
		    if (sChar[i]==' '){
		    	spaceNum ++;
		    }
		}
		int newLength = slength + 2*spaceNum;
		char[] newsChar = new char[newLength];
		int point=0;
		for (int i = 0; i<slength; i++){
			
		    if (sChar[i]==' '){
		    	newsChar[point]='%';
		    	newsChar[point + 1] = '2';
		    	newsChar[point+2]='0';
		    	point = point +3;
		    }
		    else
		    {
		    	newsChar[point]= sChar[i];
		    	point++;
		    }
		} 
		return newsChar;
		//return Arrays.equals(tChar, sChar);
	}
}
