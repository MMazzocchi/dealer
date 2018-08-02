package mazzocchi.max.dealer;

import java.util.List;
import java.util.ArrayList;

import mazzocchi.max.dealer.deck.Card;

/**
 * Represents a player in the poker game.
 */
public class Player {

  private String name;
  private List<Card> hand;

  public Player(String name) {
    this.name = name;
    this.hand = new ArrayList<Card>();
  }

  public void dealCard(Card card) {
    hand.add(card);
  }

  public void clearHand() {
    hand.clear();
  }

  public final List<Card> getHand() {
    return hand;
  }

  @Override
  public String toString() {
    return name;
  }
}
