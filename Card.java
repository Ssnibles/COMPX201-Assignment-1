/**
 * Card
 */
public class Card {
  private int number;
  private string suit;

  /**
   * @param number: the number of the card (1-13)
   * @param suit:   the suit of the card (hearts, diamonds, clubs, spades)
   */
  public Card(int number, string suit) {
    this.number = number;
    this.suit = suit;
  }

  /**
   * Returns the number of the card
   *
   * @return number: the number of the card
   */

  public int getNumber() {
    return number;
  }

  public sting getSuit() {
    return suit;
  }

  public print toString() {
    return number + " of " + suit;
  }
}
