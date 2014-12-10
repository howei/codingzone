package tree;
import other.TestMain.TreeNode;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
        	return true;
        } else if (p == null || q == null) {
        	return false;
        }
        
        if (p.val == q.val) {
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
        	return false;
        }
    }
}
