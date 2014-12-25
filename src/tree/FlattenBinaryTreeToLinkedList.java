package tree;

import other.TestMain.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode leftTree = root.left;
		root.left = null;
		flatten(leftTree);
		TreeNode rightTree = root.right;
		flatten(rightTree);
		if (leftTree != null) {
			root.right = leftTree;
			TreeNode node = root;
			while (node.right != null) {
				node = node.right;
			}
			node.right = rightTree;
		}
	}

}
