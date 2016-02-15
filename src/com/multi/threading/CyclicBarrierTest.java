package com.multi.threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
	private static class Task implements Runnable{
		public CyclicBarrier barrier = null;
		public Task(CyclicBarrier barrier){
			this.barrier = barrier;
		}
		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
				barrier.await();
				System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}			
		}
	}
	
	public static void main(String[] args){
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable(){
			@Override
			public void run(){
				System.out.println("Running the tasks when all the threads arrived the barrier");
			}
		});
		
		Thread t1 = new Thread(new Task(cb), "Thread 1");
		Thread t2 = new Thread(new Task(cb), "Thread 2");
		Thread t3 = new Thread(new Task(cb), "Thread 3");
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread t4 = new Thread(new Task(cb), "Thread 4");
		Thread t5 = new Thread(new Task(cb), "Thread 5");
		Thread t6 = new Thread(new Task(cb), "Thread 6");
		t4.start();
		t5.start();
		t6.start();
	}
}
