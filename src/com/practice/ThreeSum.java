package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ThreeSum {
	
	public static void main(String[] args)
	{
		ThreeSum t = new ThreeSum();
		int[] num = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};//{0,0,0,0};//{-13,11,11,0,-5,-14,12,-11,-11,-14,-3,0,-3,12,-1,-9,-5,-13,9,-7,-2,9,-1,4,-6,-13,-7,10,10,9,7,13,5,4,-2,7,5,-13,11,10,-12,-14,-5,-8,13,2,-2,-14,4,-8,-6,-13,9,8,6,10,2,6,5,-10,0,-11,-12,12,8,-7,-4,-9,-13,-7,8,12,-14,10,-10,14,-3,3,-15,-14,3,-14,10,-11,1,1,14,-11,14,4,-6,-1,0,-11,-12,-14,-11,0,14,-9,0,7,-12,1,-6};
		//ArrayList<ArrayList<Integer>> result = t.threeSum(num);
		//ArrayList<ArrayList<Integer>> result = t.threeSum2(num);
		ArrayList<ArrayList<Integer>> result = t.threeSum3(num);
		int len1 = result.size();
		int len2;
		int i, j;
		ArrayList<Integer> secondDim = null;
		for(i = 0; i < len1; i++)
		{
			secondDim = result.get(i);
			len2 = secondDim.size();
			System.out.print("(");
			for(j = 0; j < len2; j++)
			{
				System.out.print(secondDim.get(j) + ", ");
			}
			System.out.println(")");
		}
	}
	
	 public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Arrays.sort(num);
	            
	        int j ;
	        int k ;
	         Set set = new HashSet();
	        //= num.length;
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        if (num.length < 3)
	            return res;

	        for(int i=0; i < num.length - 2; i++) {
	            int target = - num[i];
	            j = i+1;
	            k = num.length - 1;
	            while (j < k) {
	                if (num[j] + num[k] == target) {
	                    ArrayList<Integer> sol = new ArrayList<Integer>();
	                    sol.add(num[i]);
	                    sol.add(num[j]);
	                    sol.add(num[k]);
	                    if (set.add(sol))
	                        res.add(sol);
	                    j++;
	                    k--;
	                } else if (num[j] + num[k] < target) {
	                    j++;
	                
	                } else 
	                    k--;
	            } // while
	        } // for
	        return res;
	    }
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList <Integer> array = null; // <index of two integers in num>
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        // place the dif into hashmap
        int i, j, dif, len2;
        int len = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = null;
        
        for(i = 0; i < len; i++)
        {
            for(j = i + 1; j < len; j++)
            {
                dif = -( num[i] + num[j] );
                if(map.get(dif) == null)
                {
                	array = new ArrayList <Integer>();
                	array.add(i);
                	array.add(j);
                    map.put(dif, array);
                }
                else
                {
                	array = map.get(dif);
                	array.add(i);
                	array.add(j);
                    map.put(dif, array);
                }
            } // for
        } // for
        
        
        
        for(i = 0; i < len; i++)
        {
        	array = map.get(num[i]);
            if(array != null && !array.contains(i))
            {
                len2 = array.size();
                for(j = 0; j < len2; j++)
                {                    
                    if(j % 2 == 0)
                    {
                        tmp = new ArrayList<Integer>();
                    } // the second round
                    
                    tmp.add(num[array.get(j)]);
                    
                    if(j % 2 == 1)
                    {
                        tmp.add(num[i]);
                        result.add(tmp);
                    } // add the final element
                }
                
                
            } // if
        } // for
        
        return result;
    }
	
	
	public ArrayList<ArrayList<Integer>> threeSum3(int[] num) {
		ArrayList <Integer> array = null; // <index of two integers in num>
        // place the dif into hashmap
        int i, j, k, dif, len2;
        int len = num.length;
        int target = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = null;
        Set set = new HashSet();
        
        Arrays.sort(num);
        for(i = 0; i < len - 2; i++)
        {
        	target = -num[i];
        	
        	j = i + 1;
        	k = len - 1;
        	while(j < k)
        	{
        		if(num[k] + num[j] == target)
        		{
        			tmp = new ArrayList<Integer>();
        			tmp.add(num[i]);
        			tmp.add(num[j]);
        			tmp.add(num[k]);
        			if(set.add(tmp))
        				result.add(tmp);
        			j++;
        			k--;
        		}
        		else if(num[k] + num[j] > target)
        		{
        			k--;
        		}
        		else if(num[k] + num[j] < target)
        		{
        			j++;
        		}
        	}
        }
        
        return result;
    }
}
