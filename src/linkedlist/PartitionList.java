package linkedlist;

import java.util.Random;

public class PartitionList {

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		
		ListNode node = head;
		for (int i = 1; i < 10; i++) {
			Random rand = new Random();
			int x = rand.nextInt(10);
			node.next = new ListNode(x);
			node = node.next;
		}
		node = head;
		System.out.println("original:");
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("partitioned:");
		
		node = partition(head, 5);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}

	}
	
    public static ListNode partition(ListNode head, int x) {
    	if (head == null || head.next == null) {
    		return head;
    	}
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        preHead.next = head;
        
        ListNode p1 = preHead;
        ListNode p2 = preHead;
        while (p1.next != null && p1.next.val < x) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        
        while (p2.next != null) {
        	if (p2.next.val < x) {
        		ListNode tmp = p2.next;
        		p2.next = p2.next.next;
        		ListNode tmp2 = p1.next;
        		p1.next = tmp;
        		tmp.next = tmp2;
        		p1 = p1.next;
        	} else {
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
