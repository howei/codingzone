package linkedlist;

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode node = head;
		node.next = new ListNode(0);
		node = node.next;
		node.next = new ListNode(0);
		node = node.next;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
			node.next = new ListNode(i);
			node = node.next;
			node.next = new ListNode(i);
			node = node.next;
		}
		// node.next = new ListNode(10);

		System.out.print("original list: ");
		node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();

		node = deleteDuplicates(head);
		System.out.print("final list: ");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode p1 = preHead;
		ListNode p2 = head;
		boolean flag = false;
		while (p2 != null && p2.next != null) {
			if (p1.next.val == p2.next.val) {
				while (p2.next != null && p1.next.val == p2.next.val) {
					p2 = p2.next;
				}
				flag = true;
			} else {
				p1 = p1.next;
				p2 = p2.next;
				flag = false;
			}

			if (flag) {
				p1.next = p2.next;
				p2 = p2.next;
			}
		}
		return preHead.next;
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