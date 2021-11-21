package linkedlist.com.sony;

public class CustomLinkedList {

  private Node head;
  private Node tail;

  private int size = 0;

  public CustomLinkedList() {
    this.size = 0;
  }

  public void insertFirst(int value) {
    Node insertAtFirstNode = new Node(value);
    insertAtFirstNode.next = head;
    head = insertAtFirstNode;

    if (tail == null) {
      tail = head;
    }
    size += 1;

  }

  public void insertLast(int value) {
    if (tail == null)
      insertFirst(value);

    Node insertAtLastNode = new Node(value);
    tail.next = insertAtLastNode;
    tail = insertAtLastNode;
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
      Node temp = head;
      for (int i = 1; i < index; i++) {
        temp = temp.next;
      }
      Node nodeToBeInserted = new Node(value, temp.next);
      temp.next = nodeToBeInserted;
      size += 1;
    }
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
    System.out.println("Size : " + size);
    Node traverseUptoSecondLastNode = head;
    for (int i = 0; i < size - 2; i++) {
      traverseUptoSecondLastNode = traverseUptoSecondLastNode.next;
      System.out.println(traverseUptoSecondLastNode.value);
    }
    tail = traverseUptoSecondLastNode;
    tail.next = null;
    // tail.next = null;
    // while (true)
    // System.out.println("test");
    // tail = head.next;
    // if (head.next == null)
    // tail = null;
  }

  public int deleteLastAndReturnValue() {
    int value = head.value;
    head = head.next;

    if (head.next == null)
      tail = null;
    size -= 1;
    return value;
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

  private class Node {
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
}