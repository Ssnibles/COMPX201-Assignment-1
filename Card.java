/**
 * Card class represents a playing card with a number and suit
 *
 * @author Joshua Breite
 */
public class Card {
  private int number;
  private String suit;

  /**
   * Constructor for the Card class
   *
   * @param number the number of the card
   * @param suit   the suit of the card
   */
  public Card(int number, String suit) {
    this.number = number;
    this.suit = suit;
  }

  /**
   * Getter for number
   *
   * @return number the number of the card
   */
  public int getNumber() {
    return number;
  }

  /**
   * Getter for suit
   *
   * @return suit the suit of the card
   */
  public String getSuit() {
    return suit;
  }

  /**
   * Returns a string representation of the card
   *
   * @return a string in the format "number of suit"
   */
  public String print() {
    String numberString;
    numberString = switch (number) {
      case 1 -> "Ace";
      case 11 -> "Jack";
      case 12 -> "Queen";
      case 13 -> "King";
      default -> Integer.toString(number);
    };
    return numberString + " of " + suit;
  }

  /**
   * Overrides the equals method to compare two Card objects
   *
   * @param o the object to compare with
   * @return true if the cards are equal, false otherwise
   */
  public boolean equals(Object o) {
    // Check if the object is the same instance
    if (this == o) {
      return true;
    }
    // Check if the object is null or of a different class
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    // Cast the object to Card and compare the number and suit
    Card card = (Card) o;
    return this.number == card.number && suit.equals(card.suit);
  }

  /**
   * Checks if the card can be played on top of another card based on the game
   * rules
   *
   * @param c the card to compare with
   * @return true if the card can be played, false otherwise
   */
  public boolean isValidPlay(Card c) {
    // Check if the suits match
    if (this.suit.equals(c.suit)) {
      return true;
    }
    // Check if the number is exactly one higher or lower
    return Math.abs(this.number - c.number) == 1;
  }
}
