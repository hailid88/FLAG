package com.linkedin;

/**
 * O(n)
 * Check character by character
 * if it is {, increase depth
 * if it is }, decrease depth, also trigger the computation of sum if the number is bigger than zero
 * if it is number, combine the number
 * if it is , trigger the computation of sum
 *
 */
public class NestedIntegerWeightedSum {
	public static int getSum(String input){
		if(input == null)
			return 0;
		int len = input.length();
		if(len <= 0)
			return 0;
		
		char c = ' ';
		int number = 0, sum = 0, depth = 0;
		for(int i = 0; i < len; i++){
			c = input.charAt(i);
			if(c == '{')  // increase depth
				depth++;
			else if(c == ','){ // compute sum
				sum += depth * number;
				number = 0;
			}
			else if(c == '}'){
				if(number > 0){
					sum += depth * number;
					number = 0;
				}
				depth--;
			}
			else if(c >= '0' && c <= '9'){
				if(number > 0)
					number *= 10;
				number += c - '0';
			} // if - else
		} // for : i
		
		return sum;
	} // function
	
	public static void main(String[] args){
		String input = "{2, {4, {6}}}";
		input = "{1, 2, 3, {1}}";
		input = "{{10, 1}, 2, {1, 1}}";
		System.out.println(getSum(input));
	}
}
