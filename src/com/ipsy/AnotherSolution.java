package com.ipsy;
import java.util.*;
import java.io.*;


/*
 * 
http://www.careercup.com/question?id=5840928073842688
1. Remove the edge (pointer) from 1. 
2. Find connected components. 
3. The answer is the number of connected components - 1 (i.e. all the connected components except for the one that contains 1).
 */
public class AnotherSolution {
	

	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        BufferedReader r = null;
              
        try{
            r = new BufferedReader(new InputStreamReader(System.in));
            String s = r.readLine();
            int T = Integer.parseInt(s);
            int[] nodes = new int[T];
            for(int t = 0; t<T; t++){
                String N = r.readLine();
                int n = Integer.parseInt(N);
                //nodes.add(n);
                nodes[t] = n;
            }
            
            int result = getNumRedirects(nodes);
            System.out.println(result);
            
            
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
        	if(r != null)
        		r.close();
        }
    }
 
    
	public static int getNumRedirects(int [] nodes){
		 int n = nodes.length;
		 if(n < 1) return 0;
		 int [] timestamps = new int[n];
		 int ts = 1;
		 HashSet<Integer> goodTimes = new HashSet<>();
		 timestamps[0] = ts;
		 int ret = 0 ;
		 for(int i = 1; i < n ; i++){
			 if(timestamps[i] <= 0) {
				 ts++;
				 int c = i;
				 while(timestamps[c] <=0){
					 timestamps[c] = ts;
					 c = nodes[c]-1;
				 }
				 if(timestamps[c] < ts){
					 if(goodTimes.contains(timestamps[c]) ){
						 goodTimes.add(ts);
					 }
				 } else { // equals
					 ret++;
				 }
			 }		

		 }
		 return ret;
	 }

}
