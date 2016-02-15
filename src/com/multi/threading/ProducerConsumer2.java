package com.multi.threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer2 {

	public static void main(String[] args){
		LinkedBlockingQueue<Integer> shared = new LinkedBlockingQueue<Integer>();
		Thread producer1 = new Thread(new ProducerTask(shared, 1));
		Thread producer2 = new Thread(new ProducerTask(shared, 2));
		//Thread producer3 = new Thread(new ProducerTask(shared, 3));
		
		Thread consumer1 = new Thread(new ConsumerTask(shared, 1));
		Thread consumer2 = new Thread(new ConsumerTask(shared, 2));
		
		producer1.start();
		producer2.start();
		//producer3.start();
		consumer1.start();
		consumer2.start();
	}
	
}

class ProducerTask implements Runnable{
	private BlockingQueue shared = null;
	private int id;
	private int taskId;
	
	public ProducerTask(BlockingQueue shared, int id){
		this.shared = shared;
		this.id = id;
	}
	
	@Override
	public void run(){
		for(int i = 0; i < 10; i++){
			this.taskId = i * 10 + id;
			
			System.out.println("Producer " + id + " produce " + this.taskId);
			try {
				Thread.sleep(5);
				this.shared.put(this.taskId);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ConsumerTask implements Runnable{
	private BlockingQueue shared = null;
	private int id;
	
	public ConsumerTask(BlockingQueue shared, int id){
		this.shared = shared;
		this.id = id;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(10);
				System.out.println("Consumer " + id + " processed task " + shared.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
