package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
    	if (s == null) {
    		return null;
    	}
    	List<String> res = new ArrayList<String>();
    	if (s.length() < 11) {
    		return res;
    	}
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int key = 0;
    	String subStr = s.substring(0, 10);
    	for (int i = 0; i < subStr.length(); i++) {
    		key = (key<<3) + (subStr.charAt(i)&7);
    	}
    	map.put(key, 1);
        for (int i = 1; i <= s.length() - 10; i++) {
        	int tmp = 1<<27;
        	tmp -= 1;
        	key = key&tmp;
        	key = key<<3;
        	key = s.charAt(i + 9) & 7 | key;
        	map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        	if (map.get(key) == 2) {
        		res.add(s.substring(i, i + 10));
        	}
        }
        return res;
    }
}
