package com.array.string;
import java.util.Arrays;


public class RemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  m = "abababa";
		char[] str = m.toCharArray();
		char[] output = removeDuplicate(str);
		for(int i = 0; i < output.length; i++){
			if(output[i]=='0') break;
			System.out.println(output[i]);
		}

	}
	public static char[] removeDuplicate(char[] str){
		int strLen = str.length;
		if(strLen<2){
			return str;
		}
		int tail = 1;
		for (int i = 1; i<strLen; i++){
			int j;
			for (j = 0; j<tail; j++){
				if(str[i]==str[j]){
					break;
				}
			}
			if(j==tail){
				str[tail]=str[i];
				tail++;
			}
		}
		str[tail]='0';
		//return str;
		//System.out.println(tail);
		//return Arrays.copyOfRange(str, 0, tail);
		return str;
	}

}
