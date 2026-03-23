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
   * @param args: command line arguments
   */
  public static void main(String[] args) {
    // Create some Card objects
    Card card1 = new Card(1, "hearts");
    Card card2 = new Card(11, "diamonds");
    Card card3 = new Card(7, "clubs");

    // Test the print method
    System.out.println(card1.print());
    System.out.println(card2.print());
    System.out.println(card3.print());

    // Test the equals method
    System.out.println(card1.equals(card1));
    System.out.println(card1.equals(card2));

    // Test the CardLinkedList class
    CardLinkedList node1 = new CardLinkedList();
    node1.add(card1);
    System.out.println(node1.getLength());
  }

}
