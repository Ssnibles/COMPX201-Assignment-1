/**
 * Card
 */
public class Card {
  private int number;
  private String suit;

  /**
   * Constructor for Card class
   *
   * @param number the number of the card (1-13)
   * @param suit   the suit of the card (hearts, diamonds, clubs, spades)
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
   * Returns the suit of the card
   *
   * @return suit the suit of the card
   */
  public String print() {
    String numberString;
    switch (number) {
      case 1:
        numberString = "Ace";
        break;
      case 11:
        numberString = "Jack";
        break;
      case 12:
        numberString = "Queen";
        break;
      case 13:
        numberString = "King";
        break;
      default:
        numberString = Integer.toString(number);
    }
    return numberString + " of " + suit;
  }

  /**
   * Overrides the equals method to compare two Card objects
   *
   * @param o the object to compare with
   * @return true if the cards are equal, false otherwise
   */
  public boolean equals(Object o) {
    // Check if the object is the same as this
    if (this == o) {
      return true;
    }
    // Check if the object is null or of different class
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    // Cast the object to Card and compare the number and suit
    Card card = (Card) o;
    return number == card.number && suit.equals(card.suit);
  }

}
