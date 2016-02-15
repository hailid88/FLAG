package com.array.string;

public class IsRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        IsRotation newObject = new IsRotation();
        boolean output = newObject.isRotation("Wel", "elW");
        System.out.println(output);
		

	}
	
	public boolean isRotation(String str1, String str2){
		String newStr = str1+ str1;
		if(isSubstring(newStr, str2)){
			return true;
		}
		return false;
	}
	
	public boolean isSubstring(String str, String substr){
		if(str.indexOf(substr)==-1){
			return false;
		}
		else
		{
			return true;
		}	
	}
}
