package mazzocchi.max.dealer;

import java.util.List;
import java.util.ArrayList;

import mazzocchi.max.dealer.deck.Card;
import mazzocchi.max.dealer.deck.Deck;

/**
 * Represents a single round of poker play, including deal, flop, turn, and
 * river.
 */
public class Round {

  private static final int FLOP_COUNT = 3;
  private static final int TURN_COUNT = 1;
  private static final int RIVER_COUNT = 1;
  private static final int MAX_CARDS_ON_TABLE = FLOP_COUNT + TURN_COUNT +
    RIVER_COUNT;

  private List<Player> players;
  private int number_of_players;
  private Deck deck;
  private int dealer_index;
  private List<Card> cards_on_table;

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

    this.cards_on_table = new ArrayList<Card>(MAX_CARDS_ON_TABLE);

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
      cards_on_table.add(deck.draw());
    }
  }

  /**
   * Burn a card, and deal one card to the table.
   */
  public void turn() {
    deck.draw();
    cards_on_table.add(deck.draw());
  }

  /**
   * Burn a card, and deal one card to the table.
   */
  public void river() {
    deck.draw();
    cards_on_table.add(deck.draw());
  }

  /**
   * Print the cards currently showing on the table.
   */
  public void printCardsOnTable() {
    for(Card card : cards_on_table) {
      System.out.println("  "+card);
    }
  }
}
