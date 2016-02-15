package com.array.string;

public class IsMultiple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abcdabca";
		IsMultiple object = new IsMultiple();
		
		boolean output = object.isMultiple(test);
		System.out.println(output);

	}
	public boolean isMultiple(String s){
		//at least have two element. 
		for(int endIndx=1; endIndx<s.length()-1; endIndx++){
			String substring = s.substring(0, endIndx+1);
			//need to know if substring only has one unique value. 
			int subLen = endIndx+1;
			if(s.length()%subLen==0){
				int multipleNum = s.length()/subLen;
				int i;
				for(i =2; i<=multipleNum; i++){
					String temp = s.substring(endIndx+1+(i-2)*subLen, endIndx+(i-1)*subLen+1);
					if(!substring.equals(temp)){
						break;
					}
				}
				if(i>multipleNum && notSingle(s)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean notSingle(String s){
		char[] charArray = s.toCharArray();
		if(charArray.length==1) return false;
		for (char c: charArray){
			if(c!=charArray[0]){
				return true;
			}
		}
		return false;
	}

}
