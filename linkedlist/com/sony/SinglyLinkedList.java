package linkedlist.com.sony;

public class SinglyLinkedList {
	/*
	 * - LinkedList with head and tail
	 * - size is calculated in each function during insertion/deletion 
	 * - head should always point to first node and tail to last node
	 * - use temp nodes to traverse for insertion/deletetion/searching/sorting
	 * - Never move head/tail references.
	 * - Draw your code before implementation 
	 * - Visualize on pen and paper then implement
	 */
	public Node head;
	public Node tail;

	private int size = 0;

	public SinglyLinkedList() {
		this.size = 0;
	}

	public class Node {
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

		/*
	Leet code ListNode(LinkedList) class format
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val=x;
			next=null;
		}
	}

	* */

	public static SinglyLinkedList mergeLinkedLists(SinglyLinkedList firstLL, SinglyLinkedList secondLL) {
		Node firstList = firstLL.head;
		Node secondList = secondLL.head;
		SinglyLinkedList resultList = new SinglyLinkedList();

		while (firstList != null && secondList != null) {
			if (firstList.value < secondList.value) {
				resultList.insertLast(firstList.value);
				firstList = firstList.next;
			} else {
				resultList.insertLast(secondList.value);
				secondList = secondList.next;
			}
		}

//		resultList.insertLast((firstList!=null)?firstList.value:secondList.value);

		while (firstList != null) {
			resultList.insertLast(firstList.value);
			firstList = firstList.next;
		}

		while (secondList != null) {
			resultList.insertLast(secondList.value);
			secondList = secondList.next;
		}
		return resultList;
	}

	public void insertFirst(int value) {

		Node insertAtFirstNode = new Node(value);
		insertAtFirstNode.next = head;
		head = insertAtFirstNode;

		if (tail == null)
			tail = head;
		size += 1;

	}

	/*
	 * public int insertFirstAndReturnVal(int value) { Node insertAtFirstNode = new
	 * Node(value); insertAtFirstNode.next = head; head = insertAtFirstNode; int
	 * value = insertAtFirstNode.value;
	 *
	 * if (tail == null) { tail = head; } size += 1; return value;
	 *
	 * }
	 */

	public void insertLast(int value) {

		if (tail == null)
			insertFirst(value);
		else {
			Node insertAtLastNode = new Node(value);
			tail.next = insertAtLastNode;
			tail = insertAtLastNode;
		}
		size += 1;
	}

	public void insertAtIndex(int value, int index) {
		if (index == 0)
			insertFirst(value);
		else if (index == size)
			insertLast(value);
		else if (index > size)
			throw new IndexOutOfBoundsException();
		else {
			Node temp = findNodeAtIndex(index - 2);
			Node nodeToBeInserted = new Node(value, temp.next);
			temp.next = nodeToBeInserted;
			size += 1;
		}
	}

	public void insertUsingRecursion(int value, int index) {
		head = insertUsingRecursion(value, index, head);
	}

	private Node insertUsingRecursion(int value, int index, Node node) {
		if (index == 0) {
			Node temp = new Node(value, node);
			size += 1;
			return temp;
		}
		node.next = insertUsingRecursion(value, index -= 1, node.next);
		return node;

	}

	public void deleteFirst() {
		head = head.next;
		if (head.next == null)
			tail = null;
		size -= 1;
	}

	public int deleteFirstAndReturnValue() {
		int value = head.value;
		head = head.next;

		if (head.next == null)
			tail = null;
		size -= 1;
		return value;
	}

	public void deleteLast() {
		Node traverseUptoSecondLastNode = head;
		for (int i = 0; i < size - 2; i++) {
			traverseUptoSecondLastNode = traverseUptoSecondLastNode.next;
		}
		tail = traverseUptoSecondLastNode;
		tail.next = null;
		size -= 1;
	}

	public int deleteLastAndReturnValue() {
		int value = head.value;
		head = head.next;

		if (head.next == null)
			tail = null;
		size -= 1;
		return value;
	}

	public int deleteAtIndex(int index) {
		int value;
		if (index == 0) {
			return deleteFirstAndReturnValue();
		} else if (index == size - 1) {
			return deleteLastAndReturnValue();
		} else if (index > size)
			throw new IndexOutOfBoundsException();
		else {
			Node traverseToPrevNode = findNodeAtIndex(index - 2);
			value = traverseToPrevNode.next.value;
			traverseToPrevNode.next = traverseToPrevNode.next.next;
			size -= 1;
		}
		return value;
	}

