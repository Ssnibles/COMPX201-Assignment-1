/**
 * A main class to test the Card class. This class creates some Card objects and
 * tests the print and equals methods of the Card class.
 *
 * @author Joshua Breite
 */
public class Main {
  /**
   * Main method to test the Card class
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    // Create some Card objects
    Card card1 = new Card(1, "hearts");
    Card card2 = new Card(11, "diamonds");
    Card card3 = new Card(7, "clubs");

    // Test the print method
    System.out.println("Cards:");
    System.out.println(card1.print());
    System.out.println(card2.print());
    System.out.println(card3.print() + "\n");

    // Test the equals method
    System.out.println("Does card1 equal card1: " + card1.equals(card1));
    System.out.println("Does card1 equal card2: " + card1.equals(card2) + "\n");

    // Test the CardLinkedList class
    CardLinkedList list1 = new CardLinkedList();
    CardLinkedList list2 = new CardLinkedList();
    // Add new cards to node
    list1.add(card1);
    list1.add(card2);
    list1.add(card3);
    list2.add(card1);
    list2.add(card2);
    list2.add(card3);
    System.out.println("list1 length: " + list1.getLength());
    System.out.println("list2 length: " + list2.getLength());
    list1.print();
    list2.print();
  }

}
