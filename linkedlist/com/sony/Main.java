package linkedlist.com.sony;

public class Main {

  public static void main(String[] args) {
    SinglyLinkedList cll = new SinglyLinkedList();
    cll.insertFirst(3);
    cll.insertFirst(2);
    cll.insertFirst(8);
    cll.insertFirst(1);
    cll.insertFirst(4);
    cll.insertFirst(7);
    cll.insertFirst(10);
    cll.insertFirst(9);

    cll.insertLast(77);
    cll.insertAtIndex(55, 4);

    cll.display();
    // cll.insertAtIndex(55, 20);

    cll.deleteFirst();
    cll.display();
    int value = cll.deleteFirstAndReturnValue();
    System.out.println("Value deleted : " + value);
    cll.display();

    cll.deleteLast();
    cll.display();
    cll.insertFirst(56);
    cll.insertFirst(45);
    cll.display();
    System.out.println("Value deleted at index : " + cll.deleteAtIndex(5));
    cll.display();
    System.out.println("Index of node of searched value : " + cll.findNodeIndexOfValue(55));


    
  }
}
