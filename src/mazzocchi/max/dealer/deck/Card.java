package mazzocchi.max.dealer.deck;

public class Card {

  private int value;
  private String value_string;
  private Suit suit;

  public Card(int value, Suit suit) {
    this.value = value;
    this.suit = suit;

    if(value == 1) {
      value_string = "Ace";
    } else if(value == 11) {
      value_string = "Jack";
    } else if(value == 12) {
      value_string = "Queen";
    } else if(value == 13) {
      value_string = "King";
    } else {
      value_string = ""+value;
    }
  }

  @Override
  public String toString() {
    return value_string+" of "+suit;
  }
}
