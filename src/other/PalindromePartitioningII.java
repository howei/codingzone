package other;

public class PalindromePartitioningII {
    public static int minCut(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
        	return 0;
        }
        
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
        	dp[i][i] = true;
        }
        
        for (int i = len - 1; i >= 0; i--) {
        	for (int j = i; j < len; j++) {
        		if (i == j) {
        			dp[i][j] = true;
        		} else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
        			dp[i][j] = true;
        		} else if (j - i > 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
        			dp[i][j] = true;
        		} else {
        			dp[i][j] = false;
        		}
        	}
        }
        
        int func[] = new int[len];
        func[0] = 0;
        for (int j = 1; j < len; j++) {
        	func[j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < len; i++) {
        	for (int j = 0; j < i; j++) {
        		if (dp[j+1][i] && func[j] + 1 < func[i]) {
        			func[i] = func[j] + 1;
        		}
        	}
        	if (dp[0][i]) {
        		func[i] = 0;
        	}
        }
        return func[len - 1];
    }
    
}
