package com.array.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String largestNumber(int[] num) {
        ArrayList<String> nums = new ArrayList<String>();
        for(int i : num){
            nums.add(String.valueOf(i));
        }
    
        Collections.sort(nums, new NumberComparator());
    
        StringBuffer res = new StringBuffer();
    
        for(int i=nums.size()-1; i>=0; --i){
            res.append(nums.get(i));
        }
    
        // if all zeros, then return only a single zero
        if(res.length() > 0 && res.charAt(0) == '0'){
            return "0";
        }else{
            return res.toString();
        }
    }

}


class NumberComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int i = 0;
        while(i<al && i<bl){
            if(a.charAt(i) > b.charAt(i)){
                return 1;
            }else if(a.charAt(i) < b.charAt(i)){
                return -1;
            }
            // a.charAt(i) == b.charAt(i)
            ++i;
        }

        if(al == bl){
            return 0;
        }else if(al < bl){
            return compare(a, b.substring(i));
        }else{
            return compare(a.substring(i), b);
        }
    }
}
