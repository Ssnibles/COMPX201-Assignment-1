import java.util.Random;

/**
 * CardPlay class to simulate a card game using CardLinkedList and Card classes
 *
 * @author Joshua Breite
 */
public class CardPlay {
  public static void main(String[] args) {
    int numPlayers = 4;
    int startingHandSize = 5;
    int maxCardNumber = 13;

    // Create the deck and center piles
    CardLinkedList deck = new CardLinkedList();
    CardLinkedList center = new CardLinkedList();

    // Define the suits for the cards
    String[] suits = { "Spades", "Clubs", "Diamonds", "Hearts" };

    // Create an array of CardLinkedList to represent each players hand
    CardLinkedList[] hands = new CardLinkedList[numPlayers];
    Random rand = new Random();

    // Populate the deck with cards of each suit and number
    for (String suit : suits) {
      for (int i = 1; i <= maxCardNumber; i++) {
        deck.add(new Card(i, suit));
      }
    }

    // Initilise each player's hand as an empty CardLinkedList
    for (int i = 0; i < hands.length; i++) {
      hands[i] = new CardLinkedList();
    }

    // Distribute cards to each players hand from the deck
    for (int handIndex = 0; handIndex < hands.length; handIndex++) {
      for (int cardIndex = 0; cardIndex < startingHandSize; cardIndex++) {
        int deckSize = deck.getLength();
        if (deckSize > 0) {
          // Select a random card from the deck and add it to the players hand
          int randomIndex = rand.nextInt(deckSize);
          Card card = deck.getCardAt(randomIndex);
          deck.remove(card);
          hands[handIndex].add(card);
        }
      }
    }

    // Place a random card from the deck into the center pile to start the game
    int deckSize = deck.getLength();
    if (deckSize > 0) {
      int randomCard = rand.nextInt(deckSize);
      Card startingCard = deck.getCardAt(randomCard);
      deck.remove(startingCard);
      center.add(startingCard);
    }

    boolean gameRunning = true;
    int currentPlayer = 0;

    /**
     * Simulate the game by allowing each player to play a card from their hand to
     * the center pile
     * If a player cannot play a card, they draw a card from the deck
     * The game continues until the deck is empty or a player has no cards left in
     * their hand
     */
    while (gameRunning) {
      boolean cardPlayed = hands[currentPlayer].play(center);

      // If the player cannot play a card, they draw a card from the deck
      if (!cardPlayed) {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
          hands[currentPlayer].add(drawnCard);
        }
      }

      // Check if the game should continue or if a player has won
      if (deck.isEmpty() || hands[currentPlayer].isEmpty()) {
        gameRunning = false;
      } else {
        currentPlayer = (currentPlayer + 1) % hands.length;
      }
    }

    // Determine the winner by finding the player with the fewest cards left
    // in their hand
    int minCards = hands[0].getLength();
    for (int i = 1; i < hands.length; i++) {
      if (hands[i].getLength() < minCards) {
        minCards = hands[i].getLength();
      }
    }

    // Print the final state of the center pile and each players hand, indicating
    // the winners
    System.out.println("Final pile:");
    center.print();
    System.out.println("\n");

    // Print each players hand and indicate the winner
    System.out.println("Final hands:");
    for (int i = 0; i < hands.length; i++) {
      if (hands[i].getLength() == minCards) {
        System.out.print("WINNER! ");
      }
      System.out.print("Player " + (i + 1) + ": ");
      hands[i].print();
      System.out.println();
    }
  }
}
