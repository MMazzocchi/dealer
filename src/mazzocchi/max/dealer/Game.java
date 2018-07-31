package mazzocchi.max.dealer;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Game {

  private static final int DEFAULT_NUMBER_OF_PLAYERS = 8;
  private static final int USER_INDEX = 0;

  private List<Player> players;
  private int number_of_players;
  private int dealer_index;

  public Game(int number_of_players) {
    this.number_of_players = number_of_players;
    this.dealer_index = 0;

    this.players = new ArrayList<Player>(number_of_players);
    for(int i=0; i<number_of_players; i++) {
      this.players.add(new Player());
    }
  }

  public void playRound() {

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

    Round round = new Round(players, dealer_index);

    // Initial deal
    round.deal();

    System.out.println("Your hand:");
    System.out.println(user.hand());

    pause();

    // Flop
    round.flop();

    System.out.println("Flop:");
    System.out.println(round.tableHand());

    pause();

    // Turn
    round.turn();

    System.out.println("Turn: ");
    System.out.println(round.tableHand());

    pause();

    // River
    round.river();

    System.out.println("River: ");
    System.out.println(round.tableHand());

    pause();

    // Complete round
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
