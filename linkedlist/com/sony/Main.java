package linkedlist.com.sony;

public class Main {

  public static void main(String[] args) {
    CustomLinkedList cll = new CustomLinkedList();
    cll.insertFirst(3);
    cll.insertFirst(2);
    cll.insertFirst(8);
    cll.insertFirst(1);
    cll.insertFirst(9);

    cll.display();
  }

}
