/**
 * A class representing a linked list of cards. This class provides methods to
 * check if the linked list is empty, get the length of the linked list, and
 * check if a specific card is present in the linked list.
 *
 * @author Joshua Breite
 */
public class CardLinkedList {
  private Node head;

  // Constructor
  private class Node {
    Card card;
    Node next;

    /**
     * Constructor for Node class
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
   * Check if a specific card is present in the linked list
   *
   * @param card the card to be checked for presence in the linked list
   * @return true if the card is present, false otherwise
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
   * @return the card at the specified index
   * @throws IndexOutOfBoundsException if the index is out of bounds
   */
  public Card getCardAt(int index) {
    // Out of bounds check: if the index is negative, throw an exception
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index must be non-negative");
    }
    // Traverse the linked list to find the card at the specified index
    Node current = head;
    int currentIndex = 0;
    while (current != null) {
      /**
       * If the current index matches the specified index, return the card at that
       * index
       */
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
   * Add a card to the end of the linked list
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
    // Base case: if the linked list is empty, return
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
   * Play a card from the hand onto the pile. This method checks if any card in
   * the
   * hand can be played on top of the pile's top card. If a valid card is found,
   * it is removed from the hand and added to the pile.
   *
   * @param pile the CardLinkedList representing the pile of cards
   * @return true if a card was successfully played, false otherwise
   */
  public boolean play(CardLinkedList pile) {
    if (pile.isEmpty())
      return false;

    // The top of the pile is the first card
    Card topCard = pile.getCardAt(0);
    Node current = head;

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
