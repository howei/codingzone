package linkedlist;

public class LinkedListCycle {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		
		ListNode node = head;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		System.out.println(hasCycle(head));

	}
	
    public static boolean hasCycle(ListNode head) {
    	if (head == null || head.next == null) {
    		return false;
    	}
    	ListNode p1 = head;
    	ListNode p2 = head.next;
    	
        while (p1 != null && p2 != null) {
        	if (p1 == p2) {
        		return true;
        	}
        	if(p1.next != null) {
        		p1 = p1.next;
        	} else {
        		return false;
        	}
        	if(p2.next != null && p2.next.next != null) {
        		p2 = p2.next.next;
        	} else {
        		return false;
        	}
        }
        return false;
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
