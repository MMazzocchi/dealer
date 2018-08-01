package mazzocchi.max.dealer;

import java.util.List;
import java.util.ArrayList;

import mazzocchi.max.dealer.deck.Card;

/**
 * Represents a player in the poker game.
 */
public class Player {
  private static int next_id = 0;

  private String name;
  private List<Card> hand;

  public Player() {
    name = "Player #"+next_id;
    next_id++;

    hand = new ArrayList<Card>();
  }

  public void dealCard(Card card) {
    hand.add(card);
  }

  public void clearHand() {
    hand.clear();
  }

  public List<Card> hand() {
    return hand;
  }

  @Override
  public String toString() {
    return name;
  }
}
