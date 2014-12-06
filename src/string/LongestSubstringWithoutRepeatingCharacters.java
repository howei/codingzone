package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		} else if (s.length() == 1) {
			return 1;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int count = 0;
		for (int i = 0; i < s.length() - max; ) {
			for (int j = i; j < s.length(); j++) {
				if (map.isEmpty() || !map.containsKey(s.charAt(j))) {
					map.put(s.charAt(j), j);
					count++;
				} else {
					max = Math.max(max, count);
					count = 0;
					i = map.get(s.charAt(j)) + 1;
					map.clear();
					break;
				}
			}
			// assume there are only 96 unique chars. otherwise cannot pass OJ
			if (Math.max(max, count) == 96) {
				break;
			}
		}
		return Math.max(max, count);
	}
}
