package com.ipsy;
import java.io.*;
import java.util.*;


public class Solution {
	
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		
		//System.out.println(Integer.MAX_VALUE);
        BufferedReader r = null;
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<ArrayList<Integer>>();
        
        try{
            r = new BufferedReader(new InputStreamReader(System.in));
            String s = r.readLine();
            int T = Integer.parseInt(s);
            if(T>10 ||  T<0)  throw new RuntimeException("The input is not correct");
            
            
            for(int t = 0; t<T; t++){
                String Nstr = r.readLine();
                int N = Integer.parseInt(Nstr.trim());
                if(N>50000 ||  N<1)  throw new RuntimeException("The input is not correct: N should be less than 50000 and larger than 1. ");
                String line = r.readLine();
                String[] itemsStr = line.trim().split("\\s+");
                if(itemsStr.length!=N){
                    throw new RuntimeException("The input is not correct");
                }
                else{
                    ArrayList<Integer> itemsInt = new ArrayList<>();
                    for(int i = 0; i<itemsStr.length; i++){
                        itemsInt.add(Integer.parseInt(itemsStr[i]));
                    }
                    inputs.add(itemsInt);
                }
            }
            ArrayList<Integer> resl = getMaxProfit(inputs);
            for(Integer item:resl){
                System.out.println(item);
            }
            
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
        	if(r != null)
        		r.close();
        }
        
        
    }
    public static ArrayList<Integer> getMaxProfit(ArrayList<ArrayList<Integer>> inputs){
        if(inputs==null || inputs.size()<=0) return new ArrayList<Integer>();
        ArrayList<Integer> resl = new ArrayList<>();
        for(ArrayList<Integer> input:inputs){
            if(input==null || input.size()<=0){
                resl.add(0);
            } 
            else{
                int currMax = Integer.MIN_VALUE;
                int n = input.size();
                int profit = 0;
                    
                for (int j = n - 1; j >= 0; j--) {
                    if (currMax < input.get(j)) {
                        currMax = input.get(j);
                    }
                    else{
                        profit += (currMax - input.get(j));
                    }
                }
                resl.add(profit);
            }
        }
        return resl;
    }

}
