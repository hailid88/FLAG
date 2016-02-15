package com.yahoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.PriorityQueue;

public class CountFreq {
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	public void coutFreq(String s){
           int sLen = s.length();
                   
	       String[] words = s.split("\\s+");
	       int wordNum = words.length;
	       for(int i =0; i<wordNum; i++){
              if(hm.containsKey(words[i])){
                       hm.put(words[i], hm.get(words[i])+1); 
              } 
			 else{
			          hm.put(words[i], 1);
			 }
	       }
	       
//	       Entry[] table = new Entry[20];
//	       Entry<String, Integer> ls = table[1];
	       
	       
	       Set<Map.Entry<String, Integer>> set = hm.entrySet();
	       List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
	       Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
	    	   public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
	    	   {
	    		   
	    		   if(o1.getValue()<o2.getValue()){
	    			   return -1;
	    		   }
	    		   else if(o1.getValue()>o2.getValue()){
	    			   return 1;
	    		   }
	    		   else{
	    			   return 0;
	    		   }
	    		   //return (o2.getValue()).compareTo( o1.getValue() );
	    	   }
	       });
	       
	       
	       for(Map.Entry<String, Integer> entry:list){
	           System.out.println(entry.getValue() + "  " + entry.getKey());
	       }
   } 
	

	public List<Entry<String, Integer>> topK(String s, int k){
        int sLen = s.length();
        
		String[] words = s.split("\\s+");
		int wordNum = words.length;
		for(int i =0; i<wordNum; i++){
		   if(hm.containsKey(words[i])){
		            hm.put(words[i], hm.get(words[i])+1); 
		   } 
			 else{
			          hm.put(words[i], 1);
			 }
		}
		//entry set is <key, value> set. 
		Set<Entry<String, Integer>> set = hm.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
		PriorityQueue<Entry<String, Integer>> minHeap =  new PriorityQueue<>(k, new Comparator<Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> item1, Entry<String, Integer> item2){
				if(item1.getValue() > item2.getValue())
					return 1;
				else if(item1.getValue() > item2.getValue())
					return -1;
				else
					return 0;
			}
		});
		
		for(Entry<String, Integer> item : list){
			if(minHeap.size() < k)
				minHeap.add(item);
			else{
				if(minHeap.peek().getValue() < item.getValue()){
					minHeap.poll();
					minHeap.offer(item);
				} // if
			} // if - else
		} // for : w
		
		return new ArrayList<Entry<String, Integer>>(minHeap);
	}
}
