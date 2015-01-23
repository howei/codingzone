package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	/**
	 * Need optimization. Time exceed limit in OJ
	 * @param S
	 * @param L
	 * @return
	 */
	public static List<Integer> findSubstring(String S, String[] L) {

		List<Integer> res = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return res;
		}
		int listLength = L.length;
		int wordLength = L[0].length();
		Map<String, Integer> needToFind = new HashMap<String, Integer>();
		Map<String, Integer> found = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			needToFind.put(L[i], needToFind.containsKey(L[i]) ? needToFind.get(L[i]) + 1 : 1);
		}
		int count = 0;
		for (int i = 0; i < wordLength; i++) {
			int p1 = i;
			int p2 = i;
			while (p2 <= S.length() - wordLength) {
				String word = S.substring(p2, p2 + wordLength);
				while (p2 <= S.length() - wordLength
						&& needToFind.containsKey(word)
						&& (!found.containsKey(word) || found.get(word) < needToFind
								.get(word))) {
					found.put(word,
							found.containsKey(word) ? found.get(word) + 1 : 1);
					count++;
					if (count == listLength) {
						res.add(p1);
						found.put(S.substring(p1, p1 + wordLength), found.get(S.substring(p1, p1 + wordLength)) - 1);
						p1 += wordLength;
						count--;
					}
					p2 += wordLength;
					if (p2 + wordLength <= S.length()) {
						word = S.substring(p2, p2 + wordLength);
					}
				}
				found.clear();
				count = 0;
				p1 += wordLength;
				p2 = p1;
			}
		}
		return res;
	}
}
