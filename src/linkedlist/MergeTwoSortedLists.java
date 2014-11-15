package linkedlist;

public class MergeTwoSortedLists {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(0);
		ListNode node = l1;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(2*i - 1);
			node = node.next;
		}
		
		ListNode l2 = new ListNode(0);
		node = l2;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(2*i);
			node = node.next;
		}
		
		System.out.print("list1: ");
		node = l1;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		System.out.print("list2: ");
		node = l2;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		
		node = mergeTwoLists(l1, l2);
		System.out.print("final list: ");
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	

	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
        	return l2;
        } else if (l2 == null) {
        	return l1;
        }
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        
        ListNode p0 = head;
        
        while (p1 != null && p2 != null) {
        	if (p1.val < p2.val) {
        		p0.next = p1;
        		p0 = p1;
        		p1 = p1.next;
        	} else {
        		p0.next = p2;
        		p0 = p2;
        		p2 = p2.next;
        	}
        }
        
        if(p1 != null) {
        	p0.next = p1;
        } else if (p2 != null) {
        	p0.next = p2;
        }        
        return head.next;
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
