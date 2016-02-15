package com.array.string;

import java.util.*;

public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abbab";
		PalindromePartitioning obj = new PalindromePartitioning();
		List<List<String>> result = obj.partition(input);
		for(List<String> s : result){
			System.out.println(s.toString());
		}
	}
	
	public List<List<String>> partition(String s) {
        List result = new ArrayList<ArrayList<String>>();
        if(s==null || s.length()<=0){
            return result;
        }
        int n = s.length();
        boolean[][] palindrom = buildPalindromMatrix(s);
        
        List<String> solution = new ArrayList<String>();
        partition(s, 0, solution, result, palindrom);
        return result;
        
    }
    	
    public boolean[][] buildPalindromMatrix(String s){
        int n = s.length();
        char[] charS = s.toCharArray();
        boolean[][] palindrom = new boolean[n][n];
        //initialization. 
        for(int i=0; i<n; i++){
            palindrom[i][i]=true;
        }
        //update. 
        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(charS[i] == charS[j]){
                    if(j - i < 2 || palindrom[i+1][j-1])
                    palindrom[i][j] = true; 
                } // if
            } // for : j
        } // for : i
        
        return palindrom;
    }
    
    public void partition(String s, int start, List<String> solution, List<List<String>> result, boolean[][] palindrom){
        if(start >= s.length() || s.length()<=0){
            //result.add(new ArrayList(solution));
            result.add(solution);
        }
        for(int i = start; i<s.length(); i++){
            if(palindrom[start][i]){
                List<String> curr = new ArrayList<String>(solution);
                curr.add(s.substring(start, i+1));
                partition(s, i+1, curr, result, palindrom);
                //solution.remove(solution.size()-1);
            }
        }
    }
    
    public boolean isPalindrom(String s){
        if(s==null || s.length()<=0) return true;
        for(int i = 0; i<s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}
