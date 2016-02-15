package com.array.string;
import java.util.*;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> resl = findRepeatedDnaSequences(s);
		for(String item:resl){
			System.out.println(item);
		}

	}
	
	
	
	public List<String> findRepeatedDnaSequences2(String s) {
        int len = s.length();
        if (len<10) return new ArrayList<String>();
        int a = 0;
        int m =1;
        //the first 10 character string. 
        for(int i=0;i<10;i++){
            a = a*4 + getCode(s.charAt(i));
            m *=4;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> r = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();
        set.add(a);
        int p = 10;
        while (p<len){
            a = (a*4 + getCode(s.charAt(p))) % m;
            if (set.contains(a) && !r.contains(a)) {
                result.add(s.substring(p-9, p+1));
                r.add(a);
            }else set.add(a);
            p++;
        }
        return result;
    }
    private int getCode(char c){
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        if (c == 'T') return 3;
        return 0;
    }
	
    
    
    
    
    //In Leetcode, this will have the problem of "Memory Limit Exceeded". 
	public static List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Map<String, Integer> hm = new HashMap<>();
        for(int i = 0; i<=n-10; i++){
            String tmp = s.substring(i, i+10);
            if(hm.containsKey(tmp)){
                hm.put(tmp, hm.get(tmp)+1);
            }
            else{
                hm.put(tmp, 1);
            }
        }
        List<String> resl = new ArrayList<>();
        Set<String> keys = hm.keySet();
        for(String item:keys){
            if(hm.get(item)>1){
                resl.add(item);
            }
        }
        return resl;
	}
	

}
