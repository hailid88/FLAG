package com.array.string;

import java.util.ArrayList;
import java.util.List;

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
		if(start==num.length-1){
		    newItem = new ArrayList<>();
		    newItem.add(num[start]);
		    newResult.add(newItem);
		}
		else{
			List<List<Integer>> preResl = permute(num, start+1);
			for(int i = 0; i<preResl.size(); i++){
				List<Integer> tmp = preResl.get(i);
				for(int j=0; j<=tmp.size(); j++){
				    newItem = new ArrayList<Integer>(tmp);
					newItem.add(j, num[start]);
					newResult.add(newItem);
				}
			}
		}
		return newResult;
	}
	
//	public List<List<Integer>> permute(int[] num) {
//        List rst = new ArrayList();
//		if(num == null)
//			return rst;
//		List<Integer> solution = new ArrayList<Integer>();
//		if(num.length <= 0){
//			rst.add(solution);
//			return rst;
//		}
//		else if(num.length == 1){
//			solution.add(num[0]);
//			rst.add(solution);
//			return rst;
//		}
//		
//		int first = num[0];
//		
//		int[] remainder = new int[num.length - 1];
//		for(int i = 1; i < num.length; i++)
//			remainder[i-1] = num[i];
//		
//		//also recursive. 
//		List remainderRst = permute(remainder);
//		int len = remainderRst.size(), lenS, j = 0;
//		List<Integer> newSolution = null;
//		for(int i = 0; i < len; i++){
//			solution = (List<Integer>) remainderRst.get(i);
//			lenS = solution.size();
//			for(j = 0; j <= lenS; j++){
//				newSolution = new ArrayList<Integer>(solution);
//				newSolution.add(j, first);
//				rst.add(newSolution);
//			}
//		} // for		
//		
//		return rst;
//    }

}
