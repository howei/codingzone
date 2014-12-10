package tree;

public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		if (n == 1) {
			return res[1];
		}
		res[2] = 2;
		if (n == 2) {
			return res[2];
		}
		for (int j = 2; j <= n - 1; j++) {
			for (int i = 0; i <= j; i++) {
				res[j + 1] += res[i] * res[j - i];
			}
		}
		return res[n];
	}
}
