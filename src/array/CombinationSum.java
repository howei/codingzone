package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] A = {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(A, target));
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int size = candidates.length;
        Arrays.sort(candidates);
        

        
        
        return result;
    }
}
