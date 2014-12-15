package tree;

import other.TestMain.TreeNode;

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE, false, false);
    }
    public static boolean isValid(TreeNode root, int leftMax, int rightMin, boolean leftSet, boolean rightSet) {
    	if (root == null) {
    		return true;
    	}
    	if ((root.val <= leftMax && leftSet == true) || (root.val >= rightMin && rightSet == true)) {
    		return false;
    	}
    	boolean left = true;
    	boolean right = true;
    	if (root.left != null) {
    		left = isValid(root.left, leftMax, root.val, leftSet, true);
    	}
    	if (root.right != null) {
    		right = isValid(root.right, root.val, rightMin, true, rightSet);
    	}
    	return (left && right);
    }
}
