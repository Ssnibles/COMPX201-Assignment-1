/**
 * CardPlay.java
 */
public class CardPlay {
  public static void main(String[] args) {
    // Create a new CardLinkedList to represent the deck of cards
    CardLinkedList deck = new CardLinkedList();

    // Define the suits of the cards
    String[] suits = { "Spades", "Clubs", "Diamonds", "Hearts" };

    // Create a standard deck of 52 cards
    for (int i = 1; i <= 13; i++) {
      for (String suit : suits) {
        deck.add(new Card(i, suit));
      }
    }
    deck.print();
  }
}
