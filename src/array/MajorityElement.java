package array;

public class MajorityElement {
    public static int majorityElement(int[] num) {
    	if (num.length == 1) {
    		return num[0];
    	}
    	int count = 1;
    	Integer majorityEle = num[0];
        for (int i = 1; i < num.length; i++) {
        	if (num[i] != majorityEle) {
        		if (count == 0) {
        			majorityEle = num[i];
        			count++;
        		} else {
        			count--;
        		}
        	} else {
        		if (count == 0) {
        			majorityEle = num[i];
        		}
        		count++;
        	}
        }
        return majorityEle;
    }
}
