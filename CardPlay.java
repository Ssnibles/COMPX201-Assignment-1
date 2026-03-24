import java.util.Random;

/**
 * CardPlay class to demonstrate the use of Card and CardLinkedList classes to
 * create a deck of cards,
 * distribute them to players, and print their hands.
 *
 * @author Joshua Breite
 */
public class CardPlay {
  public static void main(String[] args) {
    // Create a new CardLinkedList to represent the deck of cards
    CardLinkedList deck = new CardLinkedList();
    CardLinkedList center = new CardLinkedList();
    Random rand = new Random();
    // Define the suits of the cards
    String[] suits = { "Spades", "Clubs", "Diamonds", "Hearts" };
    // Create an array of CardLinkedList to represent the hands of 4 players
    CardLinkedList[] hands = new CardLinkedList[4];

    // Create a standard deck of 52 cards
    for (int i = 1; i <= 13; i++) {
      for (String suit : suits) {
        deck.add(new Card(i, suit));
      }
    }

    for (int i = 0; i < hands.length; i++) {
      hands[i] = new CardLinkedList();
    }

    /*
     * Distribute 5 cards to each player's hand by randomly selecting cards from the
     * deck and removing them from the deck
     */
    for (int handIndex = 0; handIndex < hands.length; handIndex++) {
      for (int cardIndex = 0; cardIndex < 5; cardIndex++) {
        int deckSize = deck.getLength();
        if (deckSize > 0) {
          int ranomIndex = rand.nextInt(deckSize);
          Card card = deck.getCardAt(ranomIndex);

          deck.remove(card);
          hands[handIndex].add(card);
        }
      }
    }

    // Print the hands of cards for each player
    for (int i = 0; i < hands.length; i++) {
      System.out.println("Hand " + (i + 1) + ":");
      for (int j = 0; j < hands[i].getLength(); j++) {
        System.out.println(hands[i].getCardAt(j).print());
      }
      System.out.println();
    }

    // Randomly select a card from the remaining deck to place in the center and
    // print it
    int currentDeckSize = deck.getLength();
    if (currentDeckSize > 0) {
      System.out.println("Cards remaining in the deck: " + currentDeckSize);
      int randomCard = rand.nextInt(currentDeckSize);
      Card startingCard = deck.getCardAt(randomCard);
      deck.remove(startingCard);
      center.add(startingCard);
      System.out.println("Starting card in the center: " + startingCard.print());
    } else {
      System.out.println("No cards remaining in the deck.");
    }
  }
}
