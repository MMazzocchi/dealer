package mazzocchi.max.dealer;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import mazzocchi.max.dealer.deck.Deck;

public class Round {
  private List<Player> players;
  private int number_of_players;
  private Deck deck;
  private int dealer_index;
  private Hand table_hand;

  public Round(List<Player> players, dealer_index) {
    this.players = players;
    this.number_of_players = players.size();
    this.dealer_index = dealer_index;

    this.deck = new Deck();
    deck.shuffle();

    this.table_hand = new Hand();
  }

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

  public void flop() {
    deck.draw();
    for(int i=0; i<3; i++) {
      table_hand.add(deck.draw());
    }
  }

  public void turn() {
    deck.draw();
    table_hand.add(deck.draw());
  }

  public void river() {
    deck.draw();
    table_hand.add(deck.draw());
  }
}
