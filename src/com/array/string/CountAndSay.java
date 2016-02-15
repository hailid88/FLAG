package com.array.string;

import java.util.ArrayList;
import java.util.Stack;

public class CountAndSay {

	/**
	 * @param args
	 * 
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int input =2;
		//System.out.println(2*Math.pow(10, input));
		//int output = sayInteger(input);
	    //String output = countAndSay(input);
		//System.out.println(output);

	}
	
	public String countAndSay(int n){
		String output ="1";
		if(n<1) return null;
		if(n==1) return output;
		
		
		String oldString = output;
		while(n>1){
			int count = 1;
			char[] charArray = oldString.toCharArray();
			int len = charArray.length;
			StringBuilder oldS= new StringBuilder();
			for(int i=0; i<len-1; i++){
				if(charArray[i+1]==charArray[i]){
					count ++;
				}
				else{
					oldS.append(count);
					oldS.append(charArray[i]);
					count =1;
				}
			}
			oldS.append(count);
			oldS.append(charArray[len-1]);
			oldString = oldS.toString();
			n--;
		}
		return oldString;
	}
	
//	public static String countAndSay(int n){
//		int result = 1;
//		if(n==1){
//			return "1";
//		}
//		
//		for(int i=1; i<=n-1; i++){
//			result = sayInteger(result);
//		}
//		return Integer.toString(result);
//	}
//		
//	public static String countAndSay2(int n){
//		String result = "1";
//        if (n == 1) {
//            return result;
//        }
//        char tmp = 0;
//        StringBuilder sb = new StringBuilder();
//        ArrayList<String> group = new ArrayList<String>();
//
//        while (n > 1) {
//            tmp = 0;
//            sb.setLength(0);
//            group.clear();
//
//            for (int i = 0; i < result.length(); i++) {
//
//                if (i == 0) {
//                    // first case
//                    tmp = result.charAt(i);
//                    sb.append(tmp);
//                } else {
//                    if (result.charAt(i) != tmp) {
//                        group.add(sb.toString());
//
//                        tmp = result.charAt(i);
//
//                        sb.setLength(0);
//                        sb.append(tmp);
//                    } else {
//                        sb.append(result.charAt(i));
//                    }
//
//                    // last case
//                    if (i == result.length() - 1) {
//                        group.add(sb.toString());
//                    }
//                }
//            }
//
//            // For case: result.length() == 1
//            if (group.size() == 0) {
//                group.add(sb.toString());
//            }
//
//            // Generate answer from group
//            sb.setLength(0);
//            for (int i = 0; i < group.size(); i++) {
//
//                String numOfRepeat = String.valueOf(group.get(i).length());
//                String value = String.valueOf(group.get(i).charAt(0));
//
//                sb.append(numOfRepeat).append(value);
//            }
//
//            result = sb.toString();
//
//            n--;
//        }
//
//        return result;
//	}
//	
//    public static int sayInteger(int n) {
//        Stack<Integer> m = new Stack<Integer>();
//        int num =0;
//        int frequency=0;
//        while(n>0){
//             num = n%10;
//             n = n/10;
//             if(m.empty()){
//                 m.push(num);
//                 frequency = 1;
//             }
//             else if(num == m.peek()){
//                 frequency ++;
//             }
//             else{
//                 m.push(frequency);
//                 m.push(num);
//                 frequency = 1;
//             }
//        }
//        m.push(frequency);
//        
//        //StringBuffer a = new StringBuffer();
//        int result = 0;
//        while(!m.empty()){
//        	result = result*10 + m.pop();
//        }
//        
//        return result;
//    }

}
