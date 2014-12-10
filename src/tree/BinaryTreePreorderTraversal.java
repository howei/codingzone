package tree;

import java.util.ArrayList;
import java.util.List;

import other.TestMain.TreeNode;

public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traversal(list, root);
        return list;
    }
    
    public static void traversal(List<Integer> list, TreeNode node) {
    	if (node != null) {
    		list.add(node.val);
    		traversal(list, node.left);
    		traversal(list, node.right);
    	}
    }
}
