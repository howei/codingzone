package backtracking;

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = '.';
			}
		}
		board[0][0] = '5';
		board[0][1] = '3';
		board[0][4] = '7';
		
		board[1][0] = '6';
		board[1][3] = '1';
		board[1][4] = '9';
		board[1][5] = '5';
		
		board[2][1] = '9';
		board[2][2] = '8';
		board[2][7] = '6';
		
		board[3][0] = '8';
		board[3][4] = '6';
		board[3][8] = '3';
		
		board[4][0] = '4';
		board[4][3] = '8';
		board[4][5] = '3';
		board[4][8] = '1';
		
		board[5][0] = '7';
		board[5][4] = '2';
		board[5][8] = '6';
		
		board[6][1] = '6';
		board[6][6] = '2';
		board[6][7] = '8';
		
		board[7][3] = '4';
		board[7][4] = '1';
		board[7][5] = '9';
		board[7][8] = '5';
		
		board[8][4] = '8';
		board[8][7] = '7';
		board[8][8] = '9';
		
		System.out.println("puzzle:");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		solveSudoku(board);
		System.out.println("solution:");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void solveSudoku(char[][] board) {
		char[][] res = new char[9][9];
        place(0, 0, board, res);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = res[i][j];
			}
		}
    }
    
    public static void place(int row, int col, char board[][], char res[][]) {
		if (board[row][col] - '0' > 0 && board[row][col] - '0' <= 9) {
			if (col < 8) {
				place(row, col + 1, board, res);
			} else if (row < 8) {
				place(row + 1, 0, board, res);
			} else {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						res[i][j] = board[i][j];
					}
				}
				return ;
			}
		} else {
			for (int i = 1; i <= 9; i++) {
				if (isValid(row, col, i, board)) {
					board[row][col] = (char) ('0' + i);
					if (col < 8) {
						place(row, col + 1, board, res);
					} else if (row < 8) {
						place(row + 1, 0, board, res);
					} else {
						for (int ii = 0; ii < 9; ii++) {
							for (int j = 0; j < 9; j++) {
								res[ii][j] = board[ii][j];
							}
						}
						return ;
					}
					board[row][col] = '.';
				} else if (!isValid(row, col, i, board) && i == 9) {
					return ;
				}
			}
		}
		return ;
	}
	
	public static boolean isValid(int row, int col, int curr, char board[][]) {
		//check row
		for (int i = 0; i < 9; i++) {
			if (board[row][i] - '0' == curr) {
				return false;
			}
		}
		
		//check col
		for (int i = 0; i < 9; i++) {
			if (board[i][col] - '0' == curr) {
				return false;
			}
		}
		
		//check the subsquare
		for (int i = row/3 * 3 ; i < row/3 * 3 + 3; i++) {
			for (int j = col/3 * 3; j < col/3 * 3 + 3; j++) {
				if (board[i][j] - '0' == curr) {
					return false;
				}
			}
		}
		return true;
	}
}
