package tree;

import other.TestMain.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {
    public static void connect(TreeLinkNode root) {
    	if (root == null || (root.left == null && root.right == null)) {
        	return;
        }
    	TreeLinkNode head = root;
    	con(head);
    }
    
    public static void con(TreeLinkNode head) {
    	if (head == null) {
    		return;
    	}
    	TreeLinkNode prev = null;
    	TreeLinkNode curr = null;
    	TreeLinkNode head2 = null;
    	boolean head2Set = false;
    	while(head != null) {
    		if (head.left != null) {
    			curr = head.left;
    			if (prev != null) {
    				prev.next = curr;
    				System.out.println("Set" + prev.val);
    				prev = curr;
    			} else {
    				prev = curr;
    			}
    			if (!head2Set) {
    				head2 = curr;
    				head2Set = true;
    			}
    		}
    		if (head.right != null) {
    			curr = head.right;
    			if (prev != null) {
    				prev.next = curr;
    				System.out.println("Set" + prev.val);
    				prev = curr;
    			} else {
    				prev = curr;
    			}
    			if (!head2Set) {
    				head2 = curr;
    				head2Set = true;
    			}
    		}
    		head = head.next;
    	}
        con(head2);
    }
}
