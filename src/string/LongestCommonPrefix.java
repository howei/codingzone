package string;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"preorder", "", "preschool", "preface", "preload"};
		System.out.println(longestCommonPrefix(strs));
	}
    public static String longestCommonPrefix(String[] strs) {
    	if (strs == null) {
    		return null;
    	} else if (strs.length == 0) {
    		return "";
    	} else if (strs.length == 1) {
    		return strs[0];
    	}
        String comm = "";
        int strLen = strs[0].length();
        for (int i = 0; i < strLen; i++) {
        	char c = strs[0].charAt(i);
        	for (int j = 1; j < strs.length; j ++) {
        		if (strs[j].length() > i) {
        			if ((c - strs[j].charAt(i)) != 0) {
        				return comm;
        			}
        		} else {
        			return comm;
        		}
        	}
        	comm += String.valueOf(c);
        }
        return comm;
    }
}
