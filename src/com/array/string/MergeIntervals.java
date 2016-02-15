package com.array.string;
import java.util.*;

import com.linked.list.ListNode;

public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	
	public List<Interval> merge(List<Interval> intervals) {
        // boundary check
        if(intervals == null)
            return null;
        
        int len = intervals.size();
        List<Interval> result = new ArrayList<Interval>();
        if(len <= 0)
            return result;
        
        Interval newInterval = null, nextInterval = intervals.get(0);
        
        for(Interval i : intervals){
        	if(result.isEmpty()){
        		result.add(i);
        		continue;
        	}
        	insert(result, i);
        }
        
        Collections.sort(result, new Comparator<Interval>(){
        	@Override
    		public int compare(Interval l1, Interval l2){
    			if(l1.start > l2.start)
    				return 1;
    			else if(l1.start < l2.start)
    				return -1;
    			else
    				return 0;
    		}
        });
        return result;
    }
	
	public void insert(List<Interval> result, Interval newInterval){
		if(result == null || result.isEmpty() || newInterval == null)
			return;
		
		Interval i;
		for(int j = 0; j < result.size(); j++){
			i = result.get(j);
			if(checkOverlap(i, newInterval)){
				newInterval.start = Math.min(i.start, newInterval.start);
				newInterval.end = Math.max(i.end, newInterval.end);
				result.remove(i);
				j--;
			}
		}
		result.add(newInterval);
	}
    
    public boolean checkOverlap(Interval i1, Interval i2){
        if(i1 == null || i2 == null)
            return false;
        if((i1.start >= i2.start && i1.start <= i2.end) || (i1.end >= i2.start && i1.end <= i2.end) || (i2.start >= i1.start && i2.start <= i1.end) || (i2.end >= i1.start && i2.end <= i1.end))
            return true;
        return false;
    }

}
