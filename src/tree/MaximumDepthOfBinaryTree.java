package tree;
import other.TestMain.TreeNode;

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
