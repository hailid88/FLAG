package com.dropbox;

import java.lang.System;

/**
 * Write two functions, 
 *  one that increments a log counter and 
 *  another that gets the count of the logs from 
 *  the last 5 minutes
 *  
 * http://www.careercup.com/question?id=14908664
 * http://www.mitbbs.ca/article_t/JobHunting/32549839.html
 * 
 * First interview involved finding the sum to a target in an array, 
 * second involved designing a log-hit counter for a website. 
 * I was allowed to write both in java.  
 */
public class LogHitGetHit {
	int[] hitCount = null;
	int size = 0;
	long total = 0, last = 0;
	
	public LogHitGetHit(int size){
		this.size = size;
		if(size <= 0)
			throw new RuntimeException("Invalid input");
		this.hitCount = new int[this.size];
	}
	
	public long getHit(){
		long cur = System.currentTimeMillis() / 1000;
		
		for(int t = (int) (last + 1); (t - last) <= size && t <= cur; t++){
			int i = t % size;
			total -= hitCount[i];
			hitCount[i] = 0;
		}
		last = cur;
		return this.total;
	}
	
	public void hitCount(){
		long cur = System.currentTimeMillis() / 1000;
		
		for(int t = (int) (last + 1); (t - last) <= size && t <= cur; t++){
			int i = t % size;
			total -= hitCount[i];
			hitCount[i] = 0;
		}
		hitCount[(int)(cur % size)]++;
		total++;
		last = cur;
	}
}
