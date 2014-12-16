package tree;

import other.TestMain.TreeNode;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
        	return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth >= 0 && rightDepth >= 0 && leftDepth - rightDepth >= -1 && leftDepth - rightDepth <= 1) {
        	return true;
        } else {
        	return false;
        }
    }
    
    public static int depth(TreeNode root) {
        if (root == null) {
        	return 0;
        } else {
            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            if (leftDepth - rightDepth >= -1 && leftDepth - rightDepth <= 1) {
            	return Math.max(leftDepth, rightDepth) + 1;
            } else {
            	return -10;
            }
        	
        }
    }
}
