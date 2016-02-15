package com.multi.threading;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchTest {
	private static class Service implements Runnable{
		private String name;
		private int timeToStart;
		private final CountDownLatch latch;
		
		public Service(CountDownLatch latch, int timeToStart, String name){
			this.name = name;
			this.timeToStart = timeToStart;
			this.latch = latch;
		}
		
		@Override
		public void run(){
			try {
				Thread.sleep(timeToStart);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread " + this.name + " is up");
			this.latch.countDown();
		}
	}
	
	public static void main(String[] args){
		final CountDownLatch latch = new CountDownLatch(3);
		
		Thread t1 = new Thread(new Service(latch, 10, "s1"));
		Thread t2 = new Thread(new Service(latch, 10, "s2"));
		Thread t3 = new Thread(new Service(latch, 10, "s3"));
		Thread t4 = new Thread(new Service(latch, 10, "s4"));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			latch.await();
			System.out.println("All services are up");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Services implements Runnable{
	private String name;
	private int timeToStart;
	private final CountDownLatch latch;
	
	public Services(CountDownLatch latch, int timeToStart, String name){
		this.name = name;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}
	
	@Override
	public void run(){
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread " + this.name + " is up");
		this.latch.countDown();
	}
}
