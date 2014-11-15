package linkedlist;

public class RotateList {

	public static void main(String[] args) {

		ListNode head = new ListNode(0);

		ListNode node = head;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}

		node = rotateRight(head, 22);
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode rotateRight(ListNode head, int n) {
		if (n == 0 || head == null || head.next == null) {
			return head;
		}
		ListNode p2 = head;
		int len = 0;
		while (p2 != null) {
			len++;
			p2 = p2.next;
		}

		p2 = head;
		int i = n % len;
		if (i == 0) {
			return head;
		}
		while (i > 0) {
			p2 = p2.next;
			i--;
		}

		ListNode p1 = head;
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		ListNode tmp = p1.next;
		p2.next = head;
		p1.next = null;
		head = tmp;
		return head;
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
