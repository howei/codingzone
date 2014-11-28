package linkedlist;

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		ListNode head = new ListNode(100);
		
		ListNode node = head;
		for (int i = 1; i < 4; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		
		ListNode headA = new ListNode(10);
		node = headA;
		for (int i = 4; i < 7; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		node.next = head;
		
		ListNode headB = new ListNode(-2);
		node = headB;
		for (int i = 7; i < 14; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		node.next = head;
		
		
		node = headA;
		while (node != null) {
			System.out.println(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		node = headB;
		while (node != null) {
			System.out.println(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		
		System.out.println(getIntersectionNode(headA, headB).val);
	}
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
        	return null;
        }
        ListNode p = headA;
        int lenA = 0;
        while (p != null) {
        	lenA++;
        	p = p.next;
        }
        p = headB;
        int lenB = 0;
        while (p != null) {
        	lenB++;
        	p = p.next;
        }
        
        ListNode pA = headA;
        ListNode pB = headB;
        if (lenA >= lenB) {
        	int diff = lenA - lenB;
        	while (diff > 0) {
        		pA = pA.next;
        		diff--;
        	}
        } else {
        	int diff = lenB - lenA;
        	while (diff > 0) {
        		pB = pB.next;
        		diff--;
        	}
        }
        
        while (pA != null) {
        	if (pA == pB) {
        		return pA;
        	}
        	pA = pA.next;
        	pB = pB.next;
        }
        return null;
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
