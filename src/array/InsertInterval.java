package array;

import java.util.ArrayList;
import java.util.List;

import other.TestMain;
import other.TestMain.Interval;

public class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> res = new ArrayList<Interval>();
    	if (intervals == null || intervals.size() == 0) {
    		res.add(newInterval);
    		return res;
    	}
        
        for (int i = 0; i < intervals.size(); i++) {
        	if (intervals.get(i).end < newInterval.start) {
        		res.add(intervals.get(i));
        	} else if (intervals.get(i).start > newInterval.end) {
        		res.add(newInterval);
        		newInterval = intervals.get(i);
        	} else {
        		newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
        				Math.max(intervals.get(i).end, newInterval.end));
        	}
        }
        res.add(newInterval);
    	return res;
    }
}
