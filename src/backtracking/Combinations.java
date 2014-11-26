package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		System.out.println(combine(4, 3));

	}

	public static List<List<Integer>> combine(int n, int k) {
		if (n < k || n <= 0 || k <= 0) {
			return new ArrayList<List<Integer>>();
		}

		return comb(n, k);
	}

	public static List<List<Integer>> comb(int n, int k) {
		if (k == 1) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			for (int i = 1; i <= n; i++) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				res.add(list);
			}
			return res;
		} else {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			for (int i = n; i > 1; i--) {
				List<List<Integer>> res0 = comb(i - 1, k - 1);
				for (List<Integer> list : res0) {
					list.add(i);
					res.add(list);
				}
			}
			return res;
		}
	}
	
}
