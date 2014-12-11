package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import other.TestMain.TreeNode;

public class BinaryTreeLevelOrderTraversalAndII {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
        	return res;
        }
        queue.add(root);
        traversal(res, queue);
        return res;
    }
    
    public static void traversal(List<List<Integer>> res, Queue<TreeNode> queue) {
    	List<Integer> list = new ArrayList<Integer>();
    	Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
    	if (queue.isEmpty()) {
    		return;
    	}
    	while (!queue.isEmpty()) {
    		TreeNode tmp = queue.remove();
    		list.add(tmp.val);
    		if (tmp.left != null) {
    			queue2.add(tmp.left);
    		}
    		if (tmp.right != null) {
    			queue2.add(tmp.right);
    		}
    	}
    	//the following two lines are the difference of I and II
//    	res.add(list);
    	res.add(0, list);
    	queue.addAll(queue2);
    	traversal(res, queue);
    }
}
