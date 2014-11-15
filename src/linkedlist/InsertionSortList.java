package linkedlist;

import java.util.Random;

public class InsertionSortList {

	public static void main(String[] args) {

		ListNode head = new ListNode(10);
		
		ListNode node = head;
		for (int i = 1; i < 2; i++) {
			Random rand = new Random();
			int x = rand.nextInt(10);
			node.next = new ListNode(x);
			node = node.next;
		}
		node = head;
		System.out.println("original:");
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("sorted:");
		
		node = insertionSortList(head);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        preHead.next = head;
        
        ListNode p1 = head;
        while(p1.next != null) {
        	if (p1.next.val >= p1.val) {
        		p1 = p1.next;
        	} else {
        		ListNode tmp = p1.next;
        		p1.next = p1.next.next;
        		
        		ListNode p2 = preHead;
        		while (p2 != null) {
        			if (tmp.val >= p2.val && tmp.val < p2.next.val) {
        				ListNode tmp2 = p2.next;
        				p2.next = tmp;
        				tmp.next = tmp2;
        				p2 = null;
        			} else {
        				p2 = p2.next;
        			}
        		}
        	}
        }
        return preHead;
    }

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
