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
    int currentDeck = deck.getLength();
    if (currentDeck > 0) {
      System.out.println("Cards remaining in the deck: " + currentDeck);
      int randomCard = rand.nextInt(currentDeck);
      Card startingCard = deck.getCardAt(randomCard);
      deck.remove(startingCard);
      center.add(startingCard);
      System.out.println("Starting card in the center: " + startingCard.print());
    } else {
      System.out.println("No cards remaining in the deck.");
    }

    boolean gameRunning = true;
    int currentPlayer = 0;

    // Main game loop
    while (gameRunning) {
      System.out.println("Player " + (currentPlayer + 1) + "'s turn:");

      // Print the top card in the center
      Card topCard = center.getCardAt(0);
      System.out.println("Top card: " + topCard.print());

      // Attempt to play a card from the current player's hand that matches the top
      // card in the center
      boolean cardPlayed = hands[currentPlayer].play(center);

      // If the player played a card, print the action. Otherwise, draw a card from
      // the
      if (cardPlayed) {
        System.out.println("Player " + (currentPlayer + 1) + " played a card.");
      } else {
        Card drawnCard = deck.getCardAt(rand.nextInt(deck.getLength()));
        if (drawnCard != null) {
          hands[currentPlayer].add(drawnCard);
          deck.remove(drawnCard);
          System.out.println("Player " + (currentPlayer + 1) + " drew a card.");
        } else {
          System.out.println("No cards left to draw.");
        }
      }

      // Check if the current player has won by checking if their hand is empty
      if (hands[currentPlayer].getLength() == 0) {
        System.out.println("Player " + (currentPlayer + 1) + " wins!");
        gameRunning = false;
      } else {
        currentPlayer = (currentPlayer + 1) % hands.length;
      }
    }
  }
}
