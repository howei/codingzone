package string;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '4', '9' } };
		System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		Set<Character> checkSet = new HashSet<Character>();

		// check each row
		for (int i = 0; i < 9; i++) {
			checkSet.clear();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!checkSet.contains(board[i][j])) {
						checkSet.add(board[i][j]);
					} else {
						return false;
					}
				}
			}
		}

		// check each column
		for (int i = 0; i < 9; i++) {
			checkSet.clear();
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					if (!checkSet.contains(board[j][i])) {
						checkSet.add(board[j][i]);
					} else {
						return false;
					}
				}
			}
		}

		// check each 3*3 square
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				checkSet.clear();
				for (int i2 = i * 3; i2 < (i + 1) * 3; i2++) {
					for (int j2 = j * 3; j2 < (j + 1) * 3; j2++) {
						if (board[i2][j2] != '.') {
							if (!checkSet.contains(board[i2][j2])) {
								checkSet.add(board[i2][j2]);
							} else {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}
