package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] num = {1,2,3,4};
		System.out.println(permute(num));

	}
    public static List<List<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) {
        	return new ArrayList<List<Integer>>();
        }
        
        return perm(num, num.length - 1);
    }
    
    public static List<List<Integer>> perm(int[] num, int end) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if (end == 0) {
    		List<Integer> list = new ArrayList<Integer>();
    		list.add(num[0]);
    		res.add(list);
    	} else if (end > 0) {
    		List<List<Integer>> res0 = perm(num, end - 1);
    		for (List<Integer> list : res0) {
    			int size = list.size();
    			for (int i = 0; i <= size; i++) {
    				List<Integer> list2 = new ArrayList<Integer>();
    				for (Integer ii : list) {
    					list2.add(ii);
    				}
    				if (i < size) {
    					list2.add(i, num[end]);
    				} else {
    					list2.add(num[end]);
    				}
    				res.add(list2);
    			}
    		}
    	}
    	return res;
    }
    
    
}
