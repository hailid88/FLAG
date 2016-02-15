package com.array.string;

public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlusOne object = new PlusOne();
		int[] digits = {9};
		int[] output = object.plusOne(digits);
		for(int i=0; i<output.length; i++){
			System.out.println(output[i]);
		}

	}
	
	public int[] plusOne(int[] digits) {
        int digitNum = digits.length;
        int[] newdigits = new int[digits.length+1];
        int i;
        int resid=0;
        for(i=digitNum-1; i>=0; i--){
            if(i == digitNum -1){
            	newdigits[i]=(digits[i]+resid+1)%10;
            	resid = (digits[i]+resid+1)/10;
                
                
            }
            else{
                if(resid>0){
                	newdigits[i]=(digits[i]+resid)%10;
                	resid = (digits[i]+resid)/10;
                    
                }
            }
        }
        if(resid>0){
        	int[] newdigits2 = new int[digits.length+1];
            newdigits2[0]=1;
            for(int j=1; j<=digits.length; j++){
                newdigits2[j] = newdigits[j-1];
            }
            return newdigits2;
        }
        return newdigits;
        
    }

}
