package tree;
import other.TestMain.TreeNode;

public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        } else if (root.left == null && root.right == null) {
        	return 1;
        } else if (root.left != null && root.right == null) {
        	return minDepth(root.left) + 1;
        } else if (root.left == null && root.right != null) {
        	return minDepth(root.right) + 1;
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}