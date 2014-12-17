package tree;

import java.util.ArrayList;
import java.util.List;
import other.TestMain.TreeNode;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
        	return true;
        } else if (root.left == null || root.right == null || root.left.val != root.right.val) {
        	return false;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root.left);
        list.add(root.right);
        return valid(list);
    }
    
    public static boolean valid(List<TreeNode> list) {
    	List<TreeNode> list2 = new ArrayList<TreeNode>();
    	int size = list.size();
    	for (int i = 0; i < size/2; i++) {
    		if ((list.get(i).left == null && list.get(size - 1 - i).right != null)
    				|| (list.get(i).left != null && list.get(size - 1 - i).right == null)
    				|| (list.get(i).right == null && list.get(size - 1 - i).left != null)
    				|| (list.get(i).right != null && list.get(size - 1 - i).left == null)
    				|| (list.get(i).right != null && list.get(i).right.val != list.get(size - 1 - i).left.val)
    				|| (list.get(i).left != null &&list.get(i).left.val != list.get(size - 1 - i).right.val)) {
    			return false;
    		}
    		if (list.get(i).left != null) {
    			List<TreeNode> tmp = new ArrayList<TreeNode>();
    			tmp.add(list.get(i).left);
    			tmp.add(list.get(size - 1 - i).right);
    			if (list2.isEmpty()) {
    				list2.addAll(tmp);
    			} else {
    				list2.addAll(list2.size()/2, tmp);
    			}
    			
    		}
    		if (list.get(i).right != null) {
    			List<TreeNode> tmp = new ArrayList<TreeNode>();
    			tmp.add(list.get(i).right);
    			tmp.add(list.get(size - 1 - i).left);
    			if (list2.isEmpty()) {
    				list2.addAll(tmp);
    			} else {
    				list2.addAll(list2.size()/2, tmp);
    			}
    		}
    	}
    	if (list2.isEmpty()) {
    		return true;
    	} else {
    		return valid(list2);
    	}
    }
    
}
