package mazzocchi.max.dealer.deck;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Deck {

  private static final int CARDS_PER_SUIT = 13;

  private List<Card> cards;

  public Deck() {
    cards = new LinkedList<Card>();
    for(Suit suit : Suit.values()) {
      for(int value = 1; value <= CARDS_PER_SUIT; value++) {
        Card card = new Card(value, suit);
        cards.add(card);
      }
    }
  };

  public Card draw() {
    return cards.get(0);
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }
}
