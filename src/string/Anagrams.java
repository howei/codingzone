package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		String[] strs = {""};
		System.out.println(anagrams(strs));

	}
    public static List<String> anagrams(String[] strs) {
    	List<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
        	return res;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
        	char[] cArray = str.toCharArray();
        	Arrays.sort(cArray);
        	String strKey = String.valueOf(cArray);
        	if (map.containsKey(strKey)) {
        		map.get(strKey).add(str);
        	} else {
        		List<String> tmp = new ArrayList<String>();
        		tmp.add(str);
        		map.put(strKey, tmp);
        	}
        }
        
        for (String str : map.keySet()) {
        	if (map.get(str).size() > 1) {
        		res.addAll(map.get(str));
        	}
        }
        return res;
    }
}
