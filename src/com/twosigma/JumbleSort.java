package com.twosigma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


public class JumbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> input = new ArrayList<String>();
		input.add("test case 2 is 12 or not 1");
		JumbleSort obj = new JumbleSort();
		ArrayList<String> output = obj.jumbleSortPQ(input);
		System.out.println(output.get(0));

	}
	
	
	//by using priority queue.
	//using PriorityQueue, it will automatically sort the items in the List. 
	public ArrayList<String> jumbleSortPQ(ArrayList<String> input){
		if(input==null){
			return null;
		}
		ArrayList<String> output = new ArrayList<String>();
		for(String item : input){
			String[] words = item.split(" ");
			Queue<String> strList = new PriorityQueue<String>();
			Queue<Integer> intList = new PriorityQueue<Integer>();
			boolean[] isNum = new boolean[words.length];
			
			//construct the two PriorityQueue. 
			for(int i = 0; i<words.length; i++){
				//if lower case is equal to upper case, then it is number. 
				if(words[i]==words[i].toUpperCase()){
					isNum[i]=true;
					intList.offer(Integer.parseInt(words[i]));
				}else{
					strList.offer(words[i]);
				}
			}
			
			//poll out according to the sequence. 
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<words.length; i++){
				if(isNum[i]){
					sb.append(intList.poll());
					
				}
				else{
					sb.append(strList.poll());
					
				}
				if(i<words.length-1){
					sb.append(" ");
				}
			}
			output.add(sb.toString());
		}
		return output;
	}
	
	
	
	public ArrayList<String> jumbleSort(ArrayList<String> input){
		if(input==null){
			return null;
		}
		ArrayList<String> output = new ArrayList<String>();
		for(String item : input){
			String[] words = item.split(" ");
			ArrayList<String> strList = new ArrayList<String>();
			ArrayList<Integer> intList = new ArrayList<Integer>();
			boolean[] isNum = new boolean[words.length];
			for(int i = 0; i<words.length; i++){
				if(words[i]==words[i].toUpperCase()){
					isNum[i]=true;
					intList.add(Integer.parseInt(words[i]));
				}else{
					strList.add(words[i]);
				}
			}
			Collections.sort(strList);
			Collections.sort(intList);
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<words.length; i++){
				if(isNum[i]){
					sb.append(intList.get(0));
					intList.remove(0);
				}
				else{
					sb.append(strList.get(0));
					strList.remove(0);
				}
				if(i<words.length-1){
					sb.append(" ");
				}
			}
			output.add(sb.toString());
		}
		return output;
	}

}
