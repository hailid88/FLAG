package com.math;

public class MultipleStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "9";
		String num2 = "9";
		MultipleStrings obj = new MultipleStrings();
		System.out.println(obj.multiply(num1, num2));

	}
	
	public String multiply(String num1, String num2){
		if (num1 == null || num1.length() == 0|| num2 == null || num2.length() == 0)
            return null;
        
        int[] nums = new int[num1.length() + num2.length()];
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        for(int i = len1-1; i>=0; i--){
            int a = num1.charAt(i)-'0';
            for(int j = len2-1; j>=0; j--){
                int b = num2.charAt(j)-'0';
                nums[i+j+1]+=a*b+carry;
                carry = nums[i + j + 1] / 10;
                nums[i+j+1] = nums[i+j+1]%10;
            }
            if(carry!=0){
                nums[i]+=carry;
                carry = 0;
            }
        }
        
        int start = 0;
        while(start < len1+len2-1){
            if(nums[start]>0) break;
            start++;
        }
        StringBuilder s1 = new StringBuilder(); 
        for(int i = start; i<len1+len2; i++){
            s1.append(nums[i]);
        }
        return s1.toString();
	}
	public String multiply_B(String num1, String num2) {
        if (num1 == null || num1.length() == 0|| num2 == null || num2.length() == 0)
            return null;
        
        int[] nums = new int[num1.length() + num2.length()];
        
        // multiply from right to left
        // store the result from right to left
        for (int i = 0; i < num2.length(); i++){
            int carry=0;
            int a = num2.charAt(num2.length() - i - 1) - '0';
            
            for (int j = 0; j < num1.length(); j++){
                int b = num1.charAt(num1.length() - 1 - j) - '0';
                nums[i + j] += a * b + carry;
                carry = nums[i + j] / 10;
                nums[i+j] %= 10;
                
            } // for : j
            nums[i + num1.length()] += carry;
        } // for : i
        
        StringBuilder result = new StringBuilder();
        int i = nums.length - 1;
        while(i > 0 && nums[i] == 0)
            i--;
        
        while(i >= 0){
            result.append(nums[i]);
            i--;
        }
        
        return result.toString();
		
		
    }

}
