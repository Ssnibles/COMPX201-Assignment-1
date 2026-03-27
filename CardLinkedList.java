/**
 * CardLinkedList class represents a linked list of cards. It provides methods
 * to add, remove, and check for cards in the list, as well as to play a card
 * onto a pile.
 *
 * @author Joshua Breite
 */
public class CardLinkedList {
  private Node head;

  private class Node {
    Card card;
    Node next;

    /**
     * Constructor for the Node class
     *
     * @param card the card to be stored in the node
     */
    public Node(Card card) {
      this.card = card;
      this.next = null;
    }
  }

  // Check if the linked list is empty
  public boolean isEmpty() {
    return head == null;
  }

  // Get the length of the linked list
  public int getLength() {
    int length = 0;
    Node current = head;
    // Traverse the linked list to count the number of nodes
    while (current != null) {
      length++;
      current = current.next;
    }
    return length;
  }

  /**
   * Check if the linked list contains a specific card
   *
   * @param card the card to be checked for in the linked list
   * @return true if the card is present in the linked list, false otherwise
   */
  public boolean hasCard(Card card) {
    Node current = head;
    // Traverse the linked list to check if the specified card is present
    while (current != null) {
      if (current.card.equals(card)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  /**
   * Get the card at a specific index in the linked list
   *
   * @param index the index of the card to be retrieved
   * @return the card at the specified index in the linked list
   * @throws IndexOutOfBoundsException if the index is negative or exceeds the
   *                                   length of the linked list
   */
  public Card getCardAt(int index) {
    // Check if the index is negative
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index must be non-negative");
    }
    // Traverse the linked list to find the card at the specified index
    Node current = head;
    int currentIndex = 0;
    while (current != null) {
      // If the current index matches the specified index, return the card at the
      // current node
      if (currentIndex == index) {
        return current.card;
      }
      // Move to the next node in the linked list and increment the current index
      current = current.next;
      currentIndex++;
    }
    throw new IndexOutOfBoundsException("Index out of bounds");
  }

  /**
   * Add a card to the front of the linked list.
   *
   * @param card the card to be added to the linked list
   */
  public void add(Card card) {
    Node newNode = new Node(card);
    newNode.next = head;
    head = newNode;
  }

  /**
   * Remove a specific card from the linked list
   *
   * @param card the card to be removed from the linked list
   */
  public void remove(Card card) {
    if (head == null) {
      return;
    }
    // If the head node is the card to be removed, update the head to the next node
    if (head.card.equals(card)) {
      head = head.next;
      return;
    }
    Node current = head;
    // Traverse the linked list to find the card to be removed
    while (current.next != null) {
      if (current.next.card.equals(card)) {
        current.next = current.next.next;
        return;
      }
      // Move to the next node in the linked list
      current = current.next;
    }
  }

  // Print the linked list
  public void print() {
    Node current = head;
    // Print each card in the linked list recursively
    while (current != null) {
      System.out.print(current.card.print() + ", ");
      current = current.next;
    }
  }

  /**
   * Draw a card from the linked list. This method removes the head of the linked
   * list and returns the card at the head.
   *
   * @return the card that was drawn from the linked list, or null if the linked
   *         list is empty
   */
  public Card drawCard() {
    if (head == null) {
      return null;
    }
    Card card = head.card;
    head = head.next;
    return card;
  }

  /**
   * Play a card from the linked list onto a pile.
   *
   * @param pile the pile onto which the card will be played
   * @return true if a card was successfully played, false otherwise
   */
  public boolean play(CardLinkedList pile) {
    if (pile.isEmpty())
      return false;

    Card topCard = pile.getCardAt(0);
    Node current = head;

    // Traverse the linked list to find a card that can be played on top of the card
    while (current != null) {
      if (current.card.isValidPlay(topCard)) {
        Card cardToPlay = current.card;
        this.remove(cardToPlay); // Remove from hand
        pile.add(cardToPlay); // Add to pile
        return true;
      }
      current = current.next;
    }
    return false;
  }
}
