package com.array.string;

public class LengthOfLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="a";
		LengthOfLastWord obj = new LengthOfLastWord();
		int resl = obj.lengthOfLastWord(s);
	

	}
	
	public int lengthOfLastWord(String s) {
        if(s==null) return 0;
        int n = s.length();
        if(n<=0) return 0;
        
        int end;
        for(end=n-1; end>=0; end--){
            if(s.charAt(end)!=' '){
                break;
            }
        }
        if(end<0) return 0;
        int start;
        for(start = end-1; start>=0; start--){
            if(s.charAt(start)==' '){
                break;
            }
        }
        return end-start;
        
    }

}
