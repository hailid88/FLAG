package com.array.string;
import java.util.*;


public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<>();
		
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(4,5));
		Interval newInterval = new Interval(1,3);
		
		InsertInterval obj = new InsertInterval();
		List<Interval> resl = obj.insert(intervals, newInterval);

	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval==null) return intervals;  
        if(intervals == null || intervals.size()==0) {
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);  
            return intervals;  
        }  
          
        ListIterator<Interval> it = intervals.listIterator();  
        while(it.hasNext()) {  
            Interval tmpInterval = it.next();  
            if(newInterval.end<tmpInterval.start) {  
                it.previous();
                it.add(newInterval);  
                return intervals;  
            } else {  
                if(tmpInterval.end>newInterval.start) {  
                	newInterval.start = Math.min(tmpInterval.start, newInterval.start);  
                    newInterval.end   = Math.max(tmpInterval.end, newInterval.end);  
                    it.remove();  
                    System.out.println(intervals.size());
                } 
            }  
        }  
        intervals.add(newInterval);  
        return intervals;  
    }

}

class Interval{
	int start;
	int end;
	Interval(){start = 0; end=0;}
	Interval(int s, int e){ start = s; end =e;}
}
