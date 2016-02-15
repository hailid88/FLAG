package com.multi.threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FifoReadWriteLock{
	int readAcquires = 0, readReleases = 0;
	boolean writer = false;
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	public static void main(String[] args){
		FifoReadWriteLock f = new FifoReadWriteLock();
		
		f.writeLock();
		System.out.println("perform write operation");
		
		f.readLock();
		System.out.println("perform read operation");
		
		
		f.writeUnlock();
		
		f.readUnlock();
	}
	
	void readLock(){
		lock.lock();
		try{
			while(writer){
				condition.await();
			}
			readAcquires++;
		}
		catch(Exception e){
			
		}
		finally{
			lock.unlock();
		}
	}
	
	void readUnlock(){
		lock.lock();
		try{
			readReleases++;
			if(readAcquires == readReleases)
				condition.signalAll();
		}
		catch(Exception e){
			
		}
		finally{
			lock.unlock();
		}
	}
	
	void writeLock () {
        lock.lock();
        try {
            while (writer)
                condition.await();

            writer = true;

            while (readAcquires != readReleases)
                condition.await();
        }
        catch(Exception e){
			
		}
        finally {
            lock.unlock();
        }
    }

    void writeUnlock() {
        writer = false;
        condition.signalAll();
    }
}

class Reader implements Runnable{

	public ReentrantLock lock;
	Condition condition;
	public Reader(ReentrantLock lock, Condition condition){
		this.lock = lock;
		this.condition = condition;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
