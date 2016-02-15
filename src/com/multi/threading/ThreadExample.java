package com.multi.threading;

public class ThreadExample implements Runnable{
//public class ThreadExample extends Thread {

	volatile int  count = 0;
	
	volatile int threadNumber = 0;
	
	public ThreadExample(int i){
		this.count = i;
	}
	
//	public void start(){
//		System.out.println("starting " + this.count);
//		this.run();
//	}
	
	public static void main(String[] args){
		ThreadExample threadEx = null;
		for(int i = 0; i < 10; i++){
			Thread test = new Thread(new ThreadExample(i));
			System.out.println("starting " + test);
			test.start();
		}
		
		System.out.println("---------------------------");
		for(int i = 10; i < 20; i++){
			Thread test = new Thread(new ThreadExample(i));
			System.out.println("starting " + test);
			test.run();
		}
		
		System.out.println("***************************");
		
		
		
	}

	@Override
	public void run() {
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.count);
		this.count++;
	}
	
	
	
}
