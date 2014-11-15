package linkedlist;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		
		ListNode node = head;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
			node.next = new ListNode(i);
			node = node.next;
		}
		node.next = new ListNode(10);
		node = node.next;
		
		System.out.print("original list: ");
		node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		node = deleteDuplicates(head);
		System.out.print("final list: ");
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
    
	public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        if (node == null || node.next == null) {
        	return node;
        }
        while (node.next != null) {
        	if (node.val == node.next.val) {
        		node.next = node.next.next;
        	} else {
        		node = node.next;
        	}
        }
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