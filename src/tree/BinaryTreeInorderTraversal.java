package tree;

import java.util.ArrayList;
import java.util.List;

import other.TestMain.TreeNode;

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traversal(list, root);
        return list;
    }
    
    public static void traversal(List<Integer> list, TreeNode node) {
    	if (node != null) {
    		traversal(list, node.left);
    		list.add(node.val);
    		traversal(list, node.right);
    	}
    }
}
