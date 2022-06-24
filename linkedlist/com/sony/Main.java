package linkedlist.com.sony;

public class Main {

  public static void main(String[] args) throws Exception {

 /*   SinglyLinkedList sll = new SinglyLinkedList();
    sll.insertFirst(3);
    sll.insertFirst(2);
    sll.insertFirst(8);
    sll.insertFirst(1);
    sll.insertFirst(4);
    sll.insertFirst(7);
    sll.insertFirst(10);
    sll.insertFirst(9);

    sll.insertLast(77);
    sll.insertAtIndex(55, 4);

    sll.display(); // cll.insertAtIndex(55, 20);

    sll.deleteFirst();
    sll.display();
    int value = sll.deleteFirstAndReturnValue();
    System.out.println("Value deleted : " + value);
    sll.display();

    sll.deleteLast();
    sll.display();
    sll.insertFirst(56);
    sll.insertFirst(45);
    sll.display();
    System.out.println("Value deleted at index : " + sll.deleteAtIndex(5));
    sll.display();
    System.out.println("Index of node of searched value : " + sll.findNodeOfValue(55));
    sll.insertUsingRecursion(99, 3);
    sll.display();
*/
    /*
     * DoublyLinkedList dlist = new DoublyLinkedList(); dlist.insertFirst(3);
     * dlist.insertFirst(2); dlist.insertFirst(8); dlist.insertFirst(7);
     * dlist.insertFirst(20); dlist.insertFirst(25); dlist.insertLast(40);
     * dlist.insertLast(10); dlist.insertLast(15); dlist.insertLast(18);
     * dlist.insertLast(30); dlist.insertAtIndex(6, 39); dlist.display();
     * System.out.println(); dlist.insertNodeAfterValue(10, 11); dlist.display();
     * System.out.println(); dlist.insertNodeAfterValue(30, 31); dlist.display();
     * System.out.println(); dlist.insertNodeAfterValue(25, 26); dlist.display();
     * System.out.println(); dlist.deleteAtFirst(); dlist.display();
     * System.out.println(); dlist.deleteAtLast(); dlist.display();
     * System.out.println(); dlist.deleteNodeAtIndex(5); dlist.display();
     * System.out.println(); // dlist.displayRev();
     */
    
/*
 * CircularLinkedList cll = new CircularLinkedList(); cll.insert(10);
 * cll.insert(20); cll.insert(25); cll.insert(30); cll.insert(35);
 * cll.insert(40); cll.display(); cll.delete(25); cll.display();
 */
    /*Leetcode questions
    * 1. Remove Duplicates from sorted linkedlist*/

    SinglyLinkedList removeDuplicates = new SinglyLinkedList();
    removeDuplicates.insertFirst(3);
    removeDuplicates.insertFirst(3);
    removeDuplicates.insertFirst(3);
    removeDuplicates.insertLast(5);
    removeDuplicates.insertLast(7);
    removeDuplicates.insertLast(7);
    removeDuplicates.insertLast(8);
    removeDuplicates.insertLast(9);
    removeDuplicates.insertLast(10);
    removeDuplicates.display();
    removeDuplicates.removeDuplicates();
    removeDuplicates.display();

    /*
    * 2. Merge two linked lists into one sorted linked lists
    * */
    System.out.println("Merged Linked List ");
    SinglyLinkedList firstList = new SinglyLinkedList();
    firstList.insertFirst(3);
    firstList.insertLast(5);
    firstList.insertLast(7);
    firstList.insertLast(8);
    firstList.display();

    SinglyLinkedList secondList = new SinglyLinkedList();
    secondList.insertLast(4);
    secondList.insertLast(6);
    secondList.insertLast(9);
    secondList.insertLast(10);
    secondList.insertLast(11);
    secondList.display();

    SinglyLinkedList mergedList  = SinglyLinkedList.mergeLinkedLists(firstList, secondList);
    mergedList.display();

    System.out.println("Linked List cyclic");
    SinglyLinkedList cyclicList = new SinglyLinkedList();
    cyclicList.insertLast(10);
    cyclicList.insertLast(12);
    cyclicList.insertLast(13);
    cyclicList.insertLast(14);
    cyclicList.insertLast(15);
    boolean isCyclic = cyclicList.hasCycleInLinkedList();
    System.out.println("Is the linkedlist cyclic : "+isCyclic);
    cyclicList.head.next.next = cyclicList.head.next;
    isCyclic = cyclicList.hasCycleInLinkedList();
    System.out.println("Is the linkedlist cyclic : "+isCyclic);

    System.out.println("Linked List cyclic length");
    SinglyLinkedList cyclicListlength = new SinglyLinkedList();
    cyclicListlength.insertLast(10);
    cyclicListlength.insertLast(12);
    cyclicListlength.insertLast(13);
    cyclicListlength.insertLast(14);
    cyclicListlength.insertLast(15);
    cyclicListlength.insertLast(16);
    cyclicListlength.insertLast(17);
    cyclicListlength.insertLast(18);
    cyclicListlength.head.next.next.next.next.next = cyclicListlength.head.next;
    System.out.println("The length of linked list cycle is : "+cyclicListlength.linkedListCycleLength());
    System.out.println("The start of cycle is : "+cyclicListlength.detectStartofCycle().value);

    System.out.println("Find number is happy number or not");
    SinglyLinkedList happynumber =  new SinglyLinkedList();
    System.out.println("The start of cycle is : "+happynumber.isHappy(10));
    System.out.println("The start of cycle is : "+happynumber.isHappy(15));
    System.out.println("The start of cycle is : "+happynumber.isHappy(2));


    System.out.println("Find middle of linked list");
    SinglyLinkedList findMiddleOfLL = new SinglyLinkedList();
    findMiddleOfLL.insertLast(10);
    findMiddleOfLL.insertLast(11);
    findMiddleOfLL.insertLast(12);
    findMiddleOfLL.insertLast(14);
    findMiddleOfLL.insertLast(15);
    findMiddleOfLL.insertLast(1);
    findMiddleOfLL.insertLast(5);

    int midValOfLL = findMiddleOfLL.findMiddleOfLinkedList().value;
    System.out.println("The value of middle Node of Linked List is : "+midValOfLL);

    System.out.println("Merge Sort a LinkedList");
    SinglyLinkedList unsortedLinkedList = new SinglyLinkedList();
    unsortedLinkedList.insertLast(10);
    unsortedLinkedList.insertLast(11);
    unsortedLinkedList.insertLast(12);
    unsortedLinkedList.insertLast(14);
    unsortedLinkedList.insertLast(15);
    unsortedLinkedList.insertLast(1);
    unsortedLinkedList.insertLast(5);

    ListNode A = new ListNode('1');
    ListNode B = new ListNode('3');
    ListNode C = new ListNode('2');
    ListNode D = new ListNode('4');
    ListNode E = new ListNode('5');
    ListNode F = new ListNode('6');
    ListNode G = new ListNode('7');

    A.next = B;
    B.next = C;
    C.next = D;
    D.next = E;
    E.next = F;
    F.next = G;


    System.out.println("The value of middle Node of Linked List is : "+ ListNode.findMiddleOfLinkedList(A).val);
    ListNode sortll = ListNode.sortList(A);
    System.out.println("Sorted Linkedlist : "+ sortll.val);

    System.out.println("Bubble Sort");
    SinglyLinkedList bubbleSort = new SinglyLinkedList();
    for (int i=7; i > 0; i--) {
      bubbleSort.insertLast(i);
    }
    bubbleSort.display();
    bubbleSort.bubbleSort();
    /*Need to do bubble sort again*/
    bubbleSort.display();


    System.out.println("Linkedlist reverse");
    ListNode H = new ListNode();
    ListNode I = new ListNode();
    ListNode J = new ListNode();
    ListNode K = new ListNode();
    ListNode L = new ListNode();
    ListNode test = new ListNode();
    H.next = I;
    test = H;
    I.next = J;
    J.next = K;
    K.next = L;
    H.val = 1;
    I.val = 2;
    J.val = 3;
    K.val = 4;
    L.val = 5;
    System.out.println(test.interativeReverseLinkedList(H).val);


  }
}


