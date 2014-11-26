package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		int[] A = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(combinationSum2(A, target));
	}
	
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	if (candidates == null || candidates.length == 0) {
    		return new ArrayList<List<Integer>>();
    	}
        int size = candidates.length;
        Arrays.sort(candidates);
        //scan from end to start of the candidates array
        List<List<Integer>> res = combSum(candidates, target, size - 1);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> list : res) {
        	if (!result.contains(list)) {
        		result.add(list);
        	}
        }
        return result;
    }
    
    public static List<List<Integer>> combSum(int[] candidates, int target, int start) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	for (int i = start; i >= 0; i--) {
    		if (target == candidates[i]) {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(target);
    			res.add(list);
    		} else if (target > candidates[i]) {
    			List<List<Integer>> res0 = combSum(candidates, target - candidates[i], i - 1);
    			for (List<Integer> list : res0) {
    				list.add(candidates[i]);
    				res.add(list);
    			}
    		} 
    	}
    	return res;
    }
}
