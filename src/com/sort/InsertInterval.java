package com.sort;
import java.util.*;

public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//intervals are already sorted. 
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){  
        if(intervals==null||newInterval==null) {  
            return intervals;  
        }  
          
        if(intervals.size()==0) {  
            intervals.add(newInterval);  
            return intervals;  
        }  
          
        ListIterator<Interval> it = intervals.listIterator();    //use iterator to solve the problem. 	
        while(it.hasNext()) {  
            Interval tmpInterval = it.next();  
            if(newInterval.end<tmpInterval.start) {  
                it.previous();  
                it.add(newInterval);  
                return intervals;  
            } else {  
                if(tmpInterval.end<newInterval.start) {  
                    continue;  
                } else {  
                    newInterval.start = Math.min(tmpInterval.start, newInterval.start);  
                    newInterval.end   = Math.max(tmpInterval.end, newInterval.end);  
                    it.remove();  
                }  
            }  
        }  
        intervals.add(newInterval);  
        return intervals;  
    }
	
	
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

}


class Interval{
	int start;
	int end;
	Interval(){start = 0; end=0;}
	Interval(int s, int e){ start = s; end =e;}
}
