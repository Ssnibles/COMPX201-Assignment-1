/**
 * Test class for Card and CardLinkedList functionality.
 * This class includes tests for card logic, list operations, and gameplay
 * mechanics.
 */
public class Test {
  public static void main(String[] args) {
    System.out.println("1.Card Logic Tests");
    Card aceHearts = new Card(1, "Hearts");
    Card twoHearts = new Card(2, "Hearts");
    Card kingSpades = new Card(13, "Spades");

    System.out.println("Print check: " + aceHearts.print());
    System.out.println("Print check (Face): " + kingSpades.print());

    // Test isValidPlay (Same Suit)
    System.out.println("Valid Play (Same Suit): " + aceHearts.isValidPlay(twoHearts));
    // Test isValidPlay (Adjacent Number)
    System.out.println("Valid Play (Adjacent Num): " + twoHearts.isValidPlay(new Card(3, "Clubs")));
    // Test isValidPlay (Invalid)
    System.out.println("Invalid Play (Different): " + aceHearts.isValidPlay(kingSpades));

    System.out.println("\n2. List Operation Tests ");
    CardLinkedList hand = new CardLinkedList();

    System.out.println("Is empty initially? " + hand.isEmpty());
    hand.add(aceHearts);
    hand.add(twoHearts);
    hand.add(kingSpades);

    System.out.println("Length (expected 3): " + hand.getLength());
    System.out.print("Current Hand: ");
    hand.print();
    System.out.println();

    // Test Search and Retrieval
    System.out.println("Has Ace of Hearts? " + hand.hasCard(aceHearts));
    System.out.println("Card at index 1: " + hand.getCardAt(1).print());

    // Test Removal
    hand.remove(twoHearts);
    System.out.print("After removing Two of Hearts: ");
    hand.print();
    System.out.println();

    System.out.println("\n3. Gameplay Logic Tests");
    CardLinkedList pile = new CardLinkedList();
    pile.add(new Card(1, "Spades"));

    System.out.print("Hand before playing: ");
    hand.print();

    // The hand contains King of Spades, which should be valid on Ace of Spades
    // (same suit)
    boolean playResult = hand.play(pile);
    System.out.println("\nWas a card played? " + playResult);

    System.out.print("Hand after play: ");
    hand.print();
    System.out.print("\nPile after play: ");
    pile.print();
    System.out.println();
  }
}
