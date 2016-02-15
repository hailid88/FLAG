package com.array.string;

public class IsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPalindrome(String s) {
        //first to remove the characters that are not a~z
        String lowerS = s.toLowerCase();
        int len = lowerS.length();
        StringBuffer newS = new StringBuffer();
        for(int i=0; i<len; i++){
            if((lowerS.charAt(i)>='a' && lowerS.charAt(i)<='z') || (lowerS.charAt(i)>='0' && lowerS.charAt(i)<='9')){
                newS.append(lowerS.charAt(i));
            }
        }
        int len2 = newS.length();
        int leftFrom = len2-1;
        int rightFrom =0;
        while(rightFrom<leftFrom){
            if(newS.charAt(leftFrom)!=newS.charAt(rightFrom)){
                return false;
            }
            rightFrom++;
            leftFrom--;
        }
        return true;
    }
	
	public boolean isPalindrome_less(String s) {
		
        String lowerS = s.toLowerCase();
		int len = lowerS.length();
		int rightFrom = len-1;
		int leftFrom = 0;
		while(leftFrom<rightFrom){
			//Character.isLetterOrDigit(lowerS.charAt(leftFrom));
			 while(!((lowerS.charAt(leftFrom)>='a' && lowerS.charAt(leftFrom)<='z') || (lowerS.charAt(leftFrom)>='0' && lowerS.charAt(leftFrom)<='9'))){
	                leftFrom++;
	                if(leftFrom>rightFrom){
	                    return true;
	                }
	            }
			 while(!((lowerS.charAt(rightFrom)>='a' && lowerS.charAt(rightFrom)<='z') || (lowerS.charAt(rightFrom)>='0' && lowerS.charAt(rightFrom)<='9'))){
				 	rightFrom--;
	            }
			 if(lowerS.charAt(leftFrom)!=lowerS.charAt(rightFrom)){
				 return false;
			 }
			 leftFrom++;
			 rightFrom--;
		}
		return true;
    }
}
