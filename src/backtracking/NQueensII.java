package backtracking;

public class NQueensII {
	public static void main(String[] args) {
		System.out.println(totalNQueens(8));

	}

	public static int totalNQueens(int n) {
		String[] item = new String[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j > 0) {
					item[i] += ".";
				} else {
					item[i] = ".";
				}
			}
		}
		return place(0, n, item);
	}

	public static int place(int k, int n, String[] item) {
		if (k == n) {
			return 1;
		}

		int num = 0;
		for (int i = 0; i < n; i++) {
			if (isValid(i, k, n, item)) {
				item[k] = item[k].substring(0, i) + "Q"
						+ item[k].substring(i + 1, n);
				num += place(k + 1, n, item);
				item[k] = item[k].substring(0, i) + "."
						+ item[k].substring(i + 1, n);
			} else if (!isValid(i, k, n, item) && i == n - 1) {
				return num;
			}
		}
		return num;
	}

	public static boolean isValid(int curr, int k, int n, String[] item) {
		// check column
		for (int i = 0; i < curr; i++) {
			if (item[k].charAt(i) == 'Q') {
				return false;
			}
		}

		// check row
		for (int i = 0; i < k; i++) {
			if (item[i].charAt(curr) == 'Q') {
				return false;
			}
		}

		// check upper left diagonal
		int i = k - 1;
		int j = curr - 1;
		while (i >= 0 && j >= 0) {
			if (item[i].charAt(j) == 'Q') {
				return false;
			} else {
				i--;
				j--;
			}
		}

		// check upper right diagonal
		i = k - 1;
		j = curr + 1;
		while (i >= 0 && j < n) {
			if (item[i].charAt(j) == 'Q') {
				return false;
			} else {
				i--;
				j++;
			}
		}
		return true;
	}

}