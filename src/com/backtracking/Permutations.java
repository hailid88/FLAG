package com.backtracking;
import java.util.*;

public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permute(int[] num) {
	    List resl = new ArrayList();
	    List<Integer> elem = new ArrayList<Integer>();
	    if(num==null) return null;
	    resl.add(elem);
	    if(num.length<=0) return resl;
	    return permute(num, 0);
	    
    }
	
	public List<List<Integer>> permute(int[] num, int start){
		List newResult = new ArrayList();
		List<Integer> newItem = null;
		if(start<num.length-1){
			int first = num[start];
			//suppose the elements from start+1 to the end has already have the list of the permutations, then we add
			//the first into the permutations. (in the first place, in the second place, ..., in the last place. )
			//插入在第几个空上。
			List<List<Integer>> preResl = permute(num, start+1);
			int lNum = preResl.size();
			
			for(int i = 0; i<lNum; i++){
				List<Integer> tmp = preResl.get(i);
				int tmpSize = tmp.size();
				for(int j=0; j<tmpSize; j++){
					newItem = new ArrayList<Integer>(tmp);
					newItem.add(j, first);
					newResult.add(newItem);
				}
				//放在最后。
				newItem = new ArrayList<Integer>(tmp);
				newItem.add(first);
				newResult.add(newItem);
			}
		}
		else{
			//base, 只有一个元素的时候。
			if(start == num.length-1){
				newItem = new ArrayList<Integer>();
				newItem.add(num[start]);
				newResult.add(newItem);
			}
			else{
				//start > num.length-1 ???
				newItem = new ArrayList<Integer>();
				newResult.add(newItem);
			}
		}
		return newResult;
	}

}
