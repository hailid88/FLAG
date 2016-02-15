package com.linkedin;
import java.util.*;

/**
 * Maintain an array list to store the visited intervals
 * 
 * check each interval i in the result to see if it is overlapped with the new interval,
	if overlap, remove i from result and merge new interval with interval i
 * 
 *
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        // boundary check
        if(intervals == null)
            return null;
        
        int len = intervals.size();
        List<Interval> result = new ArrayList<Interval>();
        if(len <= 0)
            return result;
        
//        Interval newInterval = null, nextInterval = intervals.get(0);
        
        // check for each interval
        for(Interval i : intervals){
        	if(result.isEmpty()){
        		result.add(i);
        		continue;
        	}
        	insert(result, i);
        }
        
        return result;
    }
	
	public void insert(List<Interval> result, Interval newInterval){
		if(result == null || result.isEmpty() || newInterval == null)
			return;
		
		// check each interval i in the result to see if it is overlapped with the new interval,
		// if overlap, remove i from result and merge new interval with interval i
		Interval i = null;
		int len = result.size() - 1;
		for(int j = len; j >= 0; j--){
			i = result.get(j);
			if(checkOverlap(i, newInterval)){
				newInterval.start = Math.min(i.start, newInterval.start);
				newInterval.end = Math.max(i.end, newInterval.end);
				result.remove(i);
			}
			else // if sorted interval, does not need continue finding previous intervals
				// if the intervals are not sorted, we need to remove this else
				break;
		}
		result.add(newInterval);
	}
    
    public boolean checkOverlap(Interval i1, Interval i2){
        if(i1 == null || i2 == null)
            return false;
        if((i1.start >= i2.start && i1.start <= i2.end) || (i1.end >= i2.start && i1.end <= i2.end))
            return true;
        if((i2.start >= i1.start && i2.start <= i1.end) || (i2.end >= i1.start && i2.end <= i1.end))
            return true;
        return false;
    }
    
    public static void main(String[] args){
    	
    	List<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(new Interval(6, 10));
    	intervals.add(new Interval(2, 3));
    	intervals.add(new Interval(4, 5));
    	intervals.add(new Interval(8, 9));
    	intervals.add(new Interval(6, 7));
    	
//    	intervals.clear();
//    	intervals.add(new Interval(1, 4));
//    	intervals.add(new Interval(5, 6));
////    	intervals.clear();
//    	intervals.add(new Interval(1, 4));
//    	intervals.add(new Interval(0, 2));
//    	intervals.add(new Interval(3, 5));
    	
    	MergeIntervals m = new MergeIntervals();
    	List<Interval> result = m.merge(intervals);
    	for(Interval i : result)
    		System.out.print(i.getString() + ", ");
//Input:	[[2,3],[4,5],[6,7],[8,9],[1,10]]
//Output:	[[2,3],[4,5],[6,7],[1,10]]
//Expected:	[[1,10]]
    }
}
