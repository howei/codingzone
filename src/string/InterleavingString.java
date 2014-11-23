package string;

public class InterleavingString {

	public static void main(String[] args) {
		String s1 = "aabcceb";
		String s2 = "dbbcaeb";
		String s3 = "aadbbcbcaceebb";
		System.out.println(isInterleave(s1, s2, s3));

	}
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null) {
        	return false;
        }
        if (s1 == null) {
        	return s2.equals(s3) ? true : false;
        }
        if (s2 == null) {
        	return s1.equals(s3) ? true : false;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
        	return false;
        }
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i < len1; i++) {
        	dp[i + 1][0] = dp[i][0] && (s1.charAt(i) == s3.charAt(i));
        }
        for (int i = 0; i < len2; i++) {
        	dp[0][i + 1] = dp[0][i] && (s2.charAt(i) == s3.charAt(i));
        }
        
        for (int i = 1; i <= len1; i++) {
        	for (int j = 1; j <= len2; j++) {
        		dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
        				|| (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
        	}
        }
        return dp[len1][len2];
    }
}
