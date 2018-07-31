package mazzocchi.max.dealer;

import java.util.List;
import java.util.ArrayList;

import mazzocchi.max.dealer.deck.Deck;

public class Game {

  private static final int DEFAULT_NUMBER_OF_PLAYERS = 8;

  private List<Player> players;
  private Deck deck;

  public Game(int number_of_players) {
    players = new ArrayList<Player>(number_of_players);
    deck = new Deck();
  }

  public void playRound() {
    deck.shuffle();

    // Deal the first two cards
  }

  public static void main(String[] args) {
    Game game = new Game(DEFAULT_NUMBER_OF_PLAYERS);
    game.playRound();
  }
}
