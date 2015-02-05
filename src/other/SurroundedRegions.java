package other;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public static void solve(char[][] board) {
		if (board == null || board.length <= 2 || board[0].length <= 2) {
			return;
		}
		printBoard(board);
		int rows = board.length;
		int cols = board[0].length;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < cols; i++) {
			if (board[0][i] == 'O') {
				queue.add(0);
				queue.add(i);
				bfs(queue, board, rows, cols);
			}
		}
		for (int i = 1; i < rows; i++) {
			if (board[i][0] == 'O') {
				queue.add(i);
				queue.add(0);
				bfs(queue, board, rows, cols);
			}
		}
		for (int i = 1; i < rows; i++) {
			if (board[i][cols - 1] == 'O') {
				queue.add(i);
				queue.add(cols - 1);
				bfs(queue, board, rows, cols);
			}
		}
		for (int i = 1; i < cols - 1; i++) {
			if (board[rows - 1][i] == 'O') {
				queue.add(rows - 1);
				queue.add(i);
				bfs(queue, board, rows, cols);
			}
		}

		printBoard(board);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
		printBoard(board);
	}

	public static void bfs(Queue<Integer> queue, char[][] board, int rows, int cols) {
		while (!queue.isEmpty()) {
			int row = queue.poll();
			int col = queue.poll();
			if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O') {
				continue;
			}
			board[row][col] = '#';
			queue.add(row - 1);
			queue.add(col);
			queue.add(row + 1);
			queue.add(col);
			queue.add(row);
			queue.add(col - 1);
			queue.add(row);
			queue.add(col + 1);
		}
	}
	
	public static void setPoundDFS(int row, int col, int rows, int cols,
			char[][] board) {
		board[row][col] = '#';
		if (row - 1 >= 0 && board[row - 1][col] == 'O') {
			setPoundDFS(row - 1, col, rows, cols, board);
		}
		if (row + 1 < rows && board[row + 1][col] == 'O') {
			setPoundDFS(row + 1, col, rows, cols, board);
		}
		if (col + 1 < cols && board[row][col + 1] == 'O') {
			setPoundDFS(row, col + 1, rows, cols, board);
		}
		if (col - 1 >= 0 && board[row][col - 1] == 'O') {
			setPoundDFS(row, col - 1, rows, cols, board);
		}
	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
