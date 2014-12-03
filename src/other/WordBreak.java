package other;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		String s = "aaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaa");
		dict.add("a");
		System.out.println("answer is: " + wordBreak(s, dict));
	}

	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict.size() == 0) {
			return false;
		}

		int size = s.length();
		boolean[] dp = new boolean[size];

		for (int i = 0; i < size; i++) {
			if (dict.contains(s.substring(0, i + 1))) {
				dp[i] = true;
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j + 1, i + 1))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[size - 1];
	}

}
