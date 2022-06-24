package linkedlist.com.sony;

import java.util.List;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode() {

	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		ListNode mid = findMiddleOfLinkedList(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);

		return mergeLinkedLists(left, right);
	}

	public static ListNode mergeLinkedLists(ListNode firstList, ListNode secondList) {
		ListNode dummyHead = new ListNode();
		ListNode tail = dummyHead;

		while(firstList != null && secondList != null) {
			if (firstList.val < secondList.val) {
				tail.next= firstList;
				firstList = firstList.next;
				tail = tail.next;
			} else {
				tail.next= secondList;
				secondList = secondList.next;
				tail = tail.next;
			}
		}
		tail.next = (firstList!=null) ? firstList:secondList;

		return dummyHead.next;
	}

	public static ListNode findMiddleOfLinkedList(ListNode head) {
		ListNode midPrev = null;

		while (head != null && head.next != null) {
			midPrev = (midPrev == null) ? head : midPrev.next;
			head = head.next.next;
		}
		ListNode mid = midPrev.next;
		midPrev.next = null;
		return mid;
	}

	public ListNode interativeReverseLinkedList(ListNode head) {
		if (head == null)
			return head;

		ListNode prev = null;
		ListNode present = head;
		ListNode next = present.next;

		while (present != null) {
			present.next = null;
			prev = present;
			present = next;
			if (next != null) {
				next = next.next;
			}
		}
		return prev;
	}

	public ListNode reverseAdjacentNodes(ListNode head, int left, int right) {
		/*
		1->2->3->4->5
		reverseAdjacentNodes(ListNode head, 2, 4)
		Ans:
		1->4->3->2->5
		*/

		if (left == right)
			return head;

		//Skip the left - 1 nodes
		ListNode current = head;
		ListNode prev = null;
		for (int i = 0; current != null && i< left -1; i++) {
			prev = current;
			current = current.next;
		}
		ListNode last = prev;
		ListNode newEnd = current;

		//reverse left and right
		ListNode next = current.next;
		for (int i = 0; current != null && i < right - left + 1; i++) {
			current.next = prev;
			prev =  current;
			current = next;
			if (next != null) {
				next = next.next;
			}
		}
		if (last != null) {
			last.next = prev;
		} else {
			head = prev;
		}
		newEnd.next = current;
		return head;
	}

	public boolean isLLPalindrome(ListNode head) {
		/*
		Go to mid of Linked List and reverse LL from mid to end, now use two pointers
		one at start of linked list and
		second at mid of linked list.

		Now traverse one location and find the values, if both pointer values are same, then its palindrome
		otherwise its not
		*/
		ListNode mid = findMiddleOfLinkedList(head);
		ListNode headSecond = interativeReverseLinkedList(mid);
		ListNode re_reverseHead = headSecond;

		//compare both the halves
		while (head != null && headSecond != null) {
			if (head.val != headSecond.val)
				break;
			head = head.next;
			headSecond = headSecond.next;
		}

		interativeReverseLinkedList(re_reverseHead);

		return head == null || headSecond == null;

	}

	public void reorderList(ListNode head) {
		if (head == null || head.next ==null) {
			return;
		}
		ListNode mid = findMiddleOfLinkedList(head);
		ListNode head_second = interativeReverseLinkedList(mid);
		ListNode head_first = head;

		//rearrange
		while (head_first != null && head_second !=null) {
			ListNode temp = head_first.next;
			head_first.next = head_second;
			head_first = temp;

			temp = head_second.next;
			head_second.next = head_first;
			head_second = temp;

			if (head_first != null) {
				head_first.next = null;
			}

		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		/*
		Reverse nodes in values of k
		1->2->3->4->5->6->7->8->9->10 , k = 3
		o/p:
		3->2->1->6->5->4->9->8->7->10
		* */
		if (k <= 1 || head == null)
			return head;
		ListNode current = head;
		ListNode prev = null;

		while (true) {
			ListNode last = prev;
			ListNode newEnd = current;

			ListNode next = current.next;
			for (int i = 0; current != null && i < k; i++) {
				current.next = prev;
				prev = current;
				current = next;
				if (next != null)
					next = next.next;
			}
			if (last != null) {
				last.next = prev;
			} else {
				head = prev;
			}
			newEnd.next = current;
			if (current == null) {
				break;
			}
			prev = newEnd;
		}
			return head;
	}

	public ListNode reverseAlternateKGroup(ListNode head, int k) {
		/*
		Reverse nodes in values of k
		1->2->3->4->5->6->7->8->9->10 , k = 3
		o/p:
		3->2->1->4->5->6->9->8->7->10
		* */
		if (k <= 1 || head == null)
			return head;
		ListNode current = head;
		ListNode prev = null;

		while (current != null) {
			ListNode last = prev;
			ListNode newEnd = current;

			ListNode next = current.next;
			for (int i = 0; current != null && i < k; i++) {
				current.next = prev;
				prev = current;
				current = next;
				if (next != null)
					next = next.next;
			}
			if (last != null) {
				last.next = prev;
			} else {
				head = prev;
			}
			newEnd.next = current;
			for (int i = 0; current != null && i < k; i++) {
				prev = current;
				current = current.next;
			}
		}
		return head;
	}

	public ListNode rotateRight(ListNode head, int k) {
		/*
		Reverse nodes in values of k
				1->2->3->4->5 , k = 3
		R1: 5->1->2->3->4
		R2: 4->5->1->2->3
		R3: 3->4->5->1->2
		o/p: final output is R3
		total length = 5, k = 3 5-3=2
		traverse 2 nodes and move the nodes after length
		2 to start.
		* */
		if (k <= 0|| head == null || head.next == null) {
			return head;
		}
		ListNode last = head;
		int length = 1;
		while (last.next != null) {
			last = last.next;
			length += 1;
		}
		last.next = head;
		int rotations =  k % length;
		int skip = length - rotations;
		ListNode newLast = head;
		for (int i = 0; i< skip - 1; i++) {
			newLast = newLast.next;
		}
		head = newLast.next;
		newLast.next = null;

		return head;
	}
}
