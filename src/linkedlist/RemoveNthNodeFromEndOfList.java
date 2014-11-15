package linkedlist;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		
		ListNode node = head;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		
		node = removeNthFromEnd(head, 2);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}		
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p2 = head;
		for (int i = 0; i < n; i++) {
			p2 = p2.next;
		}
		if (p2 == null) {
			return head.next;
		}

		ListNode p1 = head;
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.next = p1.next.next;
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
