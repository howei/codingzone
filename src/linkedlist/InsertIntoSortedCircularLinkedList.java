package linkedlist;

/**Given a sorted circular linkedList, the start of the list may not be the smallest value. 
*write a function inorderInsert(int inValue, Node n) to insert a value into this function.
@author howei
*/

public class InsertIntoSortedCircularLinkedList {

	public static class Node {
		public int value;
		public Node next;
	}

	public static Node inorderInsert(int inValue, Node n) {
		Node inNode = new Node();
		inNode.value = inValue;
		Node node = null;
		if (n == null) {
			n = inNode;
			n.next = inNode;
		} else if (n.next == n) {
			n.next = inNode;
			inNode.next = n;
		} else {
			for (node = n; node.next != n; node = node.next) {
				if (inValue >= node.value && inValue < node.next.value) {
					Node temp = node.next;
					node.next = inNode;
					inNode.next = temp;
					return n;
				} else if ((inValue >= node.value || inValue < node.next.value)
						&& node.value >= node.next.value) {
					Node temp = node.next;
					node.next = inNode;
					inNode.next = temp;
					return n;
				}
			}
			if (inValue >= node.value && inValue < node.next.value) {
				Node temp = node.next;
				node.next = inNode;
				inNode.next = temp;
				return n;
			} else if ((inValue <= node.value || inValue >= node.next.value)
					&& node.value >= node.next.value) {
				Node temp = node.next;
				node.next = inNode;
				inNode.next = temp;
				return n;
			}
		}
		return n;
	}

	public static Node insertToEnd(int inValue, Node n) {
		Node inNode = new Node();
		inNode.value = inValue;
		inNode.next = null;

		if (n == null) {
			n = inNode;
			n.next = inNode;
		} else {
			Node node = null;
			for (node = n; node.next != n; node = node.next) {
			}
			node.next = inNode;
			inNode.next = n;
		}
		return n;
	}

	public static void print(Node n) {
		if (n == null) {
			System.out.println("Empty List!");
		}
		Node node = null;
		for (node = n; node.next != n; node = node.next) {
			System.out.print(node.value + ", ");
		}
		System.out.println(node.value + " ");
	}

	public static void main(String[] args) {
		Node cList = null;
		cList = insertToEnd(200, cList);
		cList = insertToEnd(4, cList);
		cList = insertToEnd(6, cList);
		cList = insertToEnd(10, cList);
		cList = insertToEnd(100, cList);
		print(cList);
		
		cList = inorderInsert(10, cList);
		print(cList);

	}
}