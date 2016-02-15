package com.linkedin;
import java.util.*;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // boundary check
    	List<Interval> result = new ArrayList<Interval>();
    	if(intervals == null && newInterval == null)
    		return null;
    	else if(intervals == null || intervals.isEmpty()){
    		result.add(newInterval);
    		return result;
    	}
    	else if(newInterval == null){
    		return intervals;
    	}
    
    	// find the place and merge
    	Interval peekInterval = null;
    	boolean isMerge = false, isAdd = false;
    	for(Interval i : intervals){
    		if (!isMerge && i.start > newInterval.end){
    			result.add(newInterval);
    			isMerge = true;
    		}
    		result.add(i);
    		if(i.end >= newInterval.start){
    			isAdd = false;
    			while(!result.isEmpty() && checkOverlap(result.get(result.size() - 1), newInterval) ){
    				peekInterval = result.remove(result.size() - 1);
    				newInterval.start = Math.min(peekInterval.start, newInterval.start);
    				newInterval.end = Math.max(peekInterval.end, newInterval.end);
    				isAdd = true;
    				isMerge = true; 
    			}
    			if(isAdd)
    				result.add(newInterval);
    		}
    		// if - else
    	} // for
    	if(!isMerge)
    		result.add(newInterval);
    
    	return result;
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
		InsertInterval insert = new InsertInterval();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(6, 9));
//		intervals.clear();
		Interval newInterval = new Interval(2, 5);
		
		List<Interval> result = insert.insert(intervals, newInterval);
		for(Interval i : result){
			System.out.print(i.getString() + ", ");
		}
	}
	
}
