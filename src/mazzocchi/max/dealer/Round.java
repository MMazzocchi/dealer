package mazzocchi.max.dealer;

import java.util.List;
import java.util.ArrayList;

import mazzocchi.max.dealer.deck.Deck;

/**
 * Represents a single round of poker play, including deal, flop, turn, and
 * river.
 */
public class Round {
  private List<Player> players;
  private int number_of_players;
  private Deck deck;
  private int dealer_index;
  private Hand table_hand;

  /**
   * Construct a new round with the players given. The dealer is specified by
   * the dealer_index parameter.
   */
  public Round(List<Player> players, int dealer_index) {
    this.players = players;
    this.number_of_players = players.size();
    this.dealer_index = dealer_index;

    this.deck = new Deck();
    deck.shuffle();

    this.table_hand = new Hand();

    for(Player player : players) {
      player.clearHand();
    }
  }

  /**
   * Deal two cards to each player.
   */
  public void deal() {
    int next_player = (dealer_index + 1) % number_of_players;

    for(int card=0; card<2; card++) {
      for(int i=0; i<number_of_players; i++) {
        Player player = players.get(next_player);
        player.dealCard(deck.draw());

        next_player = (next_player + 1) % number_of_players;
      }
    }
  }

  /**
   * Burn a card, and deal three cards to the table.
   */
  public void flop() {
    deck.draw();
    for(int i=0; i<3; i++) {
      table_hand.add(deck.draw());
    }
  }

  /**
   * Burn a card, and deal one card to the table.
   */
  public void turn() {
    deck.draw();
    table_hand.add(deck.draw());
  }

  /**
   * Burn a card, and deal one card to the table.
   */
  public void river() {
    deck.draw();
    table_hand.add(deck.draw());
  }

  public Hand tableHand() {
    return table_hand;
  }
}
