package com.multi.threading;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args){
		Semaphore binary = new Semaphore(1);
		Thread t1 = new Thread( new ThreadRunning(binary), "t1" );
		Thread t2 = new Thread( new ThreadRunning(binary), "t2" );
		t1.start();
		t2.start();
	}
}

class ThreadRunning implements Runnable{
	public Semaphore binary;
	
	public ThreadRunning(Semaphore binary){
		this.binary = binary;
	}
	
	@Override
	public void run(){
		try {
			binary.acquire();
			System.out.println("Thread " + Thread.currentThread().getName() + " is inside the critical region");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("Thread " + Thread.currentThread().getName() + " is out of the critical region");
			binary.release();
		}
	}
}