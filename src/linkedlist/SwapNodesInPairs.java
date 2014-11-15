package linkedlist;

public class SwapNodesInPairs {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		
		ListNode node = head;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}

		System.out.print("original list: ");
		node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		node = swapPairs(head);
		System.out.print("final list: ");
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
    public static ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode p1 = fakeHead;
        ListNode p2 = head;
        
        while (p2!= null && p2.next != null) {
        	ListNode nextPairStart = p2.next.next;
        	p2.next.next = p2;
        	p1.next = p2.next;
        	p2.next = nextPairStart;
        	p1 = p2;
        	p2 = nextPairStart;
        }
        return fakeHead.next;
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
