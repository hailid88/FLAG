package com.array.string;

import java.util.*;

public class ThreeSum {
	public static void main(String[] args)
	{
		ThreeSum t = new ThreeSum();
		int[] num = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		ArrayList<ArrayList<Integer>> result = t.threeSum(num);
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

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		int len = num.length;
		if(len<3) return null;
		//first sort the array;
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> s = new HashSet<ArrayList<Integer>>();
		
		for(int i = 0; i< len-2; i++){
			int target = - num[i];
			int j = i+1;
			int k = len-1;
			
			while(j<k){
				if(num[j]+num[k]==target){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(num[i]);
					temp.add(num[j]);
					temp.add(num[k]);
					if(s.add(temp)){   //use hashset to guarantee that the item in result is unique. 
						result.add(temp);
					}
					j++;
					k--;
				}
				if(num[j]+num[k]>target){
					k--;
				}
				if(num[j]+num[k]<target){
					j++;
				}
			}
		}
		
		return result;
	}
}
