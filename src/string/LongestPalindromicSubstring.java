package string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "a";
		System.out.println(longestPalindrome(s));

	}
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
        	return s;
        }
        
    	int maxLen = 0;
    	int low = 0;
    	int high = 0;
    	int maxLow = 0;
    	int maxHigh = 0;
    	for (int i = 0; i < s.length(); i++) {
    		int len = 1;
    		int j = i;
			low = j - 1;
			high = j + 1;
    		while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
    			low -= 1;
    			high += 1;
    			len += 2;
    		}
    		if (len > maxLen) {
    			maxLen = len;
    			maxHigh = high - 1;
    			maxLow = low + 1;
    		}
    		
    		len = 0;
    		j = i;
			low = j - 1;
			high = j;
    		while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
    			low -= 1;
    			high += 1;
    			len += 2;
    		}
    		if (len > maxLen) {
    			maxLen = len;
    			maxHigh = high - 1;
    			maxLow = low + 1;
    		}
    	}
    	return s.substring(maxLow, maxHigh + 1);
    	
    }
}
