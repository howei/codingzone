package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

	public static void main(String[] args) {
		int[] num = {1,1,2};
		System.out.println(permuteUnique(num));

	}
    public static List<List<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
        	return new ArrayList<List<Integer>>();
        }
        
        Set<List<Integer>> res = perm(num, num.length - 1);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.addAll(res);
        return result;
    }
    
    public static Set<List<Integer>> perm(int[] num, int end) {
    	Set<List<Integer>> res = new HashSet<List<Integer>>();
    	if (end == 0) {
    		List<Integer> list = new ArrayList<Integer>();
    		list.add(num[0]);
    		res.add(list);
    	} else if (end > 0) {
    		Set<List<Integer>> res0 = perm(num, end - 1);
    		for (List<Integer> list : res0) {
    			int size = list.size();
    			for (int i = 0; i <= size; i++) {
    				List<Integer> list2 = new ArrayList<Integer>();
    				for (Integer ii : list) {
    					list2.add(ii);
    				}
    				if (i < size) {
    					list2.add(i, num[end]);
        				res.add(list2);
    				} else if (i == size && !list2.contains(num[end])) {
    					list2.add(num[end]);
        				res.add(list2);
    				}
    			}
    		}
    	}
    	return res;
    }
    
    
}
