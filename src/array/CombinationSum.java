package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] A = {};
		int target = 7;
		System.out.println(combinationSum(A, target));
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	if (candidates == null || candidates.length == 0) {
    		return new ArrayList<List<Integer>>();
    	}
        int size = candidates.length;
        Arrays.sort(candidates);
        //scan from end to start of the candidates array
        return combSum(candidates, target, size - 1);
    }
    
    public static List<List<Integer>> combSum(int[] candidates, int target, int start) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	for (int i = start; i >= 0; i--) {
    		if (target == candidates[i]) {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(target);
    			res.add(list);
    		} else if (target > candidates[i]) {
    			List<List<Integer>> res0 = combSum(candidates, target - candidates[i], i);
    			for (List<Integer> list : res0) {
    				list.add(candidates[i]);
    				res.add(list);
    			}
    		} 
    	}
    	return res;
    }
}
