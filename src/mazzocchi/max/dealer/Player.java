package mazzocchi.max.dealer;

import mazzocchi.max.dealer.deck.Card;

public class Player {
  private static int next_id = 0;

  private String name;
  private Hand hand;

  public Player() {
    name = "Player #"+next_id;
    next_id++;

    hand = new Hand();
  }

  public void dealCard(Card card) {
    hand.add(card);
  }

  public void clearHand() {
    hand.clear();
  }

  public Hand hand() {
    return hand;
  }

  @Override
  public String toString() {
    return name;
  }
}
