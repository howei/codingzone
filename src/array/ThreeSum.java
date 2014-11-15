package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		//int[] num = { -2, -3, -3, 10, 7, 0, 9, -4, 6, -1, 5};
		int[] num = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		List<List<Integer>> result = threeSum(num);
		System.out.println(result.toString());
	}
	
    public static List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	int size = num.length;
    	if (size < 3) {
    		return result;
    	}
    	
    	Arrays.sort(num);
    	for (int i = 0; i < size - 2; i++) {
    		while (i > 0 && num[i] == num[i - 1]) {
    			i++;
    			if (i >= size - 2) {
    				return result;
    			}
    		}
        	int low = i + 1;
        	int high = size - 1;
        	while (high - low >= 1) {
        		if (num[i] + num[low] + num[high] == 0) {
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(num[i]);
        			list.add(num[low]);
        			list.add(num[high]);
        			result.add(list);
        			while (high - low > 1 && num[high] == num[high - 1]) {
        				high--;
        			}
        			high--;
        			while (high - low > 1 && num[low] == num[low + 1]) {
        				low++;
        			}
        			low++;
        		} else if (num[i] + num[low] + num[high] > 0) {
        			high--;
        		} else {
        			low++;
        		}
        	}
    	}
    	return result;
    }
}
