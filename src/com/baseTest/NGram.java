package com.baseTest;
import java.util.*;

public class NGram {
	
	public static void main(String[] args){
		String text = "Rain on the green grass, Rain on the green tree, Rain on the rooftops But not on me.";
		int n = 3;
		String sequence = "the green";
		NGram obj = new NGram();
		String resl = obj.ngram(text, n, sequence);
		System.out.println(resl);
	}
	
	
	public String ngram(String text, int n, String sequence){
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		
		String[] words = text.split("\\s+");
		int wordNum = words.length;
		for(int i = 0; i<wordNum-n+1; i++){
			StringBuilder sb = new StringBuilder();
			for(int start = i; start<i+n-1; start++){
				sb.append(words[start]);
				sb.append(" ");
			}
			String n_1gram = sb.toString().trim(); 
			if(hm.containsKey(n_1gram)){
				hm.get(n_1gram).add(words[i+n-1]);
			}
			else{
				ArrayList<String> tmp =  new ArrayList<>();
				tmp.add(words[i+n-1]);
				hm.put(n_1gram, tmp);
			}
		}
		
		if(hm.containsKey(sequence)){
			int len = hm.get(sequence).size();
			Random rd = new Random();
			int pivot = rd.nextInt(len);
			String curr = hm.get(sequence).get(pivot);
			return curr;
		}
		else{
			return null;
		}		
		
	}
	
}
