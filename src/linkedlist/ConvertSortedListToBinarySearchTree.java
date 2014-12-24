package linkedlist;

import other.TestMain.*;

public class ConvertSortedListToBinarySearchTree {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
        	return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        
        ListNode preLow = pre;
        ListNode low = head;
        ListNode high = head;
        while (high != null) {
        	high = high.next;
        	if (high != null) {
        		high = high.next;
        		low = low.next;
        		preLow = preLow.next;
        	}
        }
        TreeNode root = new TreeNode(low.val);
        if (preLow != pre) {
        	preLow.next = null;
        	root.left = sortedListToBST(head);
        }
        if (low.next != null) {
        	root.right = sortedListToBST(low.next);
        }
        return root;
    }
}
