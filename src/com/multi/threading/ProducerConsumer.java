package com.multi.threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
	public static void main(String[] args){
		LinkedBlockingQueue<Integer> sharedResources = new LinkedBlockingQueue<Integer>();
		
		Thread producer = new Thread(new ProducerEx(sharedResources), "Producer");
		Thread consumer = new Thread(new ConsumerEx(sharedResources), "Consumer");
		producer.start();
		consumer.start();
	}
}


@SuppressWarnings("unchecked")
class ProducerEx implements Runnable{
	@SuppressWarnings("rawtypes")
	private BlockingQueue sharedResources = null;
	
	@SuppressWarnings("rawtypes")
	public ProducerEx(BlockingQueue sharedResources){
		this.sharedResources = sharedResources;
	}
	
	@Override
	public void run(){
		for(int i = 0; i < 10; i++){			
			try {
				Thread.sleep(10);
				System.out.println("Thread " + Thread.currentThread().getName() + " Produced " + i);
				sharedResources.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ConsumerEx implements Runnable{
	@SuppressWarnings("rawtypes")
	private BlockingQueue sharedResources = null;
	
	@SuppressWarnings("rawtypes")
	public ConsumerEx(BlockingQueue sharedResources){
		this.sharedResources = sharedResources;
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(20);
				System.out.println("Thread " + Thread.currentThread().getName() + " consumed " + sharedResources.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
