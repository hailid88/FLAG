package com.multi.threading;

public class JoinTest {
	
	public static void main(String[] args){
		Thread t1 = new Thread(new Join(), "t1");
		Thread t2 = new Thread(new Join(t1), "t2");
		Thread t3 = new Thread(new Join(t2), "t3");
		t3.start();
		t2.start();
		t1.start();
	}

}


class Join implements Runnable{
	public Thread precedingThread = null;
	
	public Join(){};
	
	public Join(Thread precedingThread){
		this.precedingThread = precedingThread;
	}
	@Override
	public void run(){
		try {
			System.out.println("Thread " + Thread.currentThread().getName() + " is starting");
			if(this.precedingThread != null)
				this.precedingThread.join();
			Thread.sleep(100);
//			Thread.yield();
//			Thread.currentThread().interrupt();
			System.out.println(Thread.currentThread().isInterrupted());
			System.out.println("Thread " + Thread.currentThread().getName() + " is completed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}