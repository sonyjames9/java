package linkedlist.com.sony;

public class Main {

  public static void main(String[] args) {
    CustomLinkedList cll = new CustomLinkedList();
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

  }

}
