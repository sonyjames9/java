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

    this.size += 1;

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

    this.size += 1;

  }

  public void insertAtIndex(int index, int value) {
    if (index == 0)
      insertFirst(value);
    else if (index == size - 1)
      insertLast(value);
    else if (index > size)
      throw new IndexOutOfBoundsException();
    else {
      Node prevNode = findNodeAtIndex(index - 2);
      Node insertAtIndexNode = new Node(value, prevNode, prevNode.next);
      insertAtIndexNode.next = prevNode.next;
      prevNode.next = insertAtIndexNode;
      insertAtIndexNode.previous = prevNode;
      if (insertAtIndexNode.next != null)
        insertAtIndexNode.next.previous = insertAtIndexNode;
      this.size += 1;
    }
  }

  public void insertNodeAfterValue(int valueToBeSearched, int value) {

    Node nodeAtValue = findNodeAfterValue(valueToBeSearched);
    if (nodeAtValue == null) {
      System.out.println("Node does not exists");
      return;
    }
    Node nodeToBeInsertedAfterValue = new Node(value);
    nodeToBeInsertedAfterValue.next = nodeAtValue.next;
    nodeAtValue.next = nodeToBeInsertedAfterValue;
    nodeToBeInsertedAfterValue.previous = nodeAtValue;
    if (nodeToBeInsertedAfterValue.next != null)
      nodeToBeInsertedAfterValue.next.previous = nodeToBeInsertedAfterValue;
    this.size += 1;
  }

  public void deleteAtFirst() throws Exception {
    if (head == null && tail == null)
      throw new Exception("Empty Linked list");
    else if (head.next == null) {
      head = null;
    } else {
      Node node = head;
      node = node.next;
      head = node;
      head.previous = null;
    }
    size -= 1;
  }

  public void deleteAtLast() throws Exception {
    if (head == null && tail == null) {
      throw new Exception("Empty Linked List");
    }
    Node findPreviousNode = findNodeAtIndex(size - 2);
    tail = findPreviousNode;
    findPreviousNode.next = null;
    tail.previous = findPreviousNode.previous;
    size -= 1;
  }

  public void deleteNodeAtIndex(int index) throws Exception {
    if (index == 0)
      deleteAtFirst();
    else if (index == size)
      deleteAtLast();
    else if (index > size)
      throw new IndexOutOfBoundsException();
    else {
      Node nodeAtIndex = findNodeAtIndex(index - 2);
      nodeAtIndex.next = nodeAtIndex.next.next;
      nodeAtIndex.next.previous = nodeAtIndex;
    }
    size -= 1;
  }

  public Node findNodeAtIndex(int index) {
    Node nodeAtIndex = head;
    for (int i = 0; i < index; i++) {
      nodeAtIndex = nodeAtIndex.next;
    }
    System.out.println(nodeAtIndex.value);
    return nodeAtIndex;
  }

  public Node findNodeAfterValue(int value) {
    Node node = head;
    while (node != null) {
      if (node.value == value)
        return node;
      node = node.next;
    }
    return null;
  }

  public void display() {
    Node node = head;
    Node lastNode = null;
    while (node != null) {
      System.out.print(node.value);
      lastNode = node;
      node = node.next;
      if (node != null)
        System.out.print(" -> ");
    }
    System.out.println("\nNodes in reverese order");

    while (lastNode != null) {
      System.out.print(lastNode.value);
      lastNode = lastNode.previous;
      if (lastNode != null) {
        System.out.print(" <- ");
      }
    }
    System.out.println();
  }

  /*
   * public void displayRev() { Node node = head; Node lastNode = null; while
   * (node != null) { node = node.next; lastNode = node; } while (lastNode !=
   * null) { System.out.print(lastNode.value); if (lastNode != null) {
   * System.out.print(" <- "); lastNode = lastNode.previous; } }
   * System.out.println(); }
   */

}