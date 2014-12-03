package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public static List<String> wordBreak(String s, Set<String> dict) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}

		int len = s.length();
		boolean[][] dp = new boolean[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				dp[i][j] = dict.contains(s.substring(i, j + 1));
			}
		}

//		if (!WordBreak.wordBreak(s, dict)) {
//			return new ArrayList<String>();
//		}
		wb(s, res, dp, 0);
		return res;
	}

	public static List<String> wb(String s, List<String> res, boolean[][] dp,
			int start) {
		List<String> curr = new ArrayList<String>();
		for (int i = start; i < dp.length; i++) {
			if (dp[start][i] == true) {
				if (i != dp.length - 1) {
					List<String> tmp = wb(s, res, dp, i + 1);
					for (int j = 0; j < tmp.size(); j++) {
						if (start == 0) {
							res.add(s.substring(start, i + 1) + " "
									+ tmp.get(j));
						} else {
							curr.add(s.substring(start, i + 1) + " "
									+ tmp.get(j));
						}
					}
				} else {
					String last = s.substring(start, i + 1);
					curr.add(last);
					if (start == 0) {
						res.addAll(curr);
					}
				}
			}
		}
		return curr;
	}

}
