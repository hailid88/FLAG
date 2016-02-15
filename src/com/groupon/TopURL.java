package com.groupon;

public class TopURL {

	//have some problem. 
	public int highestCount;
	  public int inputCount;
	  public String topUrl;
	  public String lastInput;

	  
	  // constructor
	  public TopURL() {
	    this.highestCount = 0;
	    this.inputCount = 0;
	    this.topUrl = "";
	    this.lastInput = "";
	  }
	  
	  public void seenURL(String str) {
	    if (str != null || str!= ""){
	       if (str == lastInput) {
	       this.inputCount++;
	     } else{
	       this.inputCount = 1;
	     }
	      if (inputCount >= highestCount) {
	        this.topUrl = str;
	        this.highestCount = inputCount;
	      }
	    lastInput = str;
	    }
	   
	  }
	  
	  public String topURL() {
	    return this.topUrl;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopURL obj = new TopURL();
	    obj.seenURL("a");
	    obj.seenURL("a");
	    obj.seenURL("b");
	    obj.seenURL("c");
	    // ... many many more calls to seenURL() ...
	    System.out.println(obj.topURL()); // should print a

	}

}
