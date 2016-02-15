package com.multi.threading;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {

	public static void main(String[] args){
		int numMappers = 4;
		CyclicBarrier cb = new CyclicBarrier(4, new Reducer());
		Mapper m1 = new Mapper(1, cb);
		Mapper m2 = new Mapper(2, cb);
		Mapper m3 = new Mapper(3, cb);
		Mapper m4 = new Mapper(4, cb);
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		Thread t3 = new Thread(m3);
		Thread t4 = new Thread(m4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
}

class Reducer implements Runnable{
	@Override
	public void run(){
		System.out.println("Running the Reduce task when all map tasks are finished");
	}
}

class Mapper implements Runnable{
	private int id = 0;
	private CyclicBarrier cb = null;
	
	public Mapper(int id, CyclicBarrier cb){
		this.id = id;
		this.cb = cb;
	}
	
	@Override
	public void run(){
		try{
			System.out.println("Runing mapper " + id);
			if(this.cb != null)
				this.cb.await();
			//System.out.println("Finished mapper " + id);
		} catch(InterruptedException | BrokenBarrierException e){
			e.printStackTrace();
		}
	}
}
