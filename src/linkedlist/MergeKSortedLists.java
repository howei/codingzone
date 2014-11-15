package linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class MergeKSortedLists {

	public static void main(String[] args) {
		List<ListNode> list = new ArrayList<ListNode>();
		
		ListNode head = new ListNode(0);
		ListNode node = head;
		for (int i = 1; i < 10; i++) {
			Random rand = new Random();
			int x = rand.nextInt(3);
			node.next = new ListNode(node.val + x);
			node = node.next;
		}
		node.next = new ListNode(10);
		node = node.next;
		list.add(head);
		
		ListNode head1 = new ListNode(0);
		node = head1;
		for (int i = 1; i < 10; i++) {
			Random rand = new Random();
			int x = rand.nextInt(3);
			node.next = new ListNode(node.val + x);
			node = node.next;
		}
		node.next = new ListNode(10);
		node = node.next;
		list.add(head1);
		
		ListNode head2 = new ListNode(0);
		node = head2;
		for (int i = 1; i < 10; i++) {
			Random rand = new Random();
			int x = rand.nextInt(3);
			node.next = new ListNode(node.val + x);
			node = node.next;
		}
		node.next = new ListNode(10);
		node = node.next;
		list.add(head2);
		list.add(null);
		
		System.out.print("original lists: ");
		node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		node = head1;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		node = head2;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		node = mergeKLists(list);
		System.out.print("final list: ");
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
    public static ListNode mergeKLists(List<ListNode> lists) {
        int k = lists.size();
        Comparator<ListNode> comparator = new ListNodeComparator();
        PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(k, comparator);
        
        ListNode[] heads = new ListNode[k];
        for (int i = 0; i < k; i++) {
        	heads[i] = lists.get(i);
        }
        
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        ListNode p0 = preHead;
        for (int i = 0; i < k; i++) {
        	if (heads[i] != null) {
        		pQueue.add(heads[i]);
        		if (heads[i].next != null) {
        		heads[i] = heads[i].next;
        		}
        	}
        }
        while (!pQueue.isEmpty()) {
        	ListNode min = pQueue.peek();
        	pQueue.remove();
        	p0.next = min;
        	p0 = p0.next;
        	
        	if (min.next != null) {
        		pQueue.add(min.next);
        	}
        }
        
        return preHead.next;
    }
    
    public static class ListNodeComparator implements Comparator<ListNode> {
    	@Override
    	public int compare(ListNode p1, ListNode p2) {
    		if (p1.val > p2.val) {
    			return 1;
    		} else if (p1.val < p2.val) {
    			return -1;
    		} else {
    			return 0;
    		}
    	}
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
