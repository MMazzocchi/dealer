package mazzocchi.max.dealer;

import java.util.List;
import java.util.ArrayList;

import mazzocchi.max.dealer.deck.Card;

/**
 * Represents a hand of cards.
 */
public class Hand {

  private static final int MAX_HAND_SIZE = 5;

  private List<Card> cards;

  public Hand() {
    cards = new ArrayList<Card>(MAX_HAND_SIZE);
  }

  public void add(Card card) {
    cards.add(card);
  }

  public void clear() {
    cards.clear();
  }

  @Override
  public String toString() {
    String str = "";
    for(Card card : cards) {
      str += "  "+card+"\n";
    }

    return str;
  }
};
