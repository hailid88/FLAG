package com.bloomberg;

public class CovertString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "a#3bd#5";
		CovertString obj = new CovertString();
		System.out.println(obj.convert(input));
		int a = -123;
		String astr = Integer.toString(a);
		System.out.println(astr);

	}
	
	public String convert(String input){
		StringBuffer sb = new StringBuffer();
		char pre = input.charAt(0);
		sb.append(pre);
		for(int i = 1; i<input.length(); i++){
			if(input.charAt(i)=='#')
			{continue;}
			else{ 
				if(Character.isDigit(input.charAt(i))){
					for(int j=1;j<input.charAt(i)-'0'; j++){
						sb.append(pre);
					}
				}
				else{
					sb.append(input.charAt(i));
					pre = input.charAt(i);
				}
			}
		}
		
		return sb.toString();
	}

}
