package com.multi.threading;
import java.util.concurrent.*;

public class SchedulerForFuture {
	private final ScheduledExecutorService scheduler = 
			new ScheduledThreadPoolExecutor(1);
	public void beepForAnHour(){
		final Runnable beeper = new Runnable(){
			@Override
			public void run(){
				System.out.println("beep");
			}
		};
		
		final ScheduledFuture<?> beeperHandler = 
//				scheduler.scheduleAtFixedRate(beeper, 1, 1, TimeUnit.SECONDS);
//				scheduler.scheduleWithFixedDelay(beeper, 1, 1, TimeUnit.SECONDS);
				scheduler.schedule(beeper, 1, TimeUnit.SECONDS);
		
		scheduler.schedule(new Runnable(){
			@Override
			public void run(){
				beeperHandler.cancel(true);
			}
		}, 2, TimeUnit.SECONDS);
//		beeperHandler.cancel(true);
	}
	
	public static void main(String[] args){
		SchedulerForFuture schedule = new SchedulerForFuture();
		schedule.beepForAnHour();
	}
	
}
