package com.IXL;

public class WrapText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Hello IXL, Happy 2015 Year!";
		System.out.println(text.substring(1,1));
		int maxCharsPerLine = 5;
		System.out.println(wrapText(text, maxCharsPerLine));

	}
	
	public static String wrapText(String text, int maxCharsPerLine){
		//boundary check. 
		if(text == null || text.length()<=0) return text;
		
		if(maxCharsPerLine<=0) return "";
		
		//know the length of the text;
		int n = text.length();
		
		//if the text is less than the threshold, we can simply return the text. 
		if(n<=maxCharsPerLine){ return text;}
		
		//aft is used to rearrange the text according to the threshold. 
		StringBuffer aft = new StringBuffer();

		int startIndx = 0;
		if(text.charAt(startIndx)==' '){
			startIndx++;
		}
		int endIndx = startIndx;
		
		while(startIndx<text.length()){
			//as the start of text is not allowed to have space, so we need first to remove it. 
			if(text.charAt(startIndx)==' '){
				startIndx++;
			}
			endIndx = startIndx + maxCharsPerLine-1;
			if(endIndx>n-1){
				endIndx = n-1;
			}
			if(startIndx > endIndx){
				break;
			}
			aft.append(text.substring(startIndx, endIndx));
			if(text.charAt(endIndx)!='\n' && endIndx!=n-1){
				if(text.charAt(endIndx) != ' '){
					aft.append(text.charAt(endIndx));
				}
					aft.append("\n");
			}
			else{
				aft.append(text.charAt(endIndx));
				
			}
			startIndx = endIndx+1;
		}
		
		return aft.toString();
	}

}
