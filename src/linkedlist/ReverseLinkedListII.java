package linkedlist;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		
		ListNode node = head;
		for (int i = 1; i < 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		
		node = reverseBetween(head, 1, 10);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		
	}
	
    public static ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null || head.next == null) {
    		return head;
    	}
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        
        ListNode p1 = preHead;
        ListNode p2 = preHead.next.next;
        ListNode p2P = preHead.next;
        int i = 1;
        while (i < m) {
        	i++;
        	p1 = p1.next;
        	p2 = p2.next;
        	p2P = p2P.next;
        }
        
        while (i < n) {
        	i++;
        	ListNode tmp = p2.next;
        	p2.next = p2P;
        	p2P = p2;
        	p2 = tmp;
        }
        
        if (n >= 2) {
        	p1.next.next = p2;
        	p1.next = p2P;
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
