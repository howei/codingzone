package linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode node = l1;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		ListNode l2 = new ListNode(0);
		node = l2;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		node = l1;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		node = l2;
		System.out.println();
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		
		node = addTwoNumbers(l1, l2);
		System.out.println();
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}

	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null) {
    		return l2;
    	} else if (l2 == null) {
    		return l1;
    	}
    	
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode preHead = new ListNode(-1);
        ListNode pp = preHead;
        int carry = 0;
        while (p1 != null && p2 != null) {
        	ListNode sum = new ListNode((p1.val + p2.val + carry) % 10);
        	pp.next = sum;
        	pp = pp.next;
        	carry = (p1.val + p2.val + carry)/10;
        	p1 = p1.next;
        	p2 = p2.next;
        }
        while (p1 != null) {
        	ListNode sum = new ListNode((p1.val + carry) % 10);
        	pp.next = sum;
        	pp = pp.next;
        	carry = (p1.val + carry)/10;
        	p1 = p1.next;
        }
        while (p2 != null) {
        	ListNode sum = new ListNode((p2.val + carry) % 10);
        	pp.next = sum;
        	pp = pp.next;
        	carry = (p2.val + carry)/10;
        	p2 = p2.next;
        }
        if (carry > 0) {
        	ListNode sum = new ListNode(carry);
        	pp.next = sum;
        	pp = pp.next;
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
