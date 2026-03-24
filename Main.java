/**
 * A main class to test the Card and CardLinkedList classes.
 * * @author Joshua Breite
 */
public class Main {
  public static void main(String[] args) {
    // --- 1. SETUP ---
    Card card1 = new Card(1, "hearts");
    Card card2 = new Card(11, "diamonds");
    Card card3 = new Card(7, "clubs");
    Card card4 = new Card(1, "hearts"); // Identical to card1

    // --- 2. CARD CLASS TESTS ---
    System.out.println("=== Individual Card Tests ===");
    System.out.println("Printing Cards:");
    System.out.println("Card 1: " + card1.print());
    System.out.println("Card 2: " + card2.print());
    System.out.println("Card 3: " + card3.print());

    System.out.println("\nEquality Tests:");
    System.out.println("Is card1 equal to itself? " + card1.equals(card1));
    System.out.println("Is card1 equal to card4 (same values)? " + card1.equals(card4));
    System.out.println("Is card1 equal to card2 (different)? " + card1.equals(card2));

    // --- 3. CARDLINKEDLIST TESTS ---
    System.out.println("\n=== CardLinkedList Tests ===");
    CardLinkedList list1 = new CardLinkedList();
    CardLinkedList list2 = new CardLinkedList();

    // Test Initial State
    System.out.println("Is list1 empty? " + list1.isEmpty());

    // Adding Cards
    list1.add(card1);
    list1.add(card2);
    list1.add(card3);
    list1.add(card4);

    list2.add(card1);
    list2.add(card2);
    list2.add(card3);

    // Verification of Length and Search
    System.out.println("List 1 length (expected 4): " + list1.getLength());
    System.out.println("List 2 length (expected 3): " + list2.getLength());
    System.out.println("List 1 contains card1? " + list1.hasCard(card1));
    System.out.println("List 1 contains card4? " + list1.hasCard(card4));

    // Testing Retrieval
    System.out.println("Card at index 3 in list1: " + list1.getCardAt(3).print());

    // Testing Removal and Final Output
    System.out.println("\nList 1 before removing card1:");
    list1.print();

    list1.remove(card1);

    System.out.println("List 1 after removing card1:");
    list1.print();

    System.out.println("Final List 2 content:");
    list2.print();

    CardPlay.main(args);
  }
}
