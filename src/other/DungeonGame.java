package other;

public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
		int rows = dungeon.length;
		int cols = dungeon[0].length;
		int dp[][] = new int[rows][cols];

		dp[rows - 1][cols - 1] = 1;
		for (int i = cols - 2; i >= 0; i--) {
			dp[rows - 1][i] = dp[rows - 1][i + 1] - dungeon[rows - 1][i + 1] > 0 ? dp[rows - 1][i + 1]
					- dungeon[rows - 1][i + 1]
					: 1;
		}
		
		for (int i = rows - 2; i >= 0; i--) {
			dp[i][cols - 1] = dp[i + 1][cols - 1] - dungeon[i + 1][cols - 1] > 0 ? dp[i + 1][cols - 1]
					- dungeon[i + 1][cols - 1]
					: 1;
		}
		
		if (rows > 1 && cols > 1) {
			for (int i = rows - 2; i >= 0; i--) {
				for (int j = cols - 2; j >= 0; j--) {
					dp[i][j] = Math.min(dp[i + 1][j] - dungeon[i + 1][j], dp[i][j + 1] - dungeon[i][j + 1]) > 0 ?
							   Math.min(dp[i + 1][j] - dungeon[i + 1][j], dp[i][j + 1] - dungeon[i][j + 1]) : 1;
				}
			}
		}
		
		return dp[0][0] - dungeon[0][0] > 0 ? dp[0][0] - dungeon[0][0] : 1;
	}

}
