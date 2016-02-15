package com.array.string;

import java.util.*;

public class FourSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {7,-1,14,-12,-8,7,2,-15,8,8};
		int target = 8;
		FourSum object= new FourSum();
		List<List<Integer>> result = object.fourSum(num, target);

	}
	
	public List<List<Integer>> fourSum(int[] num, int target) {
        List result = new ArrayList();
        HashSet h = new HashSet();
        if(num.length<4) return result;
        Arrays.sort(num);
        int len = num.length;
        for(int i=0; i<len-3; i++){
            for(int j=i+1; j<len-2; j++){
                int m = j+1;
                int n = len-1;
                while(m<n){
                    if(num[i]+num[j]+num[m]+num[n]==target){
                        List temp = new ArrayList();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[m]);
                        temp.add(num[n]);
                        if(h.add(temp)){   //hashset add return boolean. 
                            result.add(temp);
                        }
                        m++;
                        n--;
            
                    }
                    if(num[i]+num[j]+num[m]+num[n]>target){
                        n--;
                    }
                     if(num[i]+num[j]+num[m]+num[n]<target){
                        m++;
                    }
                }
            }
        }
        return result;
        
    }

}
