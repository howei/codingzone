package math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import other.TestMain.Point;

public class MaxPointsOnALine {
    public static int maxPoints(Point[] points) {
    	if (points == null || points.length == 0) {
    		return 0;
    	} else if (points.length == 1) {
    		return 1;
    	} else if (points.length == 2) {
    		return 2;
    	}
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int length = points.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
        	int duplicate = 0;
        	map.clear();
        	for (int j = 0; j < length; j++) {
        		if (i == j) {
        			continue;
        		}
        		double slope = 0;
        		int diffX = points[i].x - points[j].x;
        		int diffY = points[i].y - points[j].y;
        		if (diffX == 0 && diffY == 0) {
        			duplicate++;
        			continue;
        		} else if (diffX == 0) {
        			slope = Integer.MAX_VALUE*1.0 + 1;
        		} else {
        			slope = diffY*1.0/diffX;
        		}
        		int recurrence = 1;
        		if (map.containsKey(slope)) {
        			recurrence = map.get(slope);
        		}
        		map.put(slope, recurrence + 1);
        	}
        	Iterator<Map.Entry<Double, Integer>> it = map.entrySet().iterator();
        	while (it.hasNext()) {
        		int num = it.next().getValue();
        		if (num + duplicate > max) {
        			max = num + duplicate;
        		}
        	}
        	max = Math.max(max, duplicate + 1);
        }
        return max;
    }
}
