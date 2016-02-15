package com.array.string;

public class IntegerToRoman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String intToRoman(int num){
		if(num<=0) return "";
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder res = new StringBuilder();
		while(num > 0){
			for(int i = 0; i<nums.length; i++){
				int tmp = num/nums[i];
				while(tmp>0){
					res.append(symbols[i]);
					tmp--;
				}
				num = num%nums[i];
			}
		}
		return res.toString();
	}

}
