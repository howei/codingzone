package array;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer>list = new ArrayList<Integer>();
		
		list.add(2);
		triangle.add(list);
		
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		triangle.add(list);
		
		list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(7);
		triangle.add(list);
		
		list = new ArrayList<Integer>();
		list.add(4);
		list.add(1);
		list.add(8);
		list.add(3);
		triangle.add(list);
		
		System.out.println(minimumTotal(triangle));
		
	}
    public static int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle.size() == 0) {
    		return 0;
    	} else if (triangle.size() == 1) {
    		return triangle.get(0).get(0);
    	}
    	
    	int dp[] = new int[triangle.size()];
    	for (int col = 0; col < triangle.get(triangle.size() - 1).size(); col++) {
    		dp[col] = triangle.get(triangle.size() - 1).get(col);
    	}
    	
        for (int row =  triangle.size() - 2; row >= 0; row--) {
        	for (int col = 0; col < triangle.get(row).size(); col++) {
        		dp[col] = Math.min(dp[col], dp[col+1]) + triangle.get(row).get(col);
        	}
        }
        return dp[0];
    }
}
