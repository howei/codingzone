package string;

public class EditDistance {

	public static int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		}

		if (word1 == null) {
			return word2.length();
		} else if (word2 == null) {
			return word1.length();
		}
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= len2; i++) {
			dp[0][i] = i;
		}
		if (len1 > 0 && len2 > 0) {
			for (int i = 1; i <= len1; i++) {
				for (int j = 1; j <= len2; j++) {
					int twoCorners = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
					if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
						dp[i][j] = Math.min(twoCorners, dp[i - 1][j - 1]);
					} else {
						dp[i][j] = Math.min(twoCorners, dp[i - 1][j - 1] + 1);
					}
				}
			}
		}
		return dp[len1][len2];
	}
}
