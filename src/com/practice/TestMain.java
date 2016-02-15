package com.practice;

public final class TestMain {
	/**
	 * @param args
	 */
	class Inner{
		void test(){
			if(TestMain.this.flag);{
				sample();
			}
		}
	}
	private boolean flag =true;
	public void sample(){
		System.out.println("Sample");
	}
	
	public TestMain(){
		(new Inner()).test();
	}
	public static void main(String args[]){
		new TestMain();
	}

}
