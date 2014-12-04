package backtracking;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { 
				{ 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' } };
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaa";

		System.out.println(exist(board, s));
	}

	public static boolean exist(char[][] board, String s) {
		if (board == null || board.length == 0 || board[0].length == 0
				|| s == null || s.length() == 0) {
			return false;
		}

		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (ws(i, j, board, visited, s, 0) == true) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean ws(int row, int col, char[][] board,
			boolean[][] visited, String s, int ind) {

		if (board[row][col] != s.charAt(ind) || visited[row][col] == true) {
			return false;
		}
		
		if (ind == s.length() - 1) {
			return true;
		}
		visited[row][col] = true;
		if (row - 1 >= 0 && ws(row - 1, col, board, visited, s, ind + 1)) {
			return true;
		}
		if (row + 1 < board.length
				&& ws(row + 1, col, board, visited, s, ind + 1)) {
			return true;
		}
		if (col - 1 >= 0 && ws(row, col - 1, board, visited, s, ind + 1)) {
			return true;
		}
		if (col + 1 < board[0].length
				&& ws(row, col + 1, board, visited, s, ind + 1)) {
			return true;
		}
		visited[row][col] = false;
		
		return false;
	}
}
