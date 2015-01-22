package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String S, String T) {
        if (S == null || T == null) {
        	return null;
        } else if (S.length() == 0 || T.length() == 0) {
        	return "";
        }
        Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
        	char ch = T.charAt(i);
        	needToFind.put(ch, needToFind.containsKey(ch)? needToFind.get(ch) + 1 : 1);
        }
        int p1 = 0;
        int p2 = 0;
        int p1Min = -1;
        int p2Min = -1;
        int min = Integer.MAX_VALUE;
        int count = 0;
        int lengthT = T.length();
        while (p2 < S.length()) {
        	char ch2 = S.charAt(p2);
        	if (needToFind.containsKey(ch2)) {
        		found.put(ch2, found.containsKey(ch2)? found.get(ch2) + 1 : 1);
        		if (found.get(ch2) <= needToFind.get(ch2)) {
        			count++;
        		}
        	}
    		p2++;
        	while (p1 < p2 && 
        			((count == lengthT && found.containsKey(S.charAt(p1)) && needToFind.containsKey(S.charAt(p1))
        			&& needToFind.get(S.charAt(p1)) < found.get(S.charAt(p1)))
        			|| (!needToFind.containsKey(S.charAt(p1))))
        			) {
        		if (needToFind.containsKey(S.charAt(p1))) {
        			found.put(S.charAt(p1), found.get(S.charAt(p1)) - 1);
        		}
        		p1++;
        	}
    		if (count == lengthT && p2 - p1 < min) {
    			min = p2 - p1;
    			p1Min = p1;
    			p2Min = p2;
    		}
        }
        
        if (p1Min != -1) {
        	return S.substring(p1Min, p2Min);
        } else {
        	return "";
        }
    }

}
