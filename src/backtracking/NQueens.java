package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		int n = 5;
		List<String[]> res = solveNQueens(n);
		int sol = 1;
		for (String[] item : res) {
			System.out.println("solution " + sol++);
			for (int i = 0; i < n; i++) {
				System.out.println(item[i]);
			}
			System.out.println();
		}
	}

	public static List<String[]> solveNQueens(int n) {
		List<String[]> res = new ArrayList<String[]>();
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
		place(0, n, res, item);
		return res;
	}

	public static void place(int k, int n, List<String[]> res, String[] item) {
		if (k == n) {
			String[] itemAdd = new String[n];
			for (int i = 0; i < n; i++) {
				itemAdd[i] = item[i];
			}
			res.add(itemAdd);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isValid(i, k, n, item)) {
				item[k] = item[k].substring(0, i) + "Q"
						+ item[k].substring(i + 1, n);
				place(k + 1, n, res, item);
				item[k] = item[k].substring(0, i) + "."
						+ item[k].substring(i + 1, n);
			} else if (!isValid(i, k, n, item) && i == n - 1) {
				return;
			}
		}
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