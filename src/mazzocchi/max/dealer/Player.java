package mazzocchi.max.dealer;

import mazzocchi.max.dealer.deck.Card;

public class Player {
  private static int next_id = 0;

  private String name;
  private boolean is_dealer = false;
  private Hand hand;

  public Player() {
    name = "Player #"+next_id;
    next_id++;

    hand = new Hand();
  }

  public void setDealer(boolean is_dealer) {
    this.is_dealer = is_dealer;
  }

  public void dealCard(Card card) {
    hand.add(card);
  }

  public void clearHand() {
    hand.clear();
  }

  @Override
  public String toString() {
    if(is_dealer) {
      return name+" (dealer)";

    } else {
      return name;
    }
  }
}
