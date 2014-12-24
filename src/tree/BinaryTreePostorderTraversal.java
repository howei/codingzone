package tree;

import java.util.ArrayList;
import java.util.List;

import other.TestMain.TreeNode;

public class BinaryTreePostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
        traversal(res, root);
        return res;
    }
    
    public static void traversal(List<Integer> res, TreeNode root) {
    	if (root == null) {
    		return;
    	}
        traversal(res, root.left);
        traversal(res, root.right);
        res.add(root.val);
    }
}
