package string;

public class ValidPalindrome {

	public static void main(String[] args) {
		String s = "I am 787r9 r787mai.";
		System.out.println(isPalindrome(s));

	}
    public static boolean isPalindrome(String s) {
        if (s == null) {
        	return false;
        } else if (s.length() == 0 || s.length() == 1) {
        	return true;
        }
        int low = 0;
        int high = s.length() - 1;
        while (high >= low) {
        	if (!(s.charAt(high) - 'a' >= 0 && s.charAt(high) - 'a' < 26)
        			&& !(s.charAt(high) - 'A' >= 0 && s.charAt(high) - 'A' < 26)
        			&& !(s.charAt(high) - '0' >= 0 && s.charAt(high) - '0' < 10)) {
        		high--;
        		continue;
        	}
        	if (!(s.charAt(low) - 'a' >= 0 && s.charAt(low) - 'a' < 26)
        			&& !(s.charAt(low) - 'A' >= 0 && s.charAt(low) - 'A' < 26)
        			&& !(s.charAt(low) - '0' >= 0 && s.charAt(low) - '0' < 10)) {
        		low++;
        		continue;
        	}
        	if (s.charAt(high) != s.charAt(low) && s.charAt(high) - 'A' != s.charAt(low) - 'a' 
        			&& s.charAt(high) - 'a' != s.charAt(low) - 'A') {
        		return false;
        	} else {
        		low++;
        		high--;
        	}
        }
        return true;
    }
}
