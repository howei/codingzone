package string;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    public static boolean isScramble(String s1, String s2) {
        if (s1.length() == 1) {
        	if (s1.equals(s2)) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        
        if (s1.length() == 2) {
        	if (s1.equals(s2) || 
        			(s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0))) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        
        for (int i = 1; i < s1.length(); i++) {
        	Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        	Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        	Map<Character, Integer> map3 = new HashMap<Character, Integer>();
        	for (int ii = 0; ii < i; ii++) {
        		map1.put(s1.charAt(ii), map1.containsKey(s1.charAt(ii)) ? map1.get(s1.charAt(ii)) + 1 : 1);
        		map2.put(s2.charAt(s2.length() - ii - 1), map2.containsKey(s2.charAt(s2.length() - ii - 1)) ? map2.get(s2.charAt(s2.length() - ii - 1)) + 1 : 1);
        		map3.put(s2.charAt(ii), map3.containsKey(s2.charAt(ii)) ? map3.get(s2.charAt(ii)) + 1 : 1);
        	}
        	boolean map1EqualMap2 = map1.entrySet().equals(map2.entrySet());
        	boolean map1EqualMap3 = map1.entrySet().equals(map3.entrySet());
        	boolean scramble1 = false;
        	boolean scramble2 = false;
        	boolean scramble3 = false;
        	boolean scramble4 = false;
        	if (map1EqualMap2) {
            	scramble1 = isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length()));
            	scramble2 = isScramble(s1.substring(i, s1.length()), s2.substring(0, s2.length() - i));
        	}
        	if (map1EqualMap3) {
            	scramble3 = isScramble(s1.substring(0, i), s2.substring(0, i));
            	scramble4 = isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()));
        	}

        	if ((scramble1 && scramble2) || (scramble3 && scramble4)) {
        		return true;
        	}
        }
        return false;
    }
}
