package com.palantir;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	BufferedReader r = null;
        try{
            r = new BufferedReader(new InputStreamReader(System.in));
            String rowCol = r.readLine();  // read first line to get # of rows and # of cols
            if(rowCol == null || rowCol.length() <= 0){
                //System.out.println(0);
                //throw new RuntimeException("invalid input: the number of rows or cols should be bigger than zero");
            	return;
            }
            String[] strs = (rowCol.trim()).split(" ");
            if(strs.length < 2){
            	//System.out.println(0);
                //throw new RuntimeException("invalid input: the number of rows or cols should be bigger than zero");
            	return;
            }
            int m = Integer.parseInt(strs[0].trim()), n = Integer.parseInt(strs[1].trim());
            if(m < 1 || m > 100000 || n < 1 || n > 500){
            	//System.out.println(0);
            	return;
            	//throw new RuntimeException("invalid input: <m");
            }
            //char[][] magicBox = new char[m][n];
            String[] magicBox = new String[m];
            for(int i = 0; i < m; i++){
            	magicBox[i] = ((r.readLine()).trim()).toUpperCase(); // read each line and parse the data into magicBox
            	if(magicBox[i].length() != n){
            		//System.out.println(0);
            		return;
//            		throw new RuntimeException("invalid input: each row should have the same col");
            	}
            } // for : i
            
            //get the max wishes of the magic Box;
            System.out.println(getMaxWishes(magicBox));
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
        	if(r != null)
        		r.close();
        }
    }
	
	public static int getMaxWishes(String[] magicBox){
		Map<String, Integer> mapWish = new HashMap<String, Integer>();
		for(int i = 0; i < magicBox.length; i++){
			String key = magicBox[i];
			Integer wish = mapWish.get(key);
			if(wish == null || wish <= 0)
				key = flipRow(magicBox[i]);
				wish = mapWish.get(key);
            
			if(wish == null || wish <= 0)
				mapWish.put(key, 1);
			else
				mapWish.put(key, wish + 1);
		}
		
		Set<String> keys = mapWish.keySet();
		int maxWish = 0;
		for(String key : keys)
			maxWish = Math.max(mapWish.get(key), maxWish);
		return maxWish;
	}
	
	private static String flipRow(String input) {
		StringBuilder sb = new StringBuilder();
		char[] chars = input.toCharArray();
		for(int i = 0; i < chars.length; i++){
			char c = (chars[i] == 'P') ? 'T' : 'P';
			sb.append(c);
		}
		return sb.toString();
	} 
}