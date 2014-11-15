package linkedlist;

import linkedlist.SwapNodesInPairs.ListNode;

public class ReverseNodesInKGroup {

	public static void main(String[] args) {

		ListNode head = new ListNode(0);

		ListNode node = head;
		for (int i = 1; i < 13; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}

		System.out.print("original list: ");
		node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();

		node = reverseKGroup(head, 5);
		System.out.print("final list: ");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}

	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k ==0 || k==1) {
			return head;
		}
		ListNode preHead = new ListNode(-1);
		preHead.next = head;

		ListNode p0 = preHead;
		ListNode p1 = p0.next;
		ListNode p2 = p0.next;
		ListNode p3 = p0.next;
		while (p3 != null) {
			int count = 1;
			while (count < k && p2.next != null) {
				count++;
				p2 = p2.next;
			}
			p3 = p2.next;
			if (count == k) {
				p2.next = null;
				reverse(p1, p2);
				p0.next = p2;
				p0 = p1;
				p1 = p3;
				p2 = p3;
			} else {
				p0.next = p1;
			}
		}
		
		return preHead.next;
	}
	public static void reverse(ListNode head, ListNode tail) {
		if (head == tail) {
			return;
		}
		
		ListNode p1 = head;
		ListNode p2 = p1.next;
		p1.next = null;
		while (p2 != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
	}
}
