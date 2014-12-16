package tree;

import other.TestMain.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {
    public static void connect(TreeLinkNode root) {
    	if (root == null) {
        	return;
        }
    	con(root);
    }
    
    public static void con(TreeLinkNode root) {
        if (root.left == null) {
        	return;
        }
        TreeLinkNode tmp = root.left;
        root.left.next = root.right;
        while (root.next != null) {
        	root.right.next = root.next.left;
        	root = root.next;
        	root.left.next = root.right;
        }
        con(tmp);
    }
}
