package linkedlist.com.sony;

public class CircularLinkedList {
  private Node head;
  private Node tail;

  private int size = 0;

  public CircularLinkedList() {
    this.size = 0;
  }

  public static class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;

    }

  }

  public void insert(int value) {
    Node node = new Node(value);
    if (head == null) {
      head = node;
      tail = node;
      return;
    }
    tail.next = node;
    node.next = head;
    tail = node;
  }

  public void delete(int valueToBeDeleted) {
    Node node = head;
    if (node == null) {
      return;
    }
    if (node.value == valueToBeDeleted) {
      head = head.next;
      tail.next = head;
    }
    do {
      Node nodeTraverse = node.next;
      if (nodeTraverse.value == valueToBeDeleted) {
        node.next = nodeTraverse.next;
        break;
      }
      node = node.next;
    }
    while (node != head);
  }

  public void display() {
    Node node = head;
    if (head != null) {
      do {
        System.out.print(node.value);
        node = node.next;
        if (node != head)
          System.out.print(" -> ");

      }
      while (node != head);
    }
    System.out.println();
  }

}