package com.multi.threading;

public class NotifyWaitTest {
	public static void main(String[] args){
		ThreadNotify tn = new ThreadNotify();
		Thread t = new Thread(tn);
		t.start();
		synchronized(t){
			try{
				t.wait();
//				tn.wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		System.out.println("The total number is " + tn.total);
		
		
		ThreadNotifys tns = new ThreadNotifys();
		tns.start();
		synchronized(tns){
			try{
				tns.wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		System.out.println("The total is " + tns.total);
	}
}

class ThreadNotifys extends Thread{
	int total;
	@Override
	public void run(){
		synchronized(this){
			this.total = 0;
			for(int i = 0; i < 10; i++){
				this.total += i;
				try{
					Thread.sleep(1); 
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			notify();
		}
//		Thread.currentThread().notify();
	}
}

class ThreadNotify implements Runnable{
	int total;
	@Override
	public void run(){
		synchronized(this){
			this.total = 0;
			for(int i = 0; i < 2; i++){
				this.total += i;
				try{
					Thread.sleep(1);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			notify();
		}
	}
}
