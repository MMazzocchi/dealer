package mazzocchi.max.dealer;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import mazzocchi.max.dealer.deck.Deck;

public class Game {

  private static final int DEFAULT_NUMBER_OF_PLAYERS = 8;
  private static final int USER_INDEX = 0;

  private List<Player> players;
  private int number_of_players;
  private Deck deck;
  private int dealer_index;

  public Game(int number_of_players) {
    this.number_of_players = number_of_players;
    this.deck = new Deck();
    this.dealer_index = 0;

    this.players = new ArrayList<Player>(number_of_players);
    for(int i=0; i<number_of_players; i++) {
      this.players.add(new Player());
    }
  }

  public void playRound() {
    deck.shuffle();

    Player user = players.get(USER_INDEX);
    System.out.println("==================== NEW ROUND ====================");
    System.out.println("");
    System.out.println("You are "+user);
    System.out.println("There are "+number_of_players+" players total.");
    System.out.println("");

    String dealer_str = players.get(dealer_index).toString() + " is";
    if(dealer_index == USER_INDEX) {
      dealer_str = "You are";
    }
    System.out.println(dealer_str+" the dealer.");
    System.out.println("");

    // Deal the first two cards
    int next_player = (dealer_index + 1) % number_of_players;
    for(int card=0; card<2; card++) {
      for(int i=0; i<number_of_players; i++) {
        Player player = players.get(next_player);
        player.dealCard(deck.draw());

        next_player = (next_player + 1) % number_of_players;
      }
    }

    System.out.println("Your hand:");
    System.out.println(user.hand());

    pause();
  }

  private static void pause() {
    System.out.println("Press <Enter> to continue.");
    try {
      System.in.read();

    } catch(IOException ioe) {
      System.err.println("An error occured while waiting for user input"+
        ioe.getMessage());
    }
  }

  public static void main(String[] args) {
    Game game = new Game(DEFAULT_NUMBER_OF_PLAYERS);
    game.playRound();
  }
}
