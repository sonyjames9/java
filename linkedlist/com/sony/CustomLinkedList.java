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
      Node temp = findNodeAtIndex(index - 2);
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

  public Node findNodeWithValue(int value) {
    Node node = head;
    while (node != null) {
      if (node.value == value)
        return node;
      node = node.next;
    }
    return null;
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