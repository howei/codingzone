package linkedlist;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(0);
		
		RandomListNode node = head;
		for (int i = 1; i < 10; i++) {
			node.next = new RandomListNode(i);
			node = node.next;
		}
		
		node.random = head;
		System.out.print("original:");
		node = head;
		while(node != null) {
			if (node.random != null) {
				System.out.print(node.label + "," + node.random.label+ " ");
			} else {
				System.out.print(node.label + "," + "null ");
			}
			node = node.next;
		}
		
		node = copyRandomList(head);
		RandomListNode node2 = head;
		System.out.println();
		System.out.print("original after copy:");
		while(node2 != null) {
			if (node2.random != null) {
				System.out.print(node2.label + "," + node2.random.label+ " ");
			} else {
				System.out.print(node2.label + "," + "null ");
			}
			node2 = node2.next;
		}
		
		System.out.println();
		System.out.print("copy:");
		while(node != null) {
			if (node.random != null) {
				System.out.print(node.label + "," + node.random.label+ " ");
			} else {
				System.out.print(node.label + "," + "null ");
			}
			node = node.next;
		}
		
	}
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
        	return null;
        }
        RandomListNode p1 = head;
        while (p1 != null) {
        	RandomListNode tmp = p1.next;
        	RandomListNode node = new RandomListNode(p1.label);
        	p1.next = node;
        	node.next = tmp;
        	p1 = tmp;
        }
        
        p1 = head;
        while (p1 != null && p1.next != null) {
        	if (p1.random != null) {
        		p1.next.random = p1.random.next;
        	}
        	p1 = p1.next.next;
        }
        
        RandomListNode preHead0 = new RandomListNode(-1);
        RandomListNode p0 = preHead0;
        RandomListNode preHead1 = new RandomListNode(-1);
        p1 = preHead1;
        RandomListNode p2 = head;
        while (p2 != null) {
        	p0.next = p2;
        	p1.next = p2.next;
        	p0 = p0.next;
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        p0.next = null;
        p1.next = null;
        head = preHead0.next;
        
        return preHead1.next;
    }
    
    public static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
     }
}
