package string;

public class DistinctSubsequences {

	public static void main(String[] args) {
		String S = "rabbabit";
		String T = "rabbit";
		System.out.println(numDistinct(S, T));
	}
	
    public static int numDistinct(String S, String T) {
    	if (S == null || T == null || S.length() == 0 || T.length() == 0 || T.length() > S.length()) {
    		return 0;
    	}
        
    	int sLen = S.length();
    	int tLen = T.length();
    	int[][] dp = new int[tLen][sLen];
		if (T.charAt(0) == S.charAt(0)) {
			dp[0][0] = 1;
		}
		if (sLen == 1 && tLen == 1) {
			return dp[0][0];
		}
		
    	for (int i = 1; i < sLen; i++) {
    		if (T.charAt(0) == S.charAt(i)) {
    			dp[0][i] = dp[0][i - 1] + 1;
    		} else {
    			dp[0][i] = dp[0][i - 1];
    		}
    	}
		if (tLen == 1) {
			return dp[0][sLen - 1];
		}
		
    	for (int i = 1; i < tLen; i++) {
    		if (T.charAt(i) == S.charAt(i)) {
    			dp[i][i] = dp[i - 1][i - 1];
    		}
    	}
		if (tLen == 2 && sLen ==2) {
			return dp[1][1];
		}
		
    	for (int i = 1; i < tLen; i++) {
    		for (int j = 2; j < sLen; j++) {
    			if (T.charAt(i) == S.charAt(j)) {
    				dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
    			} else {
    				dp[i][j] = dp[i][j - 1];
    			}
    		}
    	}
    	return dp[tLen - 1][sLen - 1];
    }
}
