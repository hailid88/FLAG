package com.multi.threading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {

	public static void main(String[] args){
		CountDownLatch countDownLatch = new CountDownLatch(3);
		Thread processor1 = new Thread(new Processor(countDownLatch, 1));
		Thread processor2 = new Thread(new Processor(countDownLatch, 2));
		Thread processor3 = new Thread(new Processor(countDownLatch, 3));
		processor1.start();
		processor2.start();
		processor3.start();
		try {
			countDownLatch.await();
			System.out.println("Redidual processors: " + countDownLatch.getCount());
			System.out.println("All processor has been counted");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Processor implements Runnable{
	private CountDownLatch latch = null;
	private int id;
	
	public Processor(CountDownLatch latch, int id){
		this.latch = latch;
		this.id = id;
	}
	
	@Override
	public void run(){
		System.out.println("Running processor " + id + "; Redidual processors: " + this.latch.getCount());
		if(this.latch != null)
			this.latch.countDown();
	}
}
