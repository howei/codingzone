package linkedlist;

public class LinkedListCycleII {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		
		ListNode node = head;
		ListNode tmp = null;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
			if (i == 6) {
				tmp = node;
			}
		}
		node.next = tmp;
		ListNode cycleStart = detectCycle(head);
		System.out.println(cycleStart.val);

	}
	
	public static ListNode detectCycle(ListNode head) {
		ListNode nodeInCircle = NodeInCircle(head);
		if (nodeInCircle == null) {
			return null;
		}
		
		int lFromHead = 0;
		int lCircle = 0;
		
		ListNode p1 = head;
		while (p1 != nodeInCircle) {
			lFromHead++;
			p1 = p1.next;
		}
		p1 = nodeInCircle.next;
		while (p1 != nodeInCircle) {
			lCircle++;
			p1 = p1.next;
		}
		
		ListNode p0 = head;
		ListNode p2 = nodeInCircle.next;
		if (lCircle > lFromHead) {
			int ct = lCircle - lFromHead;
			while (ct > 0) {
				p2 = p2.next;
				ct--;
			}
		}
		if (lCircle < lFromHead) {
			int ct = lFromHead - lCircle ;
			while (ct > 0) {
				p0 = p0.next;
				ct--;
			}
		}
		while(true) {
			if(p0 == p2) {
				return p0;
			}
			p0 = p0.next;
			p2 = p2.next;
		}

	}
	
    public static ListNode NodeInCircle(ListNode head) {
    	if (head == null || head.next == null) {
    		return null;
    	}
    	ListNode p1 = head;
    	ListNode p2 = head.next;
    	
        while (p1 != null && p2 != null) {
        	if (p1 == p2) {
        		System.out.println(p1.val);
        		return p1;
        	}
        	if(p1.next != null) {
        		p1 = p1.next;
        	} else {
        		return null;
        	}
        	if(p2.next != null && p2.next.next != null) {
        		p2 = p2.next.next;
        	} else {
        		return null;
        	}
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
