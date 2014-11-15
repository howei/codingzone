package linkedlist;


/**
 *  Sort a linked list in O(n log n) time using constant space complexity.


 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 
 
 Goals: 
1.Familiar with build listnode class
2.Sorting

Solution:

Merge Sort for Linked Lists

Merge sort is often preferred for sorting a linked list. The slow random-access performance of a linked list makes some other algorithms (such as quicksort) perform poorly, and others (such as heapsort) completely impossible.

Let head be the first node of the linked list to be sorted and headRef be the pointer to head. Note that we need a reference to head in MergeSort() as the below implementation changes next links to sort the linked lists (not data at the nodes), so head node has to be changed if the data at original head is not the smallest value in linked list.

MergeSort(headRef)
1) If head is NULL or there is only one element in the Linked List 
    then return.
2) Else divide the linked list into two halves.  
      FrontBackSplit(head, &a, &b);   ( a and b are two halves )
3) Sort the two halves a and b.
      MergeSort(a);
      MergeSort(b);
4) Merge the sorted a and b (using SortedMerge() ---Leetcode No.88 Merge two sorted lists) 
   and update the head pointer using headRef.
     *headRef = SortedMerge(a, b);



---From Leetcode
Edited by Allie Yanhong Zhao on April 30, 2014

 * @author yanhong
 *
 */

public class SortList {
	
	 public static class ListNode {
		  int val;
		  ListNode next;
		  ListNode(int x) {
		      val = x;
		      next = null;
		  }
     }
	 
	 public static ListNode head, tail;
	 
	 public static void add(ListNode newNode) {  //insert to the end of list
		
		 if (newNode == null)
             return;
         else {
               if (head == null) {  //head of node to be built
                   head = newNode;
                   tail = newNode;
             } else {
                   tail.next = newNode;
                   tail = newNode;
             }
       }				
	}
	 
	 private static ListNode merge(ListNode slow, ListNode fast) {
		 ListNode head = new ListNode(0);
		 ListNode cur = head;
		 while (slow != null && fast != null) {
		 if (slow.val < fast.val) {
		 cur.next = slow;
		 slow = slow.next;
		 } else {
		 cur.next = fast;
		 fast = fast.next;
		 }
		 cur = cur.next;
		 }
		 if (slow != null) {
		 cur.next = slow;
		 } else if (fast != null) {
		 cur.next = fast;
		 }
		 return head.next;
		 }
	 
    public static ListNode sortList(ListNode head) {
    	if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = sortList(head);
        fast = sortList(fast);
        return merge(slow, fast);    //return head
        
    }  
    
    /* 15 / 15 test cases passed.
	Status:
Accepted
Runtime: 460 ms*/
    
    
	
    public static void printList(ListNode n) {
		if (n == null) {
			System.out.println("Empty List!");
		}
	
		while(n!=null)
		{	
			System.out.print(n.val + " ");
			n=n.next;
		}
		System.out.println("\n");
	}

    public static void main(String[] args) {
 		
 		//Testing
    	
    	head = null;
    	
    	System.out.print("Input: a singly-linked list:\n");
    	int []listnumbers ={7,3,5,4,6};
    	for (int x: listnumbers ){	
    		ListNode Node = new ListNode(x); /*creat a new node*/
    		add(Node);   //add a new node with val in listnumbers
		    System.out.print(x + " ");
    	}	
    	  	
 		System.out.print("\nOutput: Sorted singly-linked list:\n");
 		head = sortList(head);
 		printList(head);		
 	}

}
