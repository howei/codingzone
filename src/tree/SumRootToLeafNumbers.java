package tree;

import java.util.ArrayList;
import java.util.List;

import other.TestMain.TreeNode;

public class SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
    	int[] res = {0};
        if (root == null) {
        	return res[0];
        }
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(root.val);
        ps(res, curr, root);
        return res[0];
    }
    
    public static void ps(int[] res, List<Integer> curr, TreeNode currNode) {
    	if (currNode.left == null && currNode.right == null) {
    		int currNum = getNum(curr);
    		res[0] = res[0] + currNum;
    		return;
    	} 
    	if (currNode.left != null) {
    		List<Integer>curr1 = new ArrayList<Integer>();
    		curr1.addAll(curr);
    		curr1.add(currNode.left.val);
    		ps(res, curr1, currNode.left);
    	} 
    	if (currNode.right != null) {
    		List<Integer>curr2 = new ArrayList<Integer>();
    		curr2.addAll(curr);
    		curr2.add(currNode.right.val);
    		ps(res, curr2, currNode.right);
    	}
    }
    
    public static int getNum(List<Integer> curr) {
    	int num = 0;
    	for (int i : curr) {
    		num = num * 10 + i;
    	}
    	return num;
    }
}
