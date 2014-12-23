package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import other.TestMain.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return res;
		}
		stack.add(root);
		traversal(res, stack, 1);
		return res;
	}

	public static void traversal(List<List<Integer>> res,
			Stack<TreeNode> stack, int flag) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		if (stack.isEmpty()) {
			return;
		}
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			list.add(tmp.val);
			if (flag == 1) {
				if (tmp.left != null) {
					stack2.add(tmp.left);
				}
				if (tmp.right != null) {
					stack2.add(tmp.right);
				}
			} else {
				if (tmp.right != null) {
					stack2.add(tmp.right);
				}
				if (tmp.left != null) {
					stack2.add(tmp.left);
				}
			}
		}
		res.add(list);
		stack.addAll(stack2);
		traversal(res, stack, -flag);
	}
}