	public Node findNodeAtIndex(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	public int findNodeOfValue(int value) {
		Node node = head;
		int index = 1;
		while (node != null) {
			if (node.value == value)
				return index;
			node = node.next;
			index += 1;
		}
		return index;
	}

	public void display() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.value);
			temp = temp.next;
			if (temp != null)
				System.out.print(" -> ");
		}
		System.out.println();
	}

	public void removeDuplicates() {
		Node node = head;

		while (node.next != null) {
			if (node.value == node.next.value) {
				node.next = node.next.next;
				size--;
			} else {
				node = node.next;
			}
		}
		tail = node;
		tail.next = null;
	}

	public boolean hasCycleInLinkedList() {
		Node fast = head;
		Node slow = head;
		int cnt = 0;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}
		return false;
	}

	public int linkedListCycleLength() {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				Node temp = slow;
				int cnt = 0;
				do {
					temp = temp.next;
					cnt += 1;
				} while (temp != slow);
				return cnt;
			}
		}
		return 0;
	}

	/*
	Find the start of cyclic loop in linked list
	Refer for better understanding:
	http://hrishikeshmishra.com/how-to-find-the-starting-point-of-a-loop-in-a-linked-list/
	* */
	public Node detectStartofCycle() {
		/*
		1. First find the length of the linked list cycle
		2. Move second pointer ahead by length of cycle times
		3. Move second and first pointer one by one, it will meet at start.
		*/
		int length = linkedListCycleLength();
		if (length == 0)
			return null;

		//find the start node
		Node firstPtr = head;
		Node scndPtr = head;

		while (length > 0) {
			scndPtr = scndPtr.next;
			length--;
		}

		//keep moving both forward and they will meet at cycle start

		while (firstPtr != scndPtr) {
			firstPtr = firstPtr.next;
			scndPtr = scndPtr.next;
		}
		return scndPtr;
	}

	public boolean isHappy(int n) {
		int slow = n;
		int fast = n;

		do {
			slow = findSquare(slow);
			fast = findSquare(findSquare(fast));
		} while (slow != fast);

		return slow == 1;
		/* The below if is expanded of above
		if (slow == 1) {
			return true;
		}
		return false;
		* */
	}

	private int findSquare(int number) {
		int ans = 0;
		while (number > 0) {
			int rem = number % 10;
			ans += rem * rem;
			number /= 10;
		}
		return ans;
	}

	public Node findMiddleOfLinkedList() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public void bubbleSort() {
		bubbleSort(size - 1, 0);
	}

	/*Need to do bubble sort again
	 * As of now its not working
	 * */

	private void bubbleSort(int row, int col) {
		if (row == 0) {
			return;
		}

		if (col < row) {
			Node first = findNodeAtIndex(col);
			Node second = findNodeAtIndex(col);
//			second = second.next;

			if (first.value > second.value) {
				if (first == head) {
					head = second;
					first.next = second.next;
					second.next = first;
				} else if (second == tail) {
					Node prev = findNodeAtIndex(col - 1);
					prev.next = second;
					tail = first;
					first.next = null;
					second.next = tail;
				} else {
					Node prev = findNodeAtIndex(col - 1);
					prev.next = second;
					first.next = second.next;
					second.next = first;
				}
			}
			bubbleSort(row, col + 1);
		} else {
			bubbleSort(row - 1, 0);
		}
	}

	public void recursiveReverseLinkedList(Node node) {
		//Base condition
		if (node == tail) {
			head = tail;
			return;
		}
		//Keep on calling recursively until tail==null is reached.
		recursiveReverseLinkedList(node.next);
		//this is where the reverse will happen where tail will be head and vice versa
		tail.next = node;
		tail = node;
		tail.next = null;
	}

	//	In place reversal of LinkedList
	public void interativeReverseLinkedList() {
		if (size < 2) {
			return;
		}

		Node prev = null;
		Node present = head;
		Node next = present.next;

		while (present != null) {
			present.next = null;
			prev = present;
			present = next;
			if (next != null) {
				next = next.next;
			}
		}
		head = prev;
	}

}