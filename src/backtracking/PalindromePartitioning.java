package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		System.out.println(partition(""));

	}

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (s == null || s.length() == 0) {
			return res;
		}
		if (s.length() == 1) {
			List<String> item = new ArrayList<String>();
			item.add(s);
			res.add(item);
			return res;
		}

		int size = s.length();
		for (int i = 0; i < size; i++) {
			String sub = s.substring(0, i + 1);
			if (isValid(sub)) {
				if (i + 1 < size) {
					List<List<String>> res0 = partition(s
							.substring(i + 1, size));
					for (List<String> list : res0) {
						List<String> item = new ArrayList<String>();
						item.add(sub);
						item.addAll(list);
						res.add(item);
					}
				} else {
					List<String> item = new ArrayList<String>();
					item.add(sub);
					res.add(item);
				}
			}
		}
		return res;
	}

	public static boolean isValid(String s) {
		int low = 0;
		int high = s.length() - 1;
		while (high - low > 0) {
			if (s.charAt(low) - s.charAt(high) != 0) {
				return false;
			}
			high--;
			low++;
		}
		return true;
	}
}
