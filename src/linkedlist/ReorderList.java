package linkedlist;

public class ReorderList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);

		ListNode node = head;
		for (int i = 1; i < 9; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();

		reorderList(head);
		node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		ListNode fast = preHead;
		ListNode slow = preHead;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		slow = head;
		fast = reverse(fast);
		
		ListNode p0 = preHead;
		ListNode p1 = slow;
		ListNode p2 = fast;
		while (p2 != null) {
			p0.next = p1;
			ListNode tmp1 = p1.next;
			p1.next = p2;
			p0 = p2;
			p1 = tmp1;
			p2 = p2.next;
		}
		p0.next = p1;
	}

	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;
		head.next = null;
		while (p2 != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
		return p1;
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
