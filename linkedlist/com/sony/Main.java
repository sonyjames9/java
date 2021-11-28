package linkedlist.com.sony;

public class Main {

  public static void main(String[] args) throws Exception {
    /*
     * SinglyLinkedList cll = new SinglyLinkedList(); cll.insertFirst(3);
     * cll.insertFirst(2); cll.insertFirst(8); cll.insertFirst(1);
     * cll.insertFirst(4); cll.insertFirst(7); cll.insertFirst(10);
     * cll.insertFirst(9);
     * 
     * cll.insertLast(77); cll.insertAtIndex(55, 4);
     * 
     * cll.display(); // cll.insertAtIndex(55, 20);
     * 
     * cll.deleteFirst(); cll.display(); int value =
     * cll.deleteFirstAndReturnValue(); System.out.println("Value deleted : " +
     * value); cll.display();
     * 
     * cll.deleteLast(); cll.display(); cll.insertFirst(56); cll.insertFirst(45);
     * cll.display(); System.out.println("Value deleted at index : " +
     * cll.deleteAtIndex(5)); cll.display();
     * System.out.println("Index of node of searched value : " +
     * cll.findNodeIndexOfValue(55));
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
    
    CircularLinkedList cll = new CircularLinkedList();
    cll.insert(10);
    cll.insert(20);
    cll.insert(25);
    cll.insert(30);
    cll.insert(35);
    cll.insert(40);
    cll.display();
    cll.delete(25);
    cll.display();
  }
}
