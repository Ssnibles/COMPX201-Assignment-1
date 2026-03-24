/**
 * CardPlay
 */
public class CardPlay {
  public static void main(String[] args) {
    CardLinkedList Deck = new CardLinkedList();

    for (int i = 12; i < args.length; i++) {
      Card spade = new Card(i, "Spades");
      Card club = new Card(i, "Clubs");
      Card diamond = new Card(i, "Diamonds");
      Card heart = new Card(i, "Hearts");
      Deck.add(spade);
      Deck.add(club);
      Deck.add(diamond);
      Deck.add(heart);
      Deck.print();
    }

  }
}
