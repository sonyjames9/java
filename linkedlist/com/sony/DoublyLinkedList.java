package linkedlist.com.sony;

public class DoublyLinkedList {

  private Node head;
  private Node tail;

  private int size = 0;

  public class Node {
    private int value;
    private Node next;
    private Node previous;

    public Node(int value) {
      this.value = value;
    }

    public Node(int value, Node previous, Node next) {
      this.value = value;
      this.previous = previous;
      this.next = next;
    }
  }

  public DoublyLinkedList() {
    this.size = 0;
  }

  public void insertFirst(int value) {
    Node insertAtFirstNode = new Node(value);
    insertAtFirstNode.next = head;
    insertAtFirstNode.previous = null;
    if (head != null)
      head.previous = insertAtFirstNode;
    head = insertAtFirstNode;

    size += 1;

  }

  public void insertLast(int value) {
    Node insertAtLastNode = new Node(value);
    Node last = head;

    if (head == null) {
      insertAtLastNode.previous = null;
      head = insertAtLastNode;
      return;
    }

    while (last.next != null)
      last = last.next;

    last.next = insertAtLastNode;
    insertAtLastNode.previous = last;

    size += 1;

  }

  public void display() {
    Node node = head;
    while (node != null) {
      System.out.print(node.value);
      node = node.next;
      if (node != null)
        System.out.print(" -> ");
    }
    System.out.println();
  }

  public void displayRev() {
    Node node = tail;
    while (node != null) {
      System.out.print(node.value);
      node = node.previous;
      if (node != null)
        System.out.print(" <- ");
    }
    System.out.println();
  }
  

}