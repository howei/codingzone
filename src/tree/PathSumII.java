package tree;

import other.TestMain.TreeNode;
import java.util.List;
import java.util.ArrayList;

public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
        	return res;
        }
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(root.val);
        ps(res, curr, root, sum - root.val);
        return res;
    }
    
    public static void ps(List<List<Integer>> res, List<Integer> curr, TreeNode currNode, int sum) {
    	if (0 == sum && currNode.left == null && currNode.right == null) {
    		res.add(curr);
    		return;
    	} 
    	if (currNode.left != null) {
    		List<Integer>curr1 = new ArrayList<Integer>();
    		curr1.addAll(curr);
    		curr1.add(currNode.left.val);
    		ps(res, curr1, currNode.left, sum - currNode.left.val);
    	} 
    	if (currNode.right != null) {
    		List<Integer>curr2 = new ArrayList<Integer>();
    		curr2.addAll(curr);
    		curr2.add(currNode.right.val);
    		ps(res, curr2, currNode.right, sum - currNode.right.val);
    	}
    }
}