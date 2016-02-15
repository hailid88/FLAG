package com.multi.threading;
import java.util.concurrent.Semaphore;

public class SemaphoreTest2 {

	public static void main(String[] args){
		Semaphore s = new Semaphore(1); // binary
		Thread task1 = new Thread(new ExclusiveTask("Task 1", s));
		Thread task2 = new Thread(new ExclusiveTask("Task 2", s));
		Thread task3 = new Thread(new ExclusiveTask("Task 3", s));
		task1.start();
		task2.start();
		task3.start();
	}
	
}

class ExclusiveTask implements Runnable{
	private String name = null;
	private Semaphore shared = null;
	
	public ExclusiveTask(String name, Semaphore shared){
		this.name = name;
		this.shared = shared;
	}
	
	@Override
	public void run(){
		try {
			Thread.sleep(1000);
			shared.acquire();
			System.out.println("Trying to enter the critical region");
			System.out.println("Running Task " + name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("Leave the critical region");
			shared.release();
		}
		
		
	}
}
