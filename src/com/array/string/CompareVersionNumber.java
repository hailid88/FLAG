package com.array.string;

public class CompareVersionNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String version1 = "1.1";
		String version2 = "2.1";
		//String versiontest = "1..........2";
//		/String[] va1 = versiontest.split("\\.+");
		int result = compareVersion(version1, version2);
		System.out.println(result);
		int foo = Integer.parseInt("0121");
		System.out.println(foo);
		
	}
	
	 public static int compareVersion(String version1, String version2) {
		 String[] va1 = version1.split("\\.+");
	        for(String v : va1)
	        	System.out.println(v);
	        String[] va2 = version2.split("\\.+");

	        int result;
	        
	        int[] int1 = new int[va1.length];
	        int[] int2 = new int[va2.length];
	        for(int i=0; i<va1.length; i++){
	            int1[i] = Integer.parseInt(va1[i]);
	        }
	        for(int j=0; j<va2.length; j++){
	            int2[j] = Integer.parseInt(va2[j]);
	        }
	        
	        for(int i=0; i<Math.min(int1.length, int2.length); i++){
	             if(int1[i]<int2[i]){
	                 return -1;
	             }
	             if(int1[i]>int2[i]){
	                 return 1;
	             }
	        }
	        
	        if(int1.length>int2.length){
	        	return compare(int1, int2.length);
	            
	        }
	        else if(int1.length<int2.length){
	        	return -1*compare(int2, int1.length);
	            
	        }
	        else{
	            return 0;
	        }
     
    }
	 
	 private static int compare(int[] a, int start){
		 //the element number in a is larger than b. 
		 for(int i = start; i<a.length; i++){
             if(a[start]>0){
                 return 1;
             }
         }
         return 0;
	 }

}
