package com.array.string;
import java.util.*;


public class PermutationsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
        List rst = new ArrayList();
		if(num == null || num.length <= 0)
			return rst;
		//iteratirve solution. 
		rst.add(new ArrayList<Integer>());
		for(int i = 0; i < num.length; i++){
			Set<ArrayList<Integer>> cur = new HashSet<ArrayList<Integer>>();
			for(int j = 0; j < rst.size(); j++){
				ArrayList<Integer> list = (ArrayList<Integer>)rst.get(j);
				for(int k = 0; k < list.size() + 1; k++){
					list.add(k, num[i]); // insert num[i] at position k
					ArrayList<Integer> arr = new ArrayList<Integer>(list);
					list.remove(k); // remove position k's number
					cur.add(arr); // guarantee no duplicate combinations
				} // for : k, each position for insertion
			} // for : j, each list in rst
			// update rst
			rst = new ArrayList(cur);
		} // for : check for each number in num
		return rst;
    }

}
