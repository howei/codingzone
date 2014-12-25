package tree;

import java.util.ArrayList;
import java.util.List;

import other.TestMain.TreeNode;

public class UniqueBinarySearchTreesII {
	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (n <= 0) {
			res.add(null);
			return res;
		}

		int[] A = new int[n];
		for (int i = 1; i <= n; i++) {
			A[i - 1] = i;
		}
		return generate(A, 0, n - 1);
	}

	public static List<TreeNode> generate(int[] A, int start, int end) {

		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start == end) {
			TreeNode root = new TreeNode(A[start]);
			res.add(root);
		}
		if (end > start) {
			List<TreeNode> tmpL = generate(A, start, end - 1);
			for (TreeNode node : tmpL) {
				TreeNode root = new TreeNode(A[end]);
				root.left = node;
				res.add(root);
			}
			List<TreeNode> tmpR = generate(A, start + 1, end);
			for (TreeNode node : tmpR) {
				TreeNode root = new TreeNode(A[start]);
				root.right = node;
				res.add(root);
			}
		}
		if (end - start > 1) {
			for (int i = start + 1; i < end; i++) {
				List<TreeNode> tmpL = generate(A, start, i - 1);
				List<TreeNode> tmpR = generate(A, i + 1, end);
				for (TreeNode nodeL : tmpL) {
					for (TreeNode nodeR : tmpR) {
						TreeNode root = new TreeNode(A[i]);
						root.left = nodeL;
						root.right = nodeR;
						res.add(root);
					}
				}
			}
		}
		return res;
	}

}
