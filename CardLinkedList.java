/**
 * A class representing a linked list of cards. This class provides methods to
 * check if the linked list is empty, get the length of the linked list, and
 * check if a specific card is present in the linked list.
 *
 * @author Joshua Breite
 */
public class CardLinkedList {
  public Node head;

  // Constructor
  public class Node {
    Card card;
    Node next;

    public Node(Card card) {
      this.card = card;
      this.next = null;
    }
  }

  // Check if the linked list is empty
  public boolean isEmpy() {
    return head == null;
  }

  // Add a card to the end of the linked list
  public int getLength() {
    int length = 0;
    Node current = head;
    while (current != null) {
      length++;
      current = current.next;
    }
    return length;
  }

  /**
   * Add a card to the end of the linked list
   *
   * @param card the card to be added
   */
  public boolean hasCard(Card card) {
    Node current = head;
    while (current != null) {
      if (current.card.equals(card)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  /**
   * Add a card to the end of the linked list
   *
   * @param card the card to be added
   */
  public Card getCardAt(int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index must be non-negative");
    }
    Node current = head;
    int currentIndex = 0;
    while (current != null) {
      if (currentIndex == index) {
        return current.card;
      }
      current = current.next;
      currentIndex++;
    }
    throw new IndexOutOfBoundsException("Index out of bounds");
  }

  /**
   * Add a card to the end of the linked list
   *
   * @param card the card to be added
   */
  public void add(Card card) {
    Node newNode = new Node(card);
    if (head == null) {
      head = newNode;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  /**
   * Remove a card from the linked list
   *
   * @param card the card to be removed
   */
  public void remove(Card card) {
    if (head == null) {
      return;
    }
    if (head.card.equals(card)) {
      head = head.next;
      return;
    }
    Node current = head;
    while (current.next != null) {
      if (current.next.card.equals(card)) {
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }
}
