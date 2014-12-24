package tree;

import other.TestMain.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
        	return null;
        }
        
        int len = num.length;
        TreeNode root = new TreeNode(num[len/2]);
        if (len/2 > 0) {
        	root.left = toBST(num, 0, len/2 - 1);
        } 
        if (len/2 < len - 1) {
        	root.right = toBST(num, len/2 + 1, len - 1);
        }
        
        return root;
    }

    public static TreeNode toBST(int[] num, int start, int end) {
    	if (start > end) {
    		return null;
    	}
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(num[mid]);
        
        if (start <= mid - 1) {
        	node.left = toBST(num, start, mid - 1);
        } 
        if (mid + 1 <= end) {
        	node.right = toBST(num, mid + 1, end);
        }
        return node;
    }
}
