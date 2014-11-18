package math;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(10));

	}
    public static boolean isPalindrome(int x) {
    	if (x == 0) {
    		return true;
    	} else if (x < 0 || x % 10 == 0) {
    		return false;
    	}
    	
    	int rev = 0;
        while(x > 0) {
        	rev = rev * 10 + x % 10;
        	if (x == rev || x/10 == rev) {
        		return true;
        	}
        	x = x/10;
        }
        return false;
    }
}
